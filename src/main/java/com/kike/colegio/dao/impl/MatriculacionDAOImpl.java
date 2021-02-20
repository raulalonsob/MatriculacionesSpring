package com.kike.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.colegio.dao.MatriculacionDAO;
import com.kike.colegio.dtos.MatriculacionDTO;
import com.kike.colegio.repositorios.MatriculacionRepository;


@Service
public class MatriculacionDAOImpl implements MatriculacionDAO{
	
	@Autowired
	private MatriculacionRepository matriculacionRepository;
	
	@Override
	public List<MatriculacionDTO> obtenerMatriculaciones(Integer idAsig,
			String nombreAsig, Integer idAlum, String nombreAlum, String fecha) {
		// TODO Auto-generated method stub
		return matriculacionRepository.buscaMatriculas(idAsig, nombreAsig, idAlum, nombreAlum, fecha);
	}

	@Override
	public Integer insertarMatriculacion(String idAsignatura, String idAlumno, String tasa, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarMatriculacion(Integer idMatricula) {
		matriculacionRepository.deleteById(idMatricula);
		return 1;
	}


}
