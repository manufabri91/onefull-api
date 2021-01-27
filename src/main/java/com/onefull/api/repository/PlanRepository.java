package com.onefull.benefitapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.benefitapi.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
