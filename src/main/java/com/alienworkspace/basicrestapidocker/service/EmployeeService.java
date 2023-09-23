package com.alienworkspace.basicrestapidocker.service;

import com.alienworkspace.basicrestapidocker.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee create(Employee employee);

    Employee update(Employee employee);

    Optional<Employee> findById(Long employeeId);

    List<Employee> findAll();

    void deleteById(Long employeeId);

}
