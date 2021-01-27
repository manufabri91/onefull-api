package com.onefull.benefitapi.service;

import java.util.List;

import com.onefull.benefitapi.dto.BenefitRequestDto;
import com.onefull.benefitapi.dto.BenefitResponseDto;

public interface BenefitService {
	
	BenefitResponseDto save(BenefitRequestDto benefitRequest);
	BenefitResponseDto update(BenefitRequestDto benefitRequest);
	BenefitResponseDto fetchById(Long benefitId);
	List<BenefitResponseDto> fetchBySupplierId(Long supplierId);
	List<BenefitResponseDto> fetchByTypeId(Long typeId);
	List<BenefitResponseDto> fetchByLocalityId(Long localityId);
    List<BenefitResponseDto> fetchAllBenefits();
    public void deleteById(Long benefitId);

}
