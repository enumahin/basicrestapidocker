package com.alienworkspace.basicrestapidocker.service.impl;

import com.alienworkspace.basicrestapidocker.model.Employee;
import com.alienworkspace.basicrestapidocker.repository.EmployeeRepository;
import com.alienworkspace.basicrestapidocker.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteById(Long employeeId) {
         employeeRepository.deleteById(employeeId);
    }
}
