package com.example.BudgetingApp.model;

public enum AllocationType {
    NEEDS(0.50, "Needs (50%)"),
    WANTS(0.30, "Wants (30%)"),
    SAVINGS(0.20, "Savings / Debt (20%)");

    private final double percentage;
    private final String displayName;

    AllocationType(double percentage, String displayName) {
        this.percentage = percentage;
        this.displayName = displayName;
    }

    public double getPercentage() { return percentage; }
    public String getDisplayName() { return displayName; }
}
