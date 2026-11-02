package com.bhaskar.wealthmanager.dto;

public class InterestResponse {

    private double principal;
    private double interest;
    private double totalAmount;

    public InterestResponse(
            double principal,
            double interest,
            double totalAmount) {

        this.principal = principal;
        this.interest = interest;
        this.totalAmount = totalAmount;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getInterest() {
        return interest;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}