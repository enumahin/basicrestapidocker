package com.alienworkspace.basicrestapi.repository;

import com.alienworkspace.basicrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
