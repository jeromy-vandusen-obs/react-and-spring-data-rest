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
		employeeRepository.save(new Employee("Bilbo", "Baggins", "burglar"));
		employeeRepository.save(new Employee("Gandalf", "the Grey", "wizard"));
		employeeRepository.save(new Employee("Samwise", "Gamgee", "gardener"));
		employeeRepository.save(new Employee("Meriadoc", "Brandybuck", "pony rider"));
		employeeRepository.save(new Employee("Peregrin", "Took", "pipe smoker"));
	}
}
