package com.onefull.api.model.specifications;



import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.onefull.api.model.*;

public class BenefitSpecification {
	public static Specification<Benefit> equalTypeId(Optional<Long> id) {
		if(id.isEmpty()) {
			return null;
		}
		return (root, query, cb) -> {
			return cb.equal(root.get(Benefit_.TYPE).get(BenefitType_.ID), id.get());
		};
	}
	public static Specification<Benefit> equalLocalityId(Optional<Long> id) {
		if(id.isEmpty()) {
			return null;
		}
		return (root, query, cb) -> {
			return cb.equal(root.get(Benefit_.LOCALITY).get(Locality_.ID), id.get());
		};
	}
	public static Specification<Benefit> equalSupplierId(Optional<Long> id) {
		if(id.isEmpty()) {
			return null;
		}
		return (root, query, cb) -> {
			return cb.equal(root.get(Benefit_.SUPPLIER).get(Supplier_.ID), id.get());
		};
	}
}
