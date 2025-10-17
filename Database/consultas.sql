
delimiter //
create trigger turno_solapado before insert on Turno for each row
	begin
		if exists(select fechaTurno, horario from Turno where Cliente_IdCliente=new.Cliente_IdCliente and fechaTurno=new.fechaTurno and horario=new.horario) then
			signal sqlstate '45000' set message_text='ya hay un turno en esa fecha a esa hora';
		end if;
end//
delimiter //
create trigger terminar_turno after update on Clinica for each row
	begin
		insert HistoriaMedico values(curdate(),(select Cliente_IdCliente from Turno where IdTurno=new.IdTurno), new.info);
	end//

delimiter //
create procedure especialidadConMayorDemanda(in fechaInicio date, in fechaFin date)
	begin
		select Especialidad.nombre, count(*) as cantidadTurnos from Turno join Medico on Medico_DNI=Medico.DNI
		join Especialidad on Especialidad_IdEspecialidad=Especialidad.IdEspecialidad
		where Turno.fechaTurno>=fechaInicio and Turno.fechaTurno<=fechaFin
		group by Especialidad.nombre order by cantidadTurnos desc;
	end //
	
delimiter //
create procedure promedioEsperaPorEspecialidad()
	begin
		select Especialidad.nombre, avg(datediff(fechaTurno,fechaPedido)) as promedioEspera from Turno join Medico on Medico_DNI=Medico.DNI
		join Especialidad on Especialidad_IdEspecialidad=Especialidad.IdEspecialidad
		group by Especialidad.nombre order by promedioEspera desc;
	end //

delimiter //
create event recordatorio_turnos_diario on schedule EVERY 1 DAY starts timestamp(current_date, '07:00:00') do begin
    insert into Notificacion (Cliente_IdCliente, descripcion) select Turno.Cliente_IdCliente,
	concat('Recordatorio: Tiene un turno programado para mañana ', date_format(Turno.fechaTurno, '%d/%m/%Y'),
            ' a las ', time_format(Turno.horario, '%H:%i'), ' con el Dr./Dra. ', Medico.nombre, ' ', Medico.apellido,
            ' en el hospital ', Hospital.nombre) 
    as descripcion from Turno join Medico on Turno.Medico_DNI = Medico.DNI
    join Hospital on Turno.Hospital_IdHospital = Hospital.IdHospital 
    where Turno.fechaTurno = date_add(current_date, interval 1 day)
    and Turno.Estado_IdEstado = 1;
end//
delimiter //
create event eliminar_turnos_vencidos on schedule every 1 day starts now() do begin
	delete Turno from Turno join Estado on Estado_IdEstado=Estado.IdEstado where Estado.nombre!="Atendido" and Estado.nombre!="Cancelado";
end//

	
	
	
	
	
	
	
	
	
	
	

	