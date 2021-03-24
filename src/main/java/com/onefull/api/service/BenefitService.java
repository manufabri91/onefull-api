package com.onefull.api.service;

import java.util.List;
import java.util.Optional;

import com.onefull.api.dto.BenefitRequestDto;
import com.onefull.api.dto.BenefitResponseDto;

public interface BenefitService {
	
	BenefitResponseDto save(BenefitRequestDto benefitRequest);
	BenefitResponseDto update(BenefitRequestDto benefitRequest);
	BenefitResponseDto fetchById(Long benefitId);
	List<BenefitResponseDto> fetchBySupplierId(Long supplierId);
	List<BenefitResponseDto> fetchByTypeId(Long typeId);
	List<BenefitResponseDto> fetchByLocalityId(Long localityId);
    List<BenefitResponseDto> fetchAllBenefits(Optional<Long> typeId, Optional<Long> localityId, Optional<Long> supplierId);
    public void deleteById(Long benefitId);

}
