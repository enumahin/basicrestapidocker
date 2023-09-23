package com.alienworkspace.basicrestapidocker.controller;

import com.alienworkspace.basicrestapidocker.model.Employee;
import com.alienworkspace.basicrestapidocker.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId){
        employee.setId(employeeId);
        return employeeService.findById(employeeId)
                .map(fetchedEmployee -> ResponseEntity.ok(employeeService.update(employee)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAllEmployee(){
        return employeeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") Long employeeId){
        return employeeService.findById(employeeId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}