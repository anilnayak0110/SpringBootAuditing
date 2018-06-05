package com.example.auditing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.auditing.dto.InputRequest;
import com.example.auditing.model.Employee;
import com.example.auditing.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/addEmployee")
	public String saveEmployee(@RequestBody InputRequest<Employee> request) {
		return service.saveEmployee(request);
	}

	@PutMapping("/updateEmp/{id}/{salary}")
	public String updateEmployee(@PathVariable("id") int id, @PathVariable("salary") double salary,
			@RequestBody InputRequest<Employee> request) {
		return service.updateEmployee(id, salary, request);
	}

}
