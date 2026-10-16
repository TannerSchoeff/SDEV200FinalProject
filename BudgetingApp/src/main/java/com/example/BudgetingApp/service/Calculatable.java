package com.example.BudgetingApp.service;

import com.example.BudgetingApp.model.AllocationType;
import java.util.Map;

public interface Calculatable {
    Map<AllocationType, Double> calculateSplit(double salary);
}