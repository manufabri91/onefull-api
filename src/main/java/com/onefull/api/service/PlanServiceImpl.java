package com.onefull.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specification.where;
import org.springframework.stereotype.Service;

import com.onefull.api.dto.PlanRequestDto;
import com.onefull.api.dto.PlanResponseDto;
import com.onefull.api.model.Locality;
import com.onefull.api.model.Plan;
import com.onefull.api.model.specifications.PlanSpecification;
import com.onefull.api.repository.LocalityRepository;
import com.onefull.api.repository.PlanRepository;

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
		Optional<Locality> selectedLocality = this.localityRepository.findById(planRequest.getLocalityId());
		if(!selectedLocality.isPresent()) throw new EntityNotFoundException("No existe la localidad seleccionada para el plan");
		plan.setLocality(selectedLocality.get());
		return this.modelMapper.map(this.planRepository.save(plan), PlanResponseDto.class);
	}

	@Override
	public PlanResponseDto update(PlanRequestDto planRequest) {
		Optional<Plan> existingPlan = this.planRepository.findById(planRequest.getId());
		Optional<Locality> selectedLocality = this.localityRepository.findById(planRequest.getLocalityId());
		if(!existingPlan.isPresent() || !selectedLocality.isPresent()) throw new EntityNotFoundException("No existe el plan que intentó actualizar o la localidad seleccionada");
		this.modelMapper.map(planRequest, existingPlan.get());
		return this.modelMapper.map(this.planRepository.save(existingPlan.get()), PlanResponseDto.class);
	}

	@Override
	public PlanResponseDto fetchById(Long planId) {
		Optional<Plan> plan = this.planRepository.findById(planId);
		if (!plan.isPresent()) throw new EntityNotFoundException("No se encuentra plan con el ID " + planId);
		return this.modelMapper.map(plan.get(), PlanResponseDto.class);
	}

	@Override
	public List<PlanResponseDto> fetchAllPlans(Optional<Long> localityId, Optional<Double> minPrice, Optional<Double> maxPrice) {
		return this.planRepository.findAll(
				where(PlanSpecification.equalLocalityId(localityId))
				.and(PlanSpecification.betweenPrices(minPrice, maxPrice))
			)
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
