package com.accenture.management.controllers;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.management.model.Credit;
import com.accenture.management.services.CreditService;
import com.accenture.management.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CreditController {

	@Autowired
	private CreditService creditService;
	protected ObjectMapper mapper;

	@RequestMapping(value = "/customer/saveCredit", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public RestResponse saveCredit(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		Credit credit = this.mapper.readValue(json, Credit.class);

		try {
			credit = this.creditService.save(credit);
		} catch (Exception e) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
		}
		return new RestResponse(credit, HttpStatus.ACCEPTED.value(), "Guardado exitoso");
	}
}
