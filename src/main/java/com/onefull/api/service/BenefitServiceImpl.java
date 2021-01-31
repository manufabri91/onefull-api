package com.onefull.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefull.api.dto.BenefitRequestDto;
import com.onefull.api.dto.BenefitResponseDto;
import com.onefull.api.model.Benefit;
import com.onefull.api.model.BenefitType;
import com.onefull.api.model.Locality;
import com.onefull.api.model.Supplier;
import com.onefull.api.repository.BenefitRepository;
import com.onefull.api.repository.BenefitTypeRepository;
import com.onefull.api.repository.LocalityRepository;
import com.onefull.api.repository.SupplierRepository;

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
		Optional<Supplier> supplier = this.supplierRepository.findById(benefitRequest.getSupplierId());
		Optional<BenefitType> benefitType = this.benefitTypeRepository.findById(benefitRequest.getTypeId());
		Optional<Locality> locality = this.localityRepository.findById(benefitRequest.getLocalityId());
		if(supplier.isPresent() && benefitType.isPresent() && locality.isPresent()) {
			benefit.setSupplier(supplier.get());
			benefit.setType(benefitType.get());
			benefit.setLocality(locality.get());
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
		Optional<Supplier> supplier = this.supplierRepository.findById(benefitRequest.getSupplierId());
		Optional<BenefitType> benefitType = this.benefitTypeRepository.findById(benefitRequest.getTypeId());
		Optional<Locality> locality = this.localityRepository.findById(benefitRequest.getLocalityId());
		if(validBenefitId && supplier.isPresent() && benefitType.isPresent() && locality.isPresent()) {
			updatedBenefit.setSupplier(supplier.get());
			updatedBenefit.setType(benefitType.get());
			updatedBenefit.setLocality(locality.get());
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
