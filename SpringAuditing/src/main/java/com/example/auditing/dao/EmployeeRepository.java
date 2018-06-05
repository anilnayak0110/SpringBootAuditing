package com.example.auditing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auditing.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
