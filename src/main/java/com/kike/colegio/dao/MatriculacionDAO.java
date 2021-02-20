package com.kike.colegio.dao;

import java.util.List;

import com.kike.colegio.dtos.MatriculacionDTO;

public interface MatriculacionDAO {
	List<MatriculacionDTO> obtenerMatriculaciones(Integer idAsig, String nombreAsig, Integer idAlum, String nombreAlum, String fecha);
	Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha);
	Integer borrarMatriculacion(Integer idMatricula);
}
