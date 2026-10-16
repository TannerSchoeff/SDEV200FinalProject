package com.example.BudgetingApp.controller;

import com.example.BudgetingApp.model.UserBudget;
import com.example.BudgetingApp.service.BudgetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BudgetController {

    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/calculate")
    public String handleBudget(
            @RequestParam String username,
            @RequestParam double salary,
            Model model) {

        budgetService.saveUserBudget(username, salary);
        UserBudget savedData = budgetService.getUserBudget(username);

        model.addAttribute("budget", savedData);
        return "index";
    }

    @GetMapping("/search")
    public String searchBudget(
            @RequestParam String searchUsername,
            Model model) {

        UserBudget foundBudget = budgetService.getUserBudget(searchUsername);

        if (foundBudget != null) {
            model.addAttribute("searchedBudget", foundBudget);
        } else {
            model.addAttribute("searchError", "No budget profile found for user: " + searchUsername);
        }

        return "index";
    }
}