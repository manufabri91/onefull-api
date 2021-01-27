package com.onefull.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.api.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
