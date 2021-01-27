package com.onefull.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.api.model.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long> {
	List<Locality> findByHasServiceTrue();
}
