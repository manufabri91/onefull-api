package com.onefull.benefitapi.controller;

import java.util.List;

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

import com.onefull.benefitapi.dto.BenefitResponseDto;
import com.onefull.benefitapi.dto.SupplierDto;
import com.onefull.benefitapi.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
	

	private SupplierService supplierService;
	
	@Autowired
	public SupplierController(SupplierService supplierService) {
		this.supplierService = supplierService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<SupplierDto> getAllSuppliers() {
		return this.supplierService.fetchAllSuppliers();
	}
	
	@GetMapping("/{supplierId}")
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto getSupplierById(@PathVariable Long supplierId) {
		return this.supplierService.fetchById(supplierId);
	}
	
	@GetMapping("/{supplierId}/benefits")
	@ResponseStatus(HttpStatus.OK)
	public List<BenefitResponseDto> getBenefitsBySupplierId(@PathVariable Long supplierId) {
		return this.supplierService.fetchBenefitsBySupplierId(supplierId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public SupplierDto add(@RequestBody SupplierDto supplier) {
		return this.supplierService.save(supplier);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public SupplierDto update(@RequestBody SupplierDto supplier) {
		return this.supplierService.update(supplier);
	}
	
	@DeleteMapping("/{supplierId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSupplierById(@PathVariable Long supplierId) {
		this.supplierService.deleteById(supplierId);
	}	

}
