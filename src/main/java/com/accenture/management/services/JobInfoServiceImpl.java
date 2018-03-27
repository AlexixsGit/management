package com.accenture.management.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.management.model.JobInfo;
import com.accenture.management.repositories.JobInfoRepository;

@Service
public class JobInfoServiceImpl implements JobInfoService {

	@Autowired
	private JobInfoRepository jobInfoRepository;

	@Override
	public JobInfo save(JobInfo jobInfo) {
		return this.jobInfoRepository.save(jobInfo);
	}

}
