
package com.bhaskar.wealthmanager.repository;

import com.bhaskar.wealthmanager.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

}
