package com.onefull.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefull.api.dto.BenefitResponseDto;
import com.onefull.api.dto.SupplierDto;
import com.onefull.api.model.Supplier;
import com.onefull.api.repository.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {

	private SupplierRepository repository;
	private ModelMapper modelMapper;
	
	@Autowired
	public SupplierServiceImpl(
			SupplierRepository repository,
			ModelMapper modelMapper
			) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}	
	
	@Override
	public SupplierDto save(SupplierDto supplierRequest) {
		Supplier supplier = this.modelMapper.map(supplierRequest, Supplier.class);
		return this.modelMapper.map(this.repository.save(supplier), SupplierDto.class);
	}

	@Override
	public SupplierDto fetchById(Long supplierId) {
		Optional<Supplier> supplier = this.repository.findById(supplierId);
		if (!supplier.isPresent()) throw new EntityNotFoundException("No se encuentra Proveedor con el ID " + supplierId);
		return this.modelMapper.map(supplier.get(), SupplierDto.class);
	}

	@Override
	public List<SupplierDto> fetchAllSuppliers() {
		return this.repository.findAll()
				.stream()
				.map(supplier -> this.modelMapper.map(supplier, SupplierDto.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public SupplierDto update(SupplierDto supplierRequest) {
		Optional<Supplier> supplier = this.repository.findById(supplierRequest.getId());
		if(!supplier.isPresent()) throw new EntityNotFoundException("No existe el proveedor que intenta actualizar");
		return this.modelMapper.map(this.repository.save(supplier.get()), SupplierDto.class);
	}
	
	@Override
	public void deleteById(Long supplierId) {
		Optional<Supplier> supplier = this.repository.findById(supplierId);
		if(!supplier.isPresent()) throw new EntityNotFoundException("No existe el proveedor que intenta eliminar");
		this.repository.deleteById(supplierId);
	}

	@Override
	public List<BenefitResponseDto> fetchBenefitsBySupplierId(Long supplierId) {
		Optional<Supplier> supplier = this.repository.findById(supplierId);
		if (!supplier.isPresent()) throw new EntityNotFoundException("No se encuentra Proveedor con el ID " + supplierId);
		return supplier.get().getBenefits()
			.stream()
			.map(benefit -> this.modelMapper.map(benefit, BenefitResponseDto.class))
			.collect(Collectors.toList());
	}	

}
