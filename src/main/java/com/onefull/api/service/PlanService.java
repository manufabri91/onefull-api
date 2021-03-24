package com.onefull.api.service;

import java.util.List;
import java.util.Optional;

import com.onefull.api.dto.PlanRequestDto;
import com.onefull.api.dto.PlanResponseDto;

public interface PlanService {

	PlanResponseDto save(PlanRequestDto planRequest);
	PlanResponseDto update(PlanRequestDto planRequest); 
	PlanResponseDto fetchById(Long planId);
    List<PlanResponseDto> fetchAllPlans(Optional<Long> localityId, Optional<Double> minPrice, Optional<Double> maxPrice);
    public void deleteById(Long planId);
}
