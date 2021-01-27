package com.onefull.api.dto;

import java.time.LocalDate;

import com.onefull.api.model.BenefitType;
import com.onefull.api.model.Locality;
import com.onefull.api.model.Supplier;


public class BenefitResponseDto {
	
	private Long id;
	private Supplier supplier;
	private String title;
	private String description;
	private String descriptionImageUrl;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private BenefitType type;
	private Locality locality;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
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
	public BenefitType getType() {
		return type;
	}
	public void setType(BenefitType type) {
		this.type = type;
	}
	public Locality getLocality() {
		return locality;
	}
	public void setLocality(Locality localityId) {
		this.locality = localityId;
	}	
	
}
