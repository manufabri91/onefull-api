package com.onefull.benefitapi.service;

import java.util.List;

import com.onefull.benefitapi.dto.LocalityDto;

public interface LocalityService {

	LocalityDto save(LocalityDto localityRequest);
	LocalityDto update(LocalityDto localityRequest); 
	LocalityDto fetchById(Long localityId);
    List<LocalityDto> fetchAllLocalities();
    public void deleteById(Long localityId);
}
