package com.onefull.api.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NotBlank(message = "El nombre es requerido")
	private String name;
	@NotNull
	@NotBlank(message = "La descripcion es requerida")
	private String description;
	@NotNull
	@Min(value = 1, message= "El valor minimo es $1")
	private Double price;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "locality_id")
	private Locality locality;
	@NotNull
	@ElementCollection
	private List<String> features;	
	
	public Plan() {
	}

	public Plan(String name, String description, Double price, Locality locality, List<String> features) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.locality = locality;
		this.features = features;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Locality getLocality() {
		return locality;
	}

	public void setLocality(Locality locality) {
		this.locality = locality;
	}

	public List<String> getFeatures() {
		return features;
	}

	public void setFeatures(List<String> features) {
		this.features = features;
	}
	
}
