package com.onefull.api.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onefull.api.dto.BenefitRequestDto;
import com.onefull.api.dto.BenefitResponseDto;
import com.onefull.api.service.BenefitService;

@RestController
@RequestMapping("/beneficios")
public class BenefitController {
	
	private BenefitService benefitService;
	
	@Autowired
	public BenefitController(
			BenefitService benefitService) {
		this.benefitService = benefitService;
	}	

	@GetMapping
    @ResponseStatus(HttpStatus.OK)
	public List<BenefitResponseDto> getAllBenefits(@RequestParam(name = "rubro") Optional<Long> typeId,
													@RequestParam(name = "localidad") Optional<Long> localityId,
													@RequestParam(name = "proveedor") Optional<Long> supplierId) {
		return this.benefitService.fetchAllBenefits(typeId, localityId, supplierId);
	}
	
	@GetMapping("/{benefitId}")
    @ResponseStatus(HttpStatus.OK)
	public BenefitResponseDto getById(@PathVariable Long benefitId) {
		return this.benefitService.fetchById(benefitId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BenefitResponseDto addBenefit(@Valid @RequestBody BenefitRequestDto benefitDto) {
		return this.benefitService.save(benefitDto);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public BenefitResponseDto updateBenefit(@Valid @RequestBody BenefitRequestDto benefitDto) {
		return this.benefitService.update(benefitDto);
	}
	
	@DeleteMapping("/{benefitId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBenefitById(@PathVariable Long benefitId) {
		this.benefitService.deleteById(benefitId);
	}
	
}
