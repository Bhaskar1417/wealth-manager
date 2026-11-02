package com.bhaskar.wealthmanager.controller;

import com.bhaskar.wealthmanager.entity.Salary;
import com.bhaskar.wealthmanager.repository.SalaryRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryRepository salaryRepository;

    public SalaryController(
            SalaryRepository salaryRepository) {

        this.salaryRepository = salaryRepository;
    }

    @GetMapping
    public List<Salary> getAllSalary() {

        return salaryRepository.findAll();
    }

    @PostMapping
    public Salary createSalary(
            @RequestBody Salary salary) {

        return salaryRepository.save(salary);
    }
}