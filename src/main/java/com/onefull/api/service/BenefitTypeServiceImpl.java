package com.onefull.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefull.api.dto.BenefitTypeDto;
import com.onefull.api.model.BenefitType;
import com.onefull.api.repository.BenefitTypeRepository;

@Service
public class BenefitTypeServiceImpl implements BenefitTypeService {
	

	private BenefitTypeRepository benefitTypeRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public BenefitTypeServiceImpl(BenefitTypeRepository benefitTypeRepository, ModelMapper modelMapper) {
		this.benefitTypeRepository = benefitTypeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public BenefitTypeDto save(BenefitTypeDto benefitTypeRequest) {
		BenefitType benefitType = this.modelMapper.map(benefitTypeRequest, BenefitType.class);
		return this.modelMapper.map(this.benefitTypeRepository.save(benefitType), BenefitTypeDto.class);
	}

	@Override
	public BenefitTypeDto update(BenefitTypeDto benefitTypeRequest) {
		BenefitType updatedBenefitType = this.modelMapper.map(benefitTypeRequest, BenefitType.class);
		boolean validBenefitType = this.benefitTypeRepository.findById(updatedBenefitType.getId()).isPresent();
		if (!validBenefitType) throw new EntityNotFoundException("No existe el tipo de beneficio que intentó actualizar");
		return this.modelMapper.map(this.benefitTypeRepository.save(updatedBenefitType), BenefitTypeDto.class);
	}

	@Override
	public BenefitTypeDto fetchById(Long benefitTypeId) {
		Optional<BenefitType> benefitType = this.benefitTypeRepository.findById(benefitTypeId);
		if (!benefitType.isPresent()) throw new EntityNotFoundException("No se encuentra rubro con el ID " + benefitTypeId);
		return this.modelMapper.map(benefitType.get(), BenefitTypeDto.class);
	}

	@Override
	public List<BenefitTypeDto> fetchAllBenefitTypes() {
		return this.benefitTypeRepository
			.findAll()
			.stream()
			.map(benefitType -> this.modelMapper.map(benefitType, BenefitTypeDto.class))
			.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long benefitTypeId) {
		Optional<BenefitType> benefitType = this.benefitTypeRepository.findById(benefitTypeId);
		if (!benefitType.isPresent()) throw new EntityNotFoundException("No se encuentra rubro con el ID " + benefitTypeId);
		this.benefitTypeRepository.delete(benefitType.get());		
	}


}
