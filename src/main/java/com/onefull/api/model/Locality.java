package com.onefull.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Locality {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank(message = "El nombre es requerido")
	private String name;
	@NotNull
	private Boolean hasService;
	@OneToMany(mappedBy = "locality", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Plan> plans;
	
	
	public Locality() {
	}

	public Locality(String name, Boolean hasService) {
		this.name = name;
		this.hasService = hasService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public Boolean getHasService() {
		return hasService;
	}

	public void setHasService(Boolean hasService) {
		this.hasService = hasService;
	}
	
	
}
