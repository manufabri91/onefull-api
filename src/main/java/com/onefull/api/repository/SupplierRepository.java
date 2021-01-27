package com.onefull.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onefull.api.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
