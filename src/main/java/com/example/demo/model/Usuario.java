package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.example.demo.view.AreaView;
import com.example.demo.view.UsuarioView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ UsuarioView.UsuarioResumido.class, AreaView.AreaCompleta.class })
	private Integer id;

	@JsonView({ UsuarioView.UsuarioResumido.class, AreaView.AreaCompleta.class })
	private String nome;

	@JoinColumn(name = "area_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	@JsonView({ UsuarioView.UsuarioCompleto.class })
	private Area area;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "usuarios")
	private Set<Caracteristica> caracteristicas = new HashSet<Caracteristica>();

	@Transient
	private Integer areaId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

}
