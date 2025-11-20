/*1*/
delimiter //
create trigger turno_solapado before insert on turno for each row
	begin
		if exists(select fecha_turno, horario from turno where cliente_usuario_id_usuario=new.cliente_usuario_id_usuario and fecha_turno=new.fecha_turno and horario=new.horario) then
			signal sqlstate '45000' set message_text='ya hay un turno en esa fecha a esa hora';
		end if;
end//

/*testeo 1*/



/*2*/
delimiter //
create trigger terminar_turno after update on turno for each row
	begin
		insert historia_medico values(curdate(), new.info, old.cliente_usuario_id_usuario);
	end//
    
/*3*/
delimiter //
create procedure especialidad_con_mayor_demanda(in fecha_start varchar(45), in fecha_end varchar(45))
begin
    declare fecha_inicio date;
    declare fecha_fin date;
    
    set fecha_inicio = STR_TO_DATE(fecha_start, '%Y-%m-%d');
    set fecha_fin = STR_TO_DATE(fecha_end, '%Y-%m-%d');
    
    select especialidad.nombre as especialidad, count(*) as cantidad_turnos from turno
		join medico on turno.medico_usuario_id_usuario = medico.usuario_id_usuario
		join especialidad on medico.especialidad_id_especialidad = especialidad.id_especialidad
		where turno.fecha_turno >= fecha_inicio and turno.fecha_turno <= fecha_fin
		group by especialidad.id_especialidad, especialidad.nombre 
		order by cantidad_turnos desc;
end //

	
/*4*/
delimiter //
create procedure promedio_espera_por_especialidad()
	begin
		select especialidad.nombre, avg(datediff(fecha_turno,fecha_pedido)) as promedio_espera from turno join medico on medico_usuario_id_usuario=medico.usuario_id_usuario
		join especialidad on especialidad_id_especialidad=especialidad.id_especialidad
		group by especialidad.nombre order by promedio_espera desc;
	end //

/*5*/
delimiter //
create event recordatorio_turnos_diario on schedule EVERY 1 DAY starts timestamp(current_date, '07:00:00') do begin
    insert into notificacion (cliente_usuario_id_usuario, descripcion) 
	select 
		turno.cliente_usuario_id_usuario,
		concat('Recordatorio: Tiene un turno programado para mañana ', 
			   date_format(turno.fecha_turno, '%d/%m/%Y'),
			   ' a las ', time_format(turno.horario, '%H:%i'), 
			   ' con el Dr./Dra. ', usuario.nombre,
			   ' en ', hospital.nombre) as descripcion 
	from turno
	join medico on turno.medico_usuario_id_usuario = medico.usuario_id_usuario
	join usuario on medico.usuario_id_usuario = usuario.id_usuario
	join hospital on turno.hospital_id_hospital = hospital.id_hospital 
	where turno.fecha_turno = date_add(current_date, interval 1 day) and turno.estado_id_estado = 1;
end//

/*6*/
delimiter //
create event eliminar_turnos_vencidos on schedule every 1 day starts now() do begin
start transaction;
delete from imagen where estudio_id_turno in (
    select id_turno from turno where estado_id_estado != 2
);
delete from estudio where id_turno in (
    select id_turno from turno where estado_id_estado != 2
);
delete from clinica where id_turno in (
    select id_turno from turno where estado_id_estado != 2
);
delete from turno where estado_id_estado != 2;
commit;
end//
