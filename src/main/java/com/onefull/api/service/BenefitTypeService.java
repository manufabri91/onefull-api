package com.onefull.api.service;

import java.util.List;

import com.onefull.api.dto.BenefitTypeDto;

public interface BenefitTypeService {
	BenefitTypeDto save(BenefitTypeDto benefitTypeRequest);
	BenefitTypeDto update(BenefitTypeDto benefitTypeRequest); 
	BenefitTypeDto fetchById(Long benefitTypeId);
    List<BenefitTypeDto> fetchAllBenefitTypes();
    public void deleteById(Long benefitTypeId);
}
