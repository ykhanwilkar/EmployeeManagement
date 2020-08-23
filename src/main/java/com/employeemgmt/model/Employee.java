package com.employeemgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID")
	private Integer empId;
	@Column(name = "FIST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "SALARY")
	private Double salary;
	@Column(name = "PASSWORD")
	private String password;
	@ManyToOne
	@JoinColumn(name = "DESIGNATION_ID", referencedColumnName = "DESIGNATION_ID")
	private Designation designation;
	@ManyToOne
	@JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMP_ID")
	private Employee manager;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignationId(Designation designation) {
		this.designation = designation;
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
}