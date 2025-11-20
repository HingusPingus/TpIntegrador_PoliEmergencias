/*testeo ejercicio 1*/
insert into turno values(null, '2025-10-20', '2025-10-25', '18:00:00', '01:00:00', 1, 1, 17, 6, null);


/*testeo ejercicio 2*/
update turno set info="fallecimiento por torcedura de tobillo", duracion='01:00:00', estado_id_estado=2 where id_turno=10;

/*testeo ejercicio 3*/
insert into usuario values(null, "nvidao", "bvdsusi", "DOCTOR", 12587763);
insert into medico values(1538465115, 2, null, 24);

call especialidad_con_mayor_demanda("2025-10-01", "2025-12-31");

/*testeo ejercicio 4*/
call promedio_espera_por_especialidad();

/*testeo ejercicio 5*/
drop event recordatorio_turnos_diario;

insert into turno values(null, '2025-11-10', '2025-11-21', '18:00:00', '01:00:00', 1, 1, 17, 6, null);
insert into turno values(null, '2025-10-10', '2025-11-21', '18:00:00', '01:00:00', 1, 1, 18, 21, null);
insert into turno values(null, '2025-10-12', '2025-11-21', '19:00:00', '01:00:00', 1, 1, 17, 21, null);
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
    
/*testeo ejercicio 6*/

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
