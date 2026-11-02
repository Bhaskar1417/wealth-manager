package com.bhaskar.wealthmanager.controller;
import com.bhaskar.wealthmanager.service.LoanService;
import com.bhaskar.wealthmanager.entity.Loan;
import com.bhaskar.wealthmanager.dto.InterestResponse;
import com.bhaskar.wealthmanager.repository.LoanRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import com.bhaskar.wealthmanager.dto.DueLoanResponse;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    private final LoanRepository loanRepository;

    public LoanController(
        LoanRepository loanRepository,
        LoanService loanService) {

    this.loanRepository = loanRepository;
    this.loanService = loanService;
}

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

@PostMapping
public Loan createLoan(@RequestBody Loan loan) {
    return loanRepository.save(loan);
}
@GetMapping("/{id}")
public Loan getLoanById(@PathVariable Long id) {
    return loanRepository.findById(id).orElse(null);
}
@DeleteMapping("/{id}")
public String deleteLoan(@PathVariable Long id) {

    loanRepository.deleteById(id);

    return "Loan Deleted Successfully";
}
@PutMapping("/{id}")
public Loan updateLoan(
        @PathVariable Long id,
        @RequestBody Loan updatedLoan) {

    Loan loan =
            loanRepository.findById(id).orElse(null);

    if (loan != null) {

        loan.setBorrowerName(
                updatedLoan.getBorrowerName());

        loan.setBorrowerPhone(
                updatedLoan.getBorrowerPhone());

        loan.setPrincipalAmount(
                updatedLoan.getPrincipalAmount());

        loan.setInterestRate(
                updatedLoan.getInterestRate());

        loan.setStatus(
                updatedLoan.getStatus());

        return loanRepository.save(loan);
    }

    return null;
}
@GetMapping("/calculate")
public InterestResponse calculateInterest(
        @RequestParam double amount,
        @RequestParam double rate) {

    double interest =
            loanService.calculateSimpleInterest(
                    amount,
                    rate);

    double total =
            loanService.calculateTotalAmount(
                    amount,
                    rate);

    return new InterestResponse(
            amount,
            interest,
            total);
}
@GetMapping("/due")
public List<DueLoanResponse> getDueLoans() {

    LocalDate today = LocalDate.now();

    return loanRepository.findAll()
            .stream()
            .filter(loan ->
                    loan.getDueDate() != null
                    && !loan.getDueDate().isAfter(today))
            .map(loan -> {

                double amountToCollect =
                        loan.getPrincipalAmount()
                                + (loan.getPrincipalAmount()
                                * loan.getInterestRate()
                                / 100);

                return new DueLoanResponse(
                        loan.getBorrowerName(),
                        amountToCollect);
            })
            .collect(Collectors.toList());
}
    
}