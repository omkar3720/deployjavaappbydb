package com.cjc.app.servicei;

import java.util.List;

import com.cjc.app.model.Employee;

public interface EmployeeServiceI {

	void saveEmployee(Employee e);

	List<Employee> getAllEmployee();

	List<Employee> getEmployee(String username, String password);

	void deleteEmployee(int id);

	Employee getSingleEmployee(int id);

	void updateEmployee(Employee updatedEmployee);

}
