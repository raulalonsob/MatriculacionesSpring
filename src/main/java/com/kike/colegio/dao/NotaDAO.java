package com.kike.colegio.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;

public interface NotaDAO {
	List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre, String asignatura, Double nota, String fecha); 
	List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha); 
	Integer insertarNota(Integer idAlumno, Integer idAsignatura, Double nota, String fecha);
	Integer actualizarNota(Integer idNota, Integer idAlumno, Integer idAsignatura, Double nota, String fecha);
	Integer eliminarNota(Integer id);
}
