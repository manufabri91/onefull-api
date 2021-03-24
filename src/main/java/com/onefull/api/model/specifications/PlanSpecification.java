package com.onefull.api.model.specifications;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.onefull.api.model.Locality_;
import com.onefull.api.model.Plan;
import com.onefull.api.model.Plan_;

public class PlanSpecification {
	
	public static Specification<Plan> equalLocalityId(Optional<Long> localityId) {
		if(localityId.isEmpty()) {
			return null;
		}
		return (root, query, cb) -> {
			return cb.equal(root.get(Plan_.LOCALITY).get(Locality_.ID), localityId.get());
		};
	}
	
	public static Specification<Plan> betweenPrices(Optional<Double> minPrice, Optional<Double> maxPrice) {
		if(minPrice.isEmpty() && maxPrice.isEmpty()) {
			return null;
		}
		return (root, query, cb) -> {
			return cb.between(root.get(Plan_.PRICE), minPrice.orElseGet(() -> Double.MIN_VALUE), maxPrice.orElseGet(() -> Double.MAX_VALUE));
		};
	}

}
