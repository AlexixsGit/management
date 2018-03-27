package com.accenture.management.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.accenture.management.model.Customer;

@Transactional
public interface CustomerService {

	List<Customer> findCustomersByIdentification(Long identification);

	Customer save(Customer customer);
}
