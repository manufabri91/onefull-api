package com.onefull.api.dto;

import java.time.LocalDate;

public class BenefitResponseDto {
	
	private Long id;
	private SupplierDto supplier;
	private String title;
	private String description;
	private String descriptionImageUrl;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BenefitTypeDto type;
	private LocalityDto locality;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SupplierDto getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
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
	public BenefitTypeDto getType() {
		return type;
	}
	public void setType(BenefitTypeDto type) {
		this.type = type;
	}
	public LocalityDto getLocality() {
		return locality;
	}
	public void setLocality(LocalityDto localityId) {
		this.locality = localityId;
	}	
	
}
