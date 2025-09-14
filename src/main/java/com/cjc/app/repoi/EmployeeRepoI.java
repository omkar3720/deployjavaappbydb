package com.cjc.app.repoi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.app.model.Employee;

@Repository
public interface EmployeeRepoI  extends JpaRepository<Employee, Integer>
{

	List<Employee> findByUsernameAndPassword(String username, String password);

}
