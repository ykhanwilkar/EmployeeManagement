package com.employeemgmt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeemgmt.model.Employee;

@Repository
@Transactional
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
	@Query(value="SELECT * FROM EMPLOYEE EMP WHERE EMP.EMP_ID=?1", nativeQuery=true)
	public Employee findEmployeeById(Integer emp);
	
	@Query(value="SELECT * FROM EMPLOYEE EMP WHERE EMP.MANAGER_ID = ?1", nativeQuery = true)
	public List<Employee> findAllAssociatesFromManagerId(Integer managerId);
	
	@Modifying
	@Query(value="UPDATE EMPLOYEE E SET E.MANAGER_ID = :managerId WHERE E.EMP_ID= :empId", nativeQuery =true)
	public void updateManagerOfEmployees(@Param("managerId") Integer managerId, @Param("empId") Integer empId);
	
	@Query(value="SELECT * FROM EMPLOYEE E WHERE E.MANAGER_ID = ?1", nativeQuery= true)
	public Employee getassociate(Integer employeeId);
}
