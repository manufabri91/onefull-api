package com.onefull.api.controller;

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

import com.onefull.api.dto.LocalityDto;
import com.onefull.api.service.LocalityService;

@RestController
@RequestMapping("/localidades")
public class LocalityController {
	
	private LocalityService localityService;

	@Autowired
	public LocalityController(LocalityService localityService) {
		this.localityService = localityService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<LocalityDto> getAllLocalities() {
		return this.localityService.fetchAllLocalities();
	}
	
	@GetMapping("/{localityId}")
	@ResponseStatus(HttpStatus.OK)
	public LocalityDto getLocalityById(@PathVariable Long localityId) {
		return this.localityService.fetchById(localityId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LocalityDto saveLocality(@Valid @RequestBody LocalityDto localityRequest) {
		return this.localityService.save(localityRequest);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public LocalityDto updateLocality(@Valid @RequestBody LocalityDto localityRequest) {
		return this.localityService.update(localityRequest);
	}
	
	@DeleteMapping("/{localityId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteLocality(@PathVariable Long localityId) {
		this.localityService.deleteById(localityId);
	}
	
}
