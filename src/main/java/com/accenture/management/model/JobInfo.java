package com.accenture.management.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "job_info")
public class JobInfo extends ParentEntity {

	private static final long serialVersionUID = -9095194325380934854L;

	@NotNull
	@Column(name = "companyName")
	private String companyName;

	@NotNull
	@Column(name = "nit")
	private Long nit;

	@NotNull
	@Column(name = "salary")
	private Long salary;

	@NotNull
	@Column(name = "entryDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;

	@NotNull
	@Column(name = "customer")
	private Long customer;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getNit() {
		return nit;
	}

	public void setNit(Long nit) {
		this.nit = nit;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Long getCustomer() {
		return customer;
	}

	public void setCustomer(Long customer) {
		this.customer = customer;
	}
}
