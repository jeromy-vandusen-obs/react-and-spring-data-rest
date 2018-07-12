package com.obsglobal.boot.react.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.obsglobal.boot.react.domain.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
