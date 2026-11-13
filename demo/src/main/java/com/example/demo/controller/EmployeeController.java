package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/employees")
    public String employees(Model model) {

        model.addAttribute(
                "employees",
                service.getAllEmployees()
        );

        return "employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {

        model.addAttribute(
                "employee",
                new Employee()
        );

        return "add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute Employee employee) {

        service.saveEmployee(employee);

        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(
            @PathVariable int id) {

        service.deleteEmployee(id);

        return "redirect:/employees";
    }
}