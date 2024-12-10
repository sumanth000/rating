package com.rating.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="employeeid")
    private Integer employeeid;
	@Column(name="name")

    private String name;
	@Column(name="email")
    private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
