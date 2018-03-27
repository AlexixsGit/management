package com.accenture.management.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.management.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByIdentification(Long identification);
}
