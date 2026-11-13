package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void saveEmployee(Employee employee) {
        repository.save(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEmployee(int id) {
        repository.deleteById(id);
    }
}