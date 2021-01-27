package com.onefull.api.dto;

import javax.validation.constraints.NotBlank;

public class LocalityDto {
	private Long id;

	@NotBlank
	private String name;
	@NotBlank
	private Boolean hasService;

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
	public Boolean getHasService() {
		return hasService;
	}
	public void setHasService(Boolean hasService) {
		this.hasService = hasService;
	}

}
