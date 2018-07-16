package com.obsglobal.boot.react.domain.repository;

import com.obsglobal.boot.react.domain.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
