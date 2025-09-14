package com.cjc.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.app.model.Employee;
import com.cjc.app.repoi.EmployeeRepoI;
import com.cjc.app.servicei.EmployeeServiceI;

@Service
public class EmployeeServiceImpl implements EmployeeServiceI
{
  @Autowired
  EmployeeRepoI eri;

@Override
public void saveEmployee(Employee e) {
	
	eri.save(e);
	
}

@Override
public List<Employee> getAllEmployee() {
	
	
	return eri.findAll();
}

@Override
public List<Employee> getEmployee(String username, String password) {
	
	List<Employee> l = eri.findByUsernameAndPassword(username,password);
	return l;
}

@Override
public void deleteEmployee(int id)
{
	
	eri.deleteById(id);
	
}

@Override
public Employee getSingleEmployee(int id) 
{
	Employee  e = eri.findById(id).get();
	return e;
}

@Override
public void updateEmployee(Employee updatedEmployee) 
{
	  eri.save(updatedEmployee);
}
}
