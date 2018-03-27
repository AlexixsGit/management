package com.accenture.management.services;

import org.springframework.transaction.annotation.Transactional;

import com.accenture.management.model.JobInfo;

@Transactional
public interface JobInfoService {

	JobInfo save(JobInfo jobInfo);

}
