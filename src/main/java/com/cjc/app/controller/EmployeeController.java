package com.cjc.app.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.app.model.Employee;
import com.cjc.app.servicei.EmployeeServiceI;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeServiceI esi;
	
	    @RequestMapping("/")
	    public String prelogin() {
	        return "login";
	    }

	    @RequestMapping("/openregisterpage")
	    public String preregister() {
	        return "register";
	    }

	    @RequestMapping("/save")
	    public String saveEmployee(@ModelAttribute Employee e) {
	        esi.saveEmployee(e);
	        return "login";
	    }

	    @RequestMapping("/login")
	    public String loginEmployee(@RequestParam String username, @RequestParam String password, Model m) {
	    	  

	    	    if (username.equals("Admin") && password.equals("Admin")) {
	    	          List<Employee> l = esi.getAllEmployee();
	    	          m.addAttribute("data",l);
	    	          return "success";
	    	    } else {
	    	          List<Employee> l  = esi.getEmployee(username,password);
	    	          m.addAttribute("data",l);
	    	          return "success";
	    	           
	    	        }
	    	   
	    }

	    @RequestMapping("/delete")
	    public String deleteEmployee(@RequestParam int id, Model m) 
	    {
	         esi.deleteEmployee(id);
	         List<Employee> l = esi.getAllEmployee();
	         m.addAttribute("data",l);
	         return "success";
	    }
	    @RequestMapping("/edit")
	    public String editEmployee(@RequestParam int id, Model m) 
	    {
	       Employee e = esi.getSingleEmployee(id);
	        m.addAttribute("em",e);
	        return "edit";
	    }

	    @RequestMapping("/update")
	    public String updateEmployee(@ModelAttribute Employee updatedEmployee, Model m) {
	       esi.updateEmployee(updatedEmployee);
	        List<Employee> l = esi.getAllEmployee();
	        m.addAttribute("data", l);
	        return "success";
}
}