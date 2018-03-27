package com.accenture.management.controllers;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.management.model.JobInfo;
import com.accenture.management.services.JobInfoService;
import com.accenture.management.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class JobInfoController {

	@Autowired
	private JobInfoService jobInfoService;

	protected ObjectMapper mapper;

	@RequestMapping(value = "/customer/saveJobInfo", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public RestResponse saveJobInfo(@RequestBody String json)
			throws JsonParseException, JsonMappingException, IOException {

		this.mapper = new ObjectMapper();
		JobInfo jobInfo = this.mapper.readValue(json, JobInfo.class);

		try {
			jobInfo = this.jobInfoService.save(jobInfo);
		} catch (Exception e) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage());
		}
		return new RestResponse(jobInfo, HttpStatus.ACCEPTED.value(), "Guardado exitoso");
	}

}
