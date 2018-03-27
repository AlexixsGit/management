package com.accenture.management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "credit")
public class Credit extends ParentEntity {

	private static final long serialVersionUID = -6102807398875835784L;

	@NotNull
	@Column(name = "jobInfo")
	private Long jobInfo;

	@NotNull
	@Column(name = "status")
	private String status;

	@NotNull
	@Column(name = "value")
	private Double value;

	public Long getJobInfo() {
		return jobInfo;
	}

	public void setJobInfo(Long jobInfo) {
		this.jobInfo = jobInfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
