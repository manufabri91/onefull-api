package com.onefull.benefitapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onefull.benefitapi.dto.BenefitTypeDto;
import com.onefull.benefitapi.service.BenefitTypeService;

@RestController
@RequestMapping("/benefitType")
public class BenefitTypeController {

	private BenefitTypeService benefitTypeService;

	@Autowired
	public BenefitTypeController(BenefitTypeService benefitTypeService) {
		this.benefitTypeService = benefitTypeService;
	}

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public List<BenefitTypeDto> getAllBenefitTypes() {
		return this.benefitTypeService.fetchAllBenefitTypes();
	}

	@GetMapping("/{benefitTypeId}")
    @ResponseStatus(HttpStatus.OK)
	public BenefitTypeDto getAllBenefitTypes(Long benefitTypeId) {
		return this.benefitTypeService.fetchById(benefitTypeId);
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public BenefitTypeDto addBenefitType(@Valid @RequestBody BenefitTypeDto benefitTypeDto) {
		return this.benefitTypeService.save(benefitTypeDto);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public BenefitTypeDto updateBenefitType(@Valid @RequestBody BenefitTypeDto benefitTypeDto) {
		return this.benefitTypeService.update(benefitTypeDto);
	}
	
	@DeleteMapping("/{benefitTypeId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBenefitType(@PathVariable Long benefitTypeId) {
		this.benefitTypeService.deleteById(benefitTypeId);
	}
	
}
