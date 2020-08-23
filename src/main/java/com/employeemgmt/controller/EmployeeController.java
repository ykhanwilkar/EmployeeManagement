package com.employeemgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeemgmt.model.Employee;
import com.employeemgmt.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/addEmployee")
	public void addEmployee(@RequestBody Employee employee, @RequestParam(name="id") Integer managerId) {
		employeeService.addEmployee(employee, managerId);
	}
	
	@GetMapping("/removeEmployee")
	public void removeEmployee(@RequestParam(name="id") Integer employeeId) {
		employeeService.removeEmployee(employeeId);
	}

}
