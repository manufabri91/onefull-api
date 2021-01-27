package com.onefull.benefitapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefull.benefitapi.dto.PlanRequestDto;
import com.onefull.benefitapi.dto.PlanResponseDto;
import com.onefull.benefitapi.model.Plan;
import com.onefull.benefitapi.repository.LocalityRepository;
import com.onefull.benefitapi.repository.PlanRepository;

@Service
public class PlanServiceImpl implements PlanService {
	
	private PlanRepository planRepository;
	private LocalityRepository localityRepository;
	private ModelMapper modelMapper;

	@Autowired
	public PlanServiceImpl(
			PlanRepository planRepository,
			LocalityRepository localityRepository,
			ModelMapper modelMapper
	) {
		this.planRepository = planRepository;
		this.localityRepository = localityRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PlanResponseDto save(PlanRequestDto planRequest) {
		Plan plan = this.modelMapper.map(planRequest, Plan.class);
		return this.modelMapper.map(this.planRepository.save(plan), PlanResponseDto.class);
	}

	@Override
	public PlanResponseDto update(PlanRequestDto planRequest) {
		boolean existingPlan = this.planRepository.findById(planRequest.getId()).isPresent();
		boolean validLocality = this.localityRepository.findById(planRequest.getLocalityId()).isPresent();
		if(!existingPlan || !validLocality) throw new EntityNotFoundException("No existe el plan que intentó actualizar o la localidad seleccionada");
		Plan plan = this.modelMapper.map(planRequest, Plan.class);
		return this.modelMapper.map(plan, PlanResponseDto.class);
	}

	@Override
	public PlanResponseDto fetchById(Long planId) {
		Optional<Plan> plan = this.planRepository.findById(planId);
		if (!plan.isPresent()) throw new EntityNotFoundException("No se encuentra plan con el ID " + planId);
		return this.modelMapper.map(plan.get(), PlanResponseDto.class);
	}

	@Override
	public List<PlanResponseDto> fetchAllPlans() {
		return this.planRepository.findAll()
			.stream()
			.map(plan -> this.modelMapper.map(plan, PlanResponseDto.class))
			.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long planId) {
		Optional<Plan> plan = this.planRepository.findById(planId);
		if (!plan.isPresent()) throw new EntityNotFoundException("No se encuentra plan con el ID " + planId);
		this.planRepository.delete(plan.get());
	}

}
