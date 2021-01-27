package com.onefull.api.service;

import java.util.List;

import com.onefull.api.dto.PlanRequestDto;
import com.onefull.api.dto.PlanResponseDto;

public interface PlanService {

	PlanResponseDto save(PlanRequestDto planRequest);
	PlanResponseDto update(PlanRequestDto planRequest); 
	PlanResponseDto fetchById(Long planId);
    List<PlanResponseDto> fetchAllPlans();
    public void deleteById(Long planId);
}
