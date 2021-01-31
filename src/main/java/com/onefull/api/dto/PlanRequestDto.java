package com.onefull.api.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PlanRequestDto {
	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	@NotNull
	private Double price;
	@NotNull
	private Long localityId;
	@NotNull
	@NotEmpty
	private List<String> features;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getLocalityId() {
		return localityId;
	}
	public void setLocalityId(Long localityId) {
		this.localityId = localityId;
	}
	public List<String> getFeatures() {
		return features;
	}
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	
	
}
