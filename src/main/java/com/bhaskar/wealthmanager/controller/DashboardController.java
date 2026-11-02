package com.bhaskar.wealthmanager.controller;

import com.bhaskar.wealthmanager.repository.LoanRepository;
import com.bhaskar.wealthmanager.dto.DashboardResponse;
import com.bhaskar.wealthmanager.entity.Expense;
import com.bhaskar.wealthmanager.entity.Loan;
import com.bhaskar.wealthmanager.entity.Salary;
import com.bhaskar.wealthmanager.repository.ExpenseRepository;

import com.bhaskar.wealthmanager.repository.SalaryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final SalaryRepository salaryRepository;
    private final ExpenseRepository expenseRepository;
    private final LoanRepository loanRepository;

    public DashboardController(
            SalaryRepository salaryRepository,
            ExpenseRepository expenseRepository,
            LoanRepository loanRepository) {

        this.salaryRepository = salaryRepository;
        this.expenseRepository = expenseRepository;
        this.loanRepository = loanRepository;
    }

    @GetMapping
    public DashboardResponse getDashboard() {

        double totalSalary =
                salaryRepository.findAll()
                        .stream()
                        .mapToDouble(salary -> salary.getAmount())
                        .sum();

        double totalExpense =
                expenseRepository.findAll()
                        .stream()
                       .mapToDouble(expense -> expense.getAmount())
                        .sum();

        double savings =
                totalSalary - totalExpense;

        double totalLoans =
                loanRepository.findAll()
                        .stream()
                        .mapToDouble(loan -> loan.getPrincipalAmount())

                        .sum();

       double interestEarned =
        loanRepository.findAll()
                .stream()
                .mapToDouble(
                        loan -> loan.getPrincipalAmount()
                                * loan.getInterestRate()
                                / 100
                )
                .sum();

double netWorth =
        savings + totalLoans + interestEarned;
        return new DashboardResponse(totalSalary, totalExpense, savings, totalLoans, interestEarned, netWorth);         
    }
}                    