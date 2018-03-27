package com.accenture.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.management.model.JobInfo;

public interface JobInfoRepository extends JpaRepository<JobInfo, Long> {

}
