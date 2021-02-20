package com.kike.colegio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.NotaEntity;


@Repository
public interface NotaRepository extends CrudRepository<NotaEntity, Integer>{
	
	@Query(value= "select new com.kike.colegio.dtos.NotaDTO (n.id, a.id, a.nombre, asig.id, asig.nombre, n.nota, n.fecha) "
		+ "FROM com.kike.colegio.entities.NotaEntity n, com.kike.colegio.entities.AlumnoEntity a, com.kike.colegio.entities.AsignaturaEntity asig "
		+ "WHERE n.alumnos.id = a.id AND n.asignaturas.id=asig.id "
		+ "AND (a.id LIKE CONCAT('%', :idAlumno,'%') or :idAlumno is null) "
		+ "AND (a.nombre LIKE CONCAT ('%', :nombre, '%') or :nombre is null) "
		+ "AND (asig.nombre LIKE CONCAT ('%', :asignatura, '%') or :asignatura is null) "
		+ "AND (n.fecha LIKE CONCAT ('%', :fecha, '%') or :fecha is null) "
		+ "AND (n.nota LIKE CONCAT ('%', :nota, '%') or :nota is null) ")
	 List<NotaDTO>buscaNota(@Param("idAlumno") Integer id, @Param("nombre")String nombre, @Param("asignatura")String asignatura,@Param("nota")Double nota,@Param("fecha")String fecha);
	
}
