package com.bhaskar.wealthmanager.controller;

import com.bhaskar.wealthmanager.entity.Expense;
import com.bhaskar.wealthmanager.repository.ExpenseRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense*")
public class ExpenseController {

    private final ExpenseRepository expenseRepository;

    public ExpenseController(
            ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping
    public List<Expense> getAAllExpenses() {

        return expenseRepository.findAll();
    }

    @PostMapping
    public Expense createExpense(
            @RequestBody Expense expense) {

        return expenseRepository.save(expense);
    }
}