package com.bhaskar.wealthmanager.dto;

public class DueLoanResponse {

    private String borrowerName;
    private double amountToCollect;

    public DueLoanResponse(
            String borrowerName,
            double amountToCollect) {

        this.borrowerName = borrowerName;
        this.amountToCollect = amountToCollect;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public double getAmountToCollect() {
        return amountToCollect;
    }
}