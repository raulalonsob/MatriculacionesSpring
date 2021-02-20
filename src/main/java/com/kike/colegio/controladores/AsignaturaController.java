package com.kike.colegio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kike.colegio.dao.AsignaturaDAO;
import com.kike.colegio.dao.ComboDAO;

@Controller
public class AsignaturaController {
	
	@Autowired
	private ComboDAO combo;
	@Autowired
	private AsignaturaDAO asignaturaImpl;
	
	//Listado asignaturas
	@GetMapping(value = "listadoasignaturas")
	public String FormularioListadoAsignaturas(ModelMap model) {
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	
	@PostMapping(value = "listadoasignaturas")
	public String listarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model) {
		
		
		model.addAttribute("lista", asignaturaImpl.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		return "vistas/asignaturas/listadoAsignaturas";
	}
	
	//INsertar asignaturas
	@GetMapping(value = "insertarasignatura")
	public String formularioInsertarAsignatura(ModelMap model) {
		
		return "vistas/asignaturas/insertarAsignaturas";		
	}
	
	@PostMapping(value = "insertarasignatura")
	public String InsertarAlumno(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model){
			
		model.addAttribute("resultado", asignaturaImpl.actualizarAsignatura(id, nombre, curso, tasa));
		return "vistas/asignaturas/insertarAsignaturas";	
		
	}
	
	//Actualizar asignaturas
	
	@GetMapping(value = "formularioactualizarasignatura")
	public String FormularioActualizarAsignaturas() {
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "formularioactualizarasignatura")
	public String FormularioActualizarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre,
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model) {
		
		model.addAttribute("lista", asignaturaImpl.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
		model.addAttribute("listaAsignatura", combo.comboMunicipios());
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	@PostMapping(value = "actualizarasignatura")
	public String ActualizarAsignaturas(
			@RequestParam(value = "id", required = false) Integer id , 
			@RequestParam("nombre") String nombre, 
			@RequestParam(value="curso",required = false) Integer curso,
			@RequestParam(value="tasa", required = false) Double tasa,
			ModelMap model){	
				
		model.addAttribute("resultado", asignaturaImpl.actualizarAsignatura(id, nombre, curso, tasa));		
		
		return "vistas/asignaturas/actualizarAsignaturas";
	}
	
	//Borrar alumnos
		
	@GetMapping(value = "formularioborrarasignatura")
		public String MostrarFormularioBorrarAsignaturas() {
			return "vistas/asignaturas/borrarAsignaturas";
		}
		
		@PostMapping(value = "formularioborrarasignatura")
		public String FormularioBorrarAsignaturas(
				@RequestParam(value = "id", required = false) Integer id , 
				@RequestParam("nombre") String nombre, 
				@RequestParam(value="curso",required = false) Integer curso,
				@RequestParam(value="tasa", required = false) Double tasa,
				ModelMap model) {
			
			model.addAttribute("lista", asignaturaImpl.obtenerAsignaturaPorIdNombreCursoTasa(id, nombre, curso, tasa));
			return "vistas/asignaturas/borrarAsignaturas";
		}
		
		@PostMapping(value = "borrarasignatura")
		public String BorrarAsignaturas(
				@RequestParam(value = "id") Integer id,
				ModelMap modelMap) {
			
			modelMap.addAttribute("resultado", asignaturaImpl.eliminarAsignatura(id));
			return "vistas/asignaturas/borrarAsignaturas";
		}

}
