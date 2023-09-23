package com.alienworkspace.basicrestapidocker.repository;

import com.alienworkspace.basicrestapidocker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
