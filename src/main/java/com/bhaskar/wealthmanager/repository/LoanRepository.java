package com.bhaskar.wealthmanager.repository;

import com.bhaskar.wealthmanager.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository
        extends JpaRepository<Loan, Long> {

}