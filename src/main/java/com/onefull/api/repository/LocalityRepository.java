package com.onefull.benefitapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.benefitapi.model.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
	List<Locality> findByHasServiceTrue();
}
