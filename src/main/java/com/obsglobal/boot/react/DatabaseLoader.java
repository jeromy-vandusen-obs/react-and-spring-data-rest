package com.obsglobal.boot.react;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.obsglobal.boot.react.domain.model.Employee;
import com.obsglobal.boot.react.domain.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DatabaseLoader implements CommandLineRunner {
	private final EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		employeeRepository.save(new Employee("Frodo", "Baggins", "ring bearer"));
	}
}
