package com.onefull.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.onefull.api.model.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit, Long>, JpaSpecificationExecutor<Benefit>{

	List<Benefit> findBySupplier_Id(Long id);
	List<Benefit> findByLocality_Id(Long id);
	List<Benefit> findByType_Id(Long id);

}
