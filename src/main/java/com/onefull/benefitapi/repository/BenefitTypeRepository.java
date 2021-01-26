package com.onefull.benefitapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.benefitapi.model.BenefitType;

public interface BenefitTypeRepository extends JpaRepository<BenefitType, Long> {

}
