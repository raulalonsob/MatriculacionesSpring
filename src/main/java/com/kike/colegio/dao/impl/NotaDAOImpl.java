package com.kike.colegio.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kike.colegio.dao.NotaDAO;
import com.kike.colegio.dtos.NotaDTO;
import com.kike.colegio.entities.AlumnoEntity;
import com.kike.colegio.entities.AsignaturaEntity;
import com.kike.colegio.entities.NotaEntity;
import com.kike.colegio.repositorios.AlumnoRepository;
import com.kike.colegio.repositorios.AsignaturaRepository;
import com.kike.colegio.repositorios.NotaRepository;

@Service
public class NotaDAOImpl implements NotaDAO {
	@Autowired
	private NotaRepository notaRepository;
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;
	
	@Override
	public List<NotaDTO> obtenerNotaPorIdNombreAsignaturaNotaFecha(Integer idAlumno, String nombre, String asignatura,
			Double nota, String fecha) {
		return notaRepository.buscaNota(idAlumno, nombre, asignatura, nota, fecha);
	}

	@Override
	public List<NotaDTO> obtenerNotaPorNombreAsignaturaFecha(String nombre, String asignatura, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertarNota(Integer idAlumno, Integer idAsignatura, Double nota, String fecha) {
		

		AlumnoEntity alumnoEntity = alumnoRepository.findById(idAlumno).get();
		AsignaturaEntity asignaturasEntity = asignaturaRepository.findById(idAsignatura).get();
		NotaEntity notas = new NotaEntity(alumnoEntity, asignaturasEntity, nota, fecha);

		notaRepository.save(notas);
		return 1;
		}
	

	@Override
	public Integer actualizarNota(Integer idNota, Integer idAlumno, Integer idAsignatura, Double nota, String fecha) {

		AlumnoEntity alumnoEntity = alumnoRepository.findById(idAlumno).get();
		AsignaturaEntity asignaturasEntity = asignaturaRepository.findById(idAsignatura).get();
		NotaEntity notas = new NotaEntity(idNota, alumnoEntity, asignaturasEntity, nota, fecha);

		notaRepository.save(notas);
		return 1;
	}

	@Override
	public Integer eliminarNota(Integer id) {
		notaRepository.deleteById(id);
		return 1;
	}

}
