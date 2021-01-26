package com.onefull.benefitapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefull.benefitapi.dto.BenefitRequestDto;
import com.onefull.benefitapi.dto.BenefitResponseDto;
import com.onefull.benefitapi.model.Benefit;
import com.onefull.benefitapi.repository.BenefitRepository;
import com.onefull.benefitapi.repository.BenefitTypeRepository;
import com.onefull.benefitapi.repository.LocalityRepository;
import com.onefull.benefitapi.repository.SupplierRepository;

@Service
public class BenefitServiceImpl implements BenefitService {

	private BenefitRepository benefitRepository;
	private SupplierRepository supplierRepository;
	private LocalityRepository localityRepository;
	private BenefitTypeRepository benefitTypeRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public BenefitServiceImpl(
			BenefitRepository benefitRepository,
			SupplierRepository supplierRepository,
			BenefitTypeRepository benefitTypeRepository,
			LocalityRepository localityRepository,
			ModelMapper modelMapper
			) {
		this.benefitRepository = benefitRepository;
		this.supplierRepository = supplierRepository;
		this.localityRepository = localityRepository;
		this.benefitTypeRepository = benefitTypeRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public BenefitResponseDto save(BenefitRequestDto benefitRequest) {
		Benefit benefit = modelMapper.map(benefitRequest, Benefit.class);
		boolean validSupplierId = this.supplierRepository.findById(benefitRequest.getSupplierId()).isPresent();
		boolean validTypeId = this.benefitTypeRepository.findById(benefitRequest.getTypeId()).isPresent();
		boolean validLocalityId = this.localityRepository.findById(benefitRequest.getLocalityId()).isPresent();
		if(validSupplierId && validTypeId && validLocalityId) {
			return this.modelMapper.map(this.benefitRepository.save(benefit), BenefitResponseDto.class);
		}
		throw new EntityNotFoundException("No se puede crear el beneficio, revise dependencias");
	}

	@Override
	public BenefitResponseDto fetchById(Long benefitId) {
		Optional<Benefit> benefit = this.benefitRepository.findById(benefitId);
		if (benefit.isPresent()) {
			return modelMapper.map(benefit.get(), BenefitResponseDto.class);
		}
		throw new EntityNotFoundException("No se encuentra Beneficio con el ID " + benefitId);
	}

	@Override
	public List<BenefitResponseDto> fetchAllBenefits() {
		return this.benefitRepository
				.findAll()
				.stream()
				.map(benefit -> modelMapper.map(benefit, BenefitResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public BenefitResponseDto update(BenefitRequestDto benefitRequest) {
		Benefit updatedBenefit = this.modelMapper.map(benefitRequest, Benefit.class);
		boolean validBenefitId = this.benefitRepository.findById(benefitRequest.getId()).isPresent();
		boolean validSupplierId = this.supplierRepository.findById(benefitRequest.getSupplierId()).isPresent();
		boolean validTypeId = this.benefitTypeRepository.findById(benefitRequest.getTypeId()).isPresent();
		boolean validLocalityId = this.localityRepository.findById(benefitRequest.getLocalityId()).isPresent();
		if(validBenefitId && validSupplierId && validTypeId && validLocalityId) {
			return this.modelMapper.map(this.benefitRepository.save(updatedBenefit), BenefitResponseDto.class);
		}
		throw new EntityNotFoundException("No se puede actualizar el beneficio, revise dependencias");
	}

	@Override
	public void deleteById(Long benefitId) {
		Optional<Benefit> benefit = this.benefitRepository.findById(benefitId);
		if (!benefit.isPresent()) throw new EntityNotFoundException("No se encuentra Beneficio con el ID " + benefitId);
		this.benefitRepository.deleteById(benefitId);
	}

	@Override
	public List<BenefitResponseDto> fetchBySupplierId(Long supplierId) {
		if (!this.supplierRepository.findById(supplierId).isPresent()) throw new EntityNotFoundException("No se encuentra proveedor con el ID " + supplierId);
		return this.benefitRepository
				.findBySupplier_Id(supplierId)
				.stream()
				.map(benefit -> this.modelMapper.map(benefit, BenefitResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BenefitResponseDto> fetchByTypeId(Long typeId) {
		if (!this.benefitTypeRepository.findById(typeId).isPresent()) throw new EntityNotFoundException("No se encuentra rubro con el ID " + typeId);
		return this.benefitRepository
				.findByType_Id(typeId)
				.stream()
				.map(benefit -> this.modelMapper.map(benefit, BenefitResponseDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<BenefitResponseDto> fetchByLocalityId(Long localityId) {
		if(this.benefitTypeRepository.findById(localityId).isPresent()) throw new EntityNotFoundException("No se encuentra localidad con el ID " + localityId);			
		return this.benefitRepository
				.findByLocality_Id(localityId)
				.stream()
				.map(benefit -> this.modelMapper.map(benefit, BenefitResponseDto.class))
				.collect(Collectors.toList());
	}
	
}