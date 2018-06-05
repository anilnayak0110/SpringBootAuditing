package com.example.auditing.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.auditing.dao.EmployeeRepository;
import com.example.auditing.dto.InputRequest;
import com.example.auditing.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public String saveEmployee(InputRequest<Employee> request) {
		String currentUser = request.getLoogedInUser();
		request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
		
		Employee emp = request.getEmployee();
		emp.setCreatedBy(currentUser);
		empRepo.save(emp);
		return "Employee saved in DB";
	}
	
	public String updateEmployee(int id, double salary,InputRequest<Employee> request) {
		Employee emp = empRepo.findById(id).get();
		if(emp!=null) {
			emp.setSalary(salary);
			emp.setModifiedBy(request.getLoogedInUser());
			empRepo.save(emp);
		}
		else {
			throw new RuntimeException("Employee not found with id::::"+id);
		}
		return "Employee updated";
	}
}
