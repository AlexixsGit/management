package com.accenture.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.management.model.Customer;
import com.accenture.management.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findCustomersByIdentification(Long identification) {
		return customerRepository.findByIdentification(identification);
	}

	@Override
	public Customer save(Customer customer) {
		return this.customerRepository.save(customer);
	}

}
