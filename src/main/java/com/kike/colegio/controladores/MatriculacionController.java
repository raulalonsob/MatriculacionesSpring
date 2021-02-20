package com.kike.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.AlumnoDAO;
import com.kike.colegio.dao.MatriculacionDAO;

@Controller
public class MatriculacionController {

	@Autowired
	private MatriculacionDAO matriculacionImpl;
	
	//Listado matriculaciones
	@GetMapping(value="listadomatriculaciones")
	public String FormularioListadoMatriculaciones(ModelMap model) {
		return "vistas/matriculaciones/listadoMatriculaciones";
	}
	
	@PostMapping(value = "listadomatriculaciones")
	public String listarMatriculaciones(
			@RequestParam(value = "idAsig", required = false) Integer idAsig , 
			@RequestParam("nombreAsig") String nombreAsig,
			@RequestParam(value = "idAlum", required = false) Integer idAlum,
			@RequestParam("nombreAlum") String nombreAlum,
			@RequestParam("fecha") String fecha,
			@RequestParam(value = "activo", required = false) Integer activo,
			ModelMap model) {
		
		
		model.addAttribute("lista", matriculacionImpl.obtenerMatriculaciones(idAsig, nombreAsig, idAlum, nombreAlum, fecha) );
		return "vistas/matriculaciones/listadoMatriculaciones";
	}
	
	//borrar matricula
	
	//Borrar alumnos
	@GetMapping(value = "formularioborrarmatriculaciones")
	public String MostrarFormularioBorrarMatricula() {
		return "vistas/matriculaciones/borrarMatriculaciones";
	}
	
	@PostMapping(value = "formularioborrarmatriculaciones")
	public String FormularioBorrarMatricula(
			@RequestParam(value = "idAsig", required = false) Integer idAsig , 
			@RequestParam("nombreAsig") String nombreAsig,
			@RequestParam(value = "idAlum", required = false) Integer idAlum,
			@RequestParam("nombreAlum") String nombreAlum,
			@RequestParam("fecha") String fecha,
			@RequestParam(value = "activo", required = false) Integer activo,
			ModelMap model) {
		
		model.addAttribute("lista", matriculacionImpl.obtenerMatriculaciones(idAsig, nombreAsig, idAlum, nombreAlum, fecha));
		return "vistas/matriculaciones/borrarMatriculaciones";
	}
	
	@PostMapping(value = "borrarmatriculaciones")
	public String BorrarMatriculas(
			@RequestParam(value = "idMatricula") Integer idMatricula,
			ModelMap modelMap) {
		
		modelMap.addAttribute("resultado", matriculacionImpl.borrarMatriculacion(idMatricula));
		return "vistas/matriculaciones/borrarMatriculaciones";
	}
	
	
	
}
