package com.events.laMem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.laMem.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
