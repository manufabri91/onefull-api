package com.onefull.api.dto;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class BenefitRequestDto {

	private Long id;
	@NotNull
	private Long supplierId;
	@NotBlank
	private String title;
	@NotBlank
	private String description;
	@NotBlank
	private String descriptionImageUrl;
	@NotNull
	private LocalDate dateFrom;
	@NotNull
	@Future
	private LocalDate dateTo;
	@NotNull
	private Long typeId;
	@NotNull
	private Long localityId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescriptionImageUrl() {
		return descriptionImageUrl;
	}
	public void setDescriptionImageUrl(String descriptionImageUrl) {
		this.descriptionImageUrl = descriptionImageUrl;
	}
	public LocalDate getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}
	public LocalDate getDateTo() {
		return dateTo;
	}
	public void setDateTo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Long getLocalityId() {
		return localityId;
	}
	public void setLocalityId(Long localityId) {
		this.localityId = localityId;
	}	
	
}
