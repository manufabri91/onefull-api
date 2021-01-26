package com.onefull.benefitapi.service;

import java.util.List;

import com.onefull.benefitapi.dto.PlanRequestDto;
import com.onefull.benefitapi.dto.PlanResponseDto;

public interface PlanService {

	PlanResponseDto save(PlanRequestDto planRequest);
	PlanResponseDto update(PlanRequestDto planRequest); 
	PlanResponseDto fetchById(Long planId);
    List<PlanResponseDto> fetchAllPlans();
    public void deleteById(Long planId);
}
