package com.bhaskar.wealthmanager.dto;

public class DashboardResponse {

   private double totalSalary;
   private double totalExpense;
   private double savings;
private double totalLoans;

private double interestEarned;

private double netWorth;

   public DashboardResponse(
        double totalSalary,
        double totalExpense,
        double savings,
        double totalLoans,
        double interestEarned,
        double netWorth)  {

        this.totalSalary = totalSalary;
        this.totalExpense = totalExpense;
        this.savings = savings;
        this.totalLoans = totalLoans;
        this.netWorth = netWorth;
        this.interestEarned = interestEarned;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getSavings() {
        return savings;
    }

    public double getTotalLoans() {
        return totalLoans;
    }
    public double getInterestEarned() {
    return interestEarned;
  }

    public double getNetWorth() {
        return netWorth;
    }
    ;
}