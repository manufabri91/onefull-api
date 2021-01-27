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

import com.onefull.benefitapi.dto.PlanRequestDto;
import com.onefull.benefitapi.dto.PlanResponseDto;
import com.onefull.benefitapi.service.PlanService;

@RestController
@RequestMapping("/plan")
public class PlanController {
	private PlanService planService;

	@Autowired
	public PlanController(PlanService planService) {
		this.planService = planService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PlanResponseDto> getAllPlans() {
		return this.planService.fetchAllPlans();
	}
	
	@GetMapping("/{planId}")
	@ResponseStatus(HttpStatus.OK)
	public PlanResponseDto getPlanById(@PathVariable Long planId) {
		return this.planService.fetchById(planId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlanResponseDto savePlan(@Valid @RequestBody PlanRequestDto planRequest) {
		return this.planService.save(planRequest);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public PlanResponseDto updatePlan(@Valid @RequestBody PlanRequestDto planRequest) {
		return this.planService.update(planRequest);
	}
	
	@DeleteMapping("/{planId}")
	@ResponseStatus(HttpStatus.OK)
	public void deletePlan(@PathVariable Long planId) {
		this.planService.deleteById(planId);
	}
	
}
