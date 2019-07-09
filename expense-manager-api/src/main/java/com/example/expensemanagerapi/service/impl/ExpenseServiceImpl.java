package com.example.expensemanagerapi.service.impl;


import com.example.expensemanagerapi.domain.Expense;
import com.example.expensemanagerapi.repository.ExpenseRepository;
import com.example.expensemanagerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> findByMonthAndYear(String month, int year) {
        return expenseRepository.findByMonthAndYear(month, year);
    }

    @Override
    public void saveOrUpdateExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
        public void deleteExpense(String id) {
            expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> findByYear(int year) {
        return expenseRepository.findByYear(year);
    }



}
