package com.employeemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemgmt.dao.EmployeeDAO;
import com.employeemgmt.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	public Double calculateCostOfABranch(Integer managerId) { 
		Double totalSalary = employeeDao.findEmployeeById(managerId).getSalary();
		Employee emp = employeeDao.getassociate(managerId);
		while(null!=emp) {
			totalSalary+= emp.getSalary();
		}
		
		return totalSalary;
	}
	
	public void removeEmployee(Integer employeeId) {
		Employee manager = employeeDao.findEmployeeById(employeeId).getManager();
		List<Employee> empList = employeeDao.findAllAssociatesFromManagerId(employeeId);
		if(null != empList) {
			for(Employee e: empList) {
				e.setManager(manager);
				employeeDao.updateManagerOfEmployees(e.getManager().getEmpId(), e.getEmpId());
			}
		}
		employeeDao.deleteById(employeeId);
	}
	
	public void addEmployee(Employee employee, Integer managerId) {
		employee.setManager(employeeDao.findEmployeeById(managerId));
		employeeDao.save(employee);
	}
}
