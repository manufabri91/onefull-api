package com.onefull.benefitapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.benefitapi.model.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit, Long>{

	List<Benefit> findBySupplier_Id(Long id);
	List<Benefit> findByLocality_Id(Long id);
	List<Benefit> findByType_Id(Long id);

}
