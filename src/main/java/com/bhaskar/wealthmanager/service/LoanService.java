package com.bhaskar.wealthmanager.service;

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public double calculateSimpleInterest(
            double principal,
            double rate) {

        return principal * rate / 100;
    }

    public double calculateTotalAmount(
            double principal,
            double rate) {

        double interest =
                calculateSimpleInterest(
                        principal,
                        rate);

        return principal + interest;
    }
}