package com.accenture.management.controllers;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.management.model.Customer;
import com.accenture.management.services.CustomerService;
import com.accenture.management.util.QueryResult;
import com.accenture.management.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/customer/getCustomersByIdentification", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public QueryResult<Customer> getCustomersByIdentification(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		Customer customer = this.mapper.readValue(json, Customer.class);

		List<Customer> list = this.customerService.findCustomersByIdentification(customer.getIdentification());

		return new QueryResult<>(list);
	}

	@RequestMapping(value = "/customer/createCustomer", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public RestResponse createCustomer(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		Customer customer = this.mapper.readValue(json, Customer.class);

		try {
			customer = this.customerService.save(customer);
		} catch (Exception e) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
		}
		return new RestResponse(customer, HttpStatus.ACCEPTED.value(), "Guardado exitoso");
	}
}
