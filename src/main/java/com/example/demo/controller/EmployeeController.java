package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @PostMapping
    public Employee add(@RequestBody Employee e) {
        e.setStatus("ACTIVE");
        return repo.save(e);
    }

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody Employee e) {
        Employee emp = repo.findByUsernameAndPassword(e.getUsername(), e.getPassword());
        return emp != null ? "SUCCESS" : "FAIL";
    }
}
