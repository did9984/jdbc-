package com.yedam;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmpVO {
	private int employeedId; // emplyedee_id
	private String firstname;
	private String lastname;
	private String email;
	private int salary;
	private String hireDate;
	private String jobId;
	
	public int getEmployeedId() {
		return employeedId;
	}



	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public void setEmployeedId(int employeedId) {
		this.employeedId = employeedId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}
	
	@Override
	public String toString() {
		return "EmpVO [employeedId=" + employeedId + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", salary=" + salary + ", hireDate=" + hireDate + "]";
	}

}
