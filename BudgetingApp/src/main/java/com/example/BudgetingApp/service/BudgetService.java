package com.example.BudgetingApp.service;

import com.example.BudgetingApp.model.AllocationType;
import com.example.BudgetingApp.model.UserBudget;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Service
public class BudgetService implements Calculatable {

    // Simple Map acting as our data storage layer to save user data
    private final Map<String, UserBudget> databaseMock = new HashMap<>();

    @Override
    public Map<AllocationType, Double> calculateSplit(double salary) {
        Map<AllocationType, Double> splits = new EnumMap<>(AllocationType.class);
        for (AllocationType type : AllocationType.values()) {
            splits.put(type, salary * type.getPercentage());
        }
        return splits;
    }

    public void saveUserBudget(String username, double salary) {
        Map<AllocationType, Double> splits = calculateSplit(salary);

        UserBudget budget = new UserBudget();
        budget.setUsername(username);
        budget.setTotalSalary(salary);
        budget.setNeedsAmount(splits.get(AllocationType.NEEDS));
        budget.setWantsAmount(splits.get(AllocationType.WANTS));
        budget.setSavingsAmount(splits.get(AllocationType.SAVINGS));

        databaseMock.put(username, budget);
    }

    public UserBudget getUserBudget(String username) {
        return databaseMock.get(username);
    }
    public java.util.Collection<UserBudget> getAllSavedBudgets() {
        return databaseMock.values();
    }
}