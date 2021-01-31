package com.onefull.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Benefit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
	private Supplier supplier;
	@NotNull
	@NotBlank(message = "El titulo es requerido")
	private String title;
	@NotNull
	@NotBlank(message = "La descripcion es requerida")
	private String description;
	private String descriptionImageUrl;
	@NotNull
	private LocalDate dateFrom;
	@NotNull
	@FutureOrPresent
	private LocalDate dateTo;
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
	private BenefitType type;
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
	private Locality locality;

	public Benefit() {
	}

	public Benefit(Supplier supplier, String title,String description, String descriptionImageUrl,
			LocalDate dateTo, LocalDate dateFrom, BenefitType type,
			Locality locality) {
		this.supplier = supplier;
		this.title = title;
		this.description = description;
		this.descriptionImageUrl = descriptionImageUrl;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.type = type;
		this.locality = locality;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
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

	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	
		
	
}