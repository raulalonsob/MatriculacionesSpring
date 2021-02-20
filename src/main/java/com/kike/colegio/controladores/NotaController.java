package com.kike.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.ComboDAO;
import com.kike.colegio.dao.NotaDAO;



@Controller
public class NotaController {
	
	@Autowired
	private ComboDAO combo;
	
	@Autowired
	private NotaDAO notaImpl;
	

	//Listado notas
	@GetMapping(value = "listadonotas")
	public String FormularioListadoNotas(ModelMap model) {
		return "vistas/notas/listadoNotas";
	}
	
	
	@PostMapping(value = "listadonotas")
	public String listarNotas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre,
			@RequestParam("asignatura") String asignatura,
			@RequestParam(value = "nota", required = false) Double nota ,
			@RequestParam("fecha") String fecha,
			ModelMap modelMap) {
		
		
		modelMap.addAttribute("lista", notaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(id, nombre, asignatura, nota, fecha));
		return "vistas/notas/listadoNotas";
	}
	
	//Insertnar nota
	
	@GetMapping(value = "insertarnota")
	public String formularioInsertarnotas(ModelMap modelMap) {
		modelMap.addAttribute("listaAlumnos", combo.comboAlumnos());
		modelMap.addAttribute("listaAsignaturas", combo.comboAsignaturas());

		return "vistas/notas/insertarNotas";
	}
	
	@PostMapping(value = "insertarnota")
	public String Insertarnota(@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap modelMap) {
		modelMap.addAttribute("listaAlumnos", combo.comboAlumnos());
		modelMap.addAttribute("listaAsignaturas", combo.comboAsignaturas());
		modelMap.addAttribute("resultado", notaImpl.insertarNota(alumno, asignatura, nota, fecha));

		return "vistas/notas/insertarNotas";
	}	
	
	
	//Actualizar nota
	
	@GetMapping(value = "formularioactualizarnota")
	public String actualizarnota(ModelMap modelMap) {
		modelMap.addAttribute("listaAlumnos", combo.comboAlumnos());
		modelMap.addAttribute("listaAsignaturas", combo.comboAsignaturas());

		return "vistas/notas/actualizarNotas";
	}
	
	@PostMapping(value = "formularioactualizarnota")
	public String formularioModificarnotas(
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignatura", required = false) String asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap modelMap) {

		
		modelMap.addAttribute("listaAlumnos", combo.comboAlumnos());
		modelMap.addAttribute("listaAsignaturas", combo.comboAsignaturas());


		modelMap.addAttribute("lista", notaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(id, alumno, asignatura, nota, fecha));

		return "vistas/notas/actualizarNotas";
	}
	
	@PostMapping(value = "actualizarnota")
	public String actualizarnota(@RequestParam(value = "idNota", required = false) Integer id,
			@RequestParam(value = "alumnos", required = false) Integer alumno,
			@RequestParam(value = "asignaturas", required = false) Integer asignatura,
			@RequestParam(value = "nota", required = false) Double nota,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap modelMap) {
		
		modelMap.addAttribute("listaAlumnos", combo.comboAlumnos());
		modelMap.addAttribute("listaAsignaturas", combo.comboAsignaturas());

		modelMap.addAttribute("resultado", notaImpl.actualizarNota(id, alumno, asignatura, nota, fecha));
		
		return "vistas/notas/actualizarNotas";
	}
	
	//borrar Nota
	
	@GetMapping(value = "formularioborrarnota")
	public String borrarnota(ModelMap model) {
		return "vistas/notas/borrarNotas";
	}
	

	
	@PostMapping(value = "formularioborrarnota")
	public String formularioBorrarnotas(
			@RequestParam(value = "alumno", required = false) String alumno,
			@RequestParam(value = "asignaturas", required = false) String asignatura,
			@RequestParam(value = "fecha", required = false) String fecha, ModelMap modelMap) {

		modelMap.addAttribute("lista", notaImpl.obtenerNotaPorIdNombreAsignaturaNotaFecha(null, alumno, asignatura, null, fecha));

		return "vistas/notas/borrarNotas";
	}	
	
	@PostMapping(value = "borrarnota")
	public String borrarnota(@RequestParam(value = "idNota", required = false) Integer id,
			 ModelMap modelMap) {
		
		modelMap.addAttribute("resultado", notaImpl.eliminarNota(id));

		return "vistas/notas/borrarNotas";
	}
		
}
	

