package com.onefull.benefitapi.service;

import java.util.List;

import com.onefull.benefitapi.dto.BenefitResponseDto;
import com.onefull.benefitapi.dto.SupplierDto;

public interface SupplierService {
	
	SupplierDto save(SupplierDto supplierRequest);
	SupplierDto update(SupplierDto supplierRequest); 
	SupplierDto fetchById(Long supplierId);
	List<BenefitResponseDto> fetchBenefitsBySupplierId(Long supplierId);
    List<SupplierDto> fetchAllSuppliers();
    public void deleteById(Long supplierId);

}
