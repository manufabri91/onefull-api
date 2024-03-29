package com.onefull.api.dto;

import java.util.List;

public class PlanResponseDto {
	private Long id;
	private String name;
	private String description;
	private Double price;
	private LocalityDto locality;
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
	public LocalityDto getLocality() {
		return locality;
	}
	public void setLocality(LocalityDto locality) {
		this.locality = locality;
	}
	public List<String> getFeatures() {
		return features;
	}
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	
}
