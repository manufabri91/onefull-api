package com.onefull.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onefull.api.dto.LocalityDto;
import com.onefull.api.model.Locality;
import com.onefull.api.repository.LocalityRepository;

@Service
public class LocalityServiceImpl implements LocalityService {
	
	private LocalityRepository localityRepository;
	private ModelMapper modelMapper;
	
	
	@Autowired	
	public LocalityServiceImpl(LocalityRepository localityRepository, ModelMapper modelMapper) {
		this.localityRepository = localityRepository;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public LocalityDto save(LocalityDto localityRequest) {
		Locality locality = this.modelMapper.map(localityRequest, Locality.class);
		return this.modelMapper.map(this.localityRepository.save(locality), LocalityDto.class);
	}

	@Override
	public LocalityDto update(LocalityDto localityRequest) {
		Optional<Locality> locality = this.localityRepository.findById(localityRequest.getId());
		if (!locality.isPresent()) throw new EntityNotFoundException("No se encontró la localidad con el ID indicado");
		this.modelMapper.map(localityRequest, locality.get());
		return this.modelMapper.map(this.localityRepository.save(locality.get()), LocalityDto.class);
	}

	@Override
	public LocalityDto fetchById(Long localityId) {
		Optional<Locality> locality = this.localityRepository.findById(localityId);
		if (!locality.isPresent()) throw new EntityNotFoundException("No se encontró la localidad con el ID indicado");
		return this.modelMapper.map(locality.get(), LocalityDto.class);
	}

	@Override
	public List<LocalityDto> fetchAllLocalities() {
		return this.localityRepository.findAll()
			.stream()
			.map(locality -> this.modelMapper.map(locality, LocalityDto.class))
			.collect(Collectors.toList());
	}

	@Override
	public void deleteById(Long localityId) {
		Optional<Locality> locality = this.localityRepository.findById(localityId);
		if (!locality.isPresent()) throw new EntityNotFoundException("No se encontró la localidad con el ID indicado");
		this.localityRepository.delete(locality.get());
	}

}
