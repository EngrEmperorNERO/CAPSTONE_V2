package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
		
	}
	@Override
	public List<Employee> getAllUser() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
}
