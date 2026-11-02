package com.bhaskar.wealthmanager.repository;

import com.bhaskar.wealthmanager.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository
        extends JpaRepository<Salary, Long> {

}