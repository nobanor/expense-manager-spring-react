package com.example.expensemanagerapi.service;

import com.example.expensemanagerapi.domain.Expense;


import java.util.List;

public interface ExpenseService {

    List<Expense> findAll();

    List<Expense> findByMonthAndYear(String month, int year);

    List<Expense> findByYear(int year);

    void saveOrUpdateExpense(Expense expense);

    void deleteExpense(String id);

}
