package com.example.BudgetingApp.model;

public class UserBudget {
    private String username;
    private double totalSalary;
    private double needsAmount;
    private double wantsAmount;
    private double savingsAmount;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public double getTotalSalary() { return totalSalary; }
    public void setTotalSalary(double totalSalary) { this.totalSalary = totalSalary; }

    public double getNeedsAmount() { return needsAmount; }
    public void setNeedsAmount(double needsAmount) { this.needsAmount = needsAmount; }

    public double getWantsAmount() { return wantsAmount; }
    public void setWantsAmount(double wantsAmount) { this.wantsAmount = wantsAmount; }

    public double getSavingsAmount() { return savingsAmount; }
    public void setSavingsAmount(double savingsAmount) { this.savingsAmount = savingsAmount; }
}