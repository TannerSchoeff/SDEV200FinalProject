<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>50/30/20 Budgeting Application</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f7f6; display: flex; gap: 40px; justify-content: center; }
        .panel { background: white; padding: 25px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); width: 400px; height: fit-content; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
        button { background-color: #27ae60; color: white; padding: 10px 15px; border: none; cursor: pointer; border-radius: 4px; width: 100%; font-weight: bold; margin-top: 5px; }
        .search-btn { background-color: #2c3e50; }
        .results { margin-top: 25px; padding: 15px; border-radius: 6px; background-color: #f9f9f9; border-left: 5px solid #27ae60; }
        .search-results { border-left-color: #2c3e50; }
        .item { margin-bottom: 10px; }
        .error { color: #c0392b; font-weight: bold; margin-top: 15px; }
    </style>
</head>
<body>

<!-- Panel 1: Create or Overwrite Budget -->
<div class="panel">
    <h2>1. Calculate & Save</h2>
    <form action="/calculate" method="POST">
        <div class="form-group">
            <label for="username">Your Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="salary">Total Monthly Salary ($):</label>
            <input type="number" id="salary" name="salary" step="0.01" required>
        </div>
        <button type="submit">Save My Budget</button>
    </form>

    <c:if test="${budget != null}">
        <div class="results">
            <h3>Latest Calculations Saved!</h3>
            <div class="item"><strong>User:</strong> <c:out value="${budget.username}"/></div>
            <div class="item"><strong>Income:</strong> $${budget.totalSalary}</div>
            <div class="item"><strong>Needs (50%):</strong> $${budget.needsAmount}</div>
            <div class="item"><strong>Wants (30%):</strong> $${budget.wantsAmount}</div>
            <div class="item"><strong>Savings (20%):</strong> $${budget.savingsAmount}</div>
        </div>
    </c:if>
</div>

<!-- Panel 2: Secure Lookup Panel -->
<div class="panel">
    <h2>2. View My Budget</h2>
    <p style="font-size: 13px; color: #7f8c8d; margin-top: -10px;">Enter your unique username to retrieve your stored details securely.</p>

    <form action="/search" method="GET">
        <div class="form-group">
            <label for="searchUsername">Enter Username:</label>
            <input type="text" id="searchUsername" name="searchUsername" required>
        </div>
        <button type="submit" class="search-btn">Retrieve Records</button>
    </form>

    <!-- Display searched item if found -->
    <c:if test="${searchedBudget != null}">
        <div class="results search-results">
            <h3>Records for ${searchedBudget.username}:</h3>
            <div class="item"><strong>Total Income:</strong> $${searchedBudget.totalSalary}</div>
            <div class="item"><strong>Needs (50%):</strong> $${searchedBudget.needsAmount}</div>
            <div class="item"><strong>Wants (30%):</strong> $${searchedBudget.wantsAmount}</div>
            <div class="item"><strong>Savings (20%):</strong> $${searchedBudget.savingsAmount}</div>
        </div>
    </c:if>

    <!-- Error Messaging if nothing matches -->
    <c:if test="${searchError != null}">
        <div class="error">
            <c:out value="${searchError}"/>
        </div>
    </c:if>
</div>

</body>
</html>