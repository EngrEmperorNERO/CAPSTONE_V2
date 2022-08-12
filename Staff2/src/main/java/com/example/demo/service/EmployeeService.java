package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

//@Service
//@Transactional
public interface EmployeeService {
	//@Autowired
	//private EmployeeRepository repo;//
	
	List<Employee> getAllUser();
		//return repo.findAll();
		//this.employeeRepository.findAll();	
	
	
	//public List<Employee> getUserdetails(){
		//return
	//}
}
