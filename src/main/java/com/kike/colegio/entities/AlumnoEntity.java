package com.kike.colegio.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class AlumnoEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "id_municipio")
	private int idMunicipio;
	
	@Column(name = "familia_numerosa")
	private int famNumerosa;
	

	public AlumnoEntity() {
		super();
	}
	
	

	public AlumnoEntity(int id) {
		super();
		this.id = id;
	}



	public AlumnoEntity(int id, String nombre, int idMunicipio, int famNumerosa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idMunicipio = idMunicipio;
		this.famNumerosa = famNumerosa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public int getFamNumerosa() {
		return famNumerosa;
	}

	public void setFamNumerosa(int famNumerosa) {
		this.famNumerosa = famNumerosa;
	}
	
	
}
