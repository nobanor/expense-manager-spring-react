package com.example.expensemanagerapi.controller;

import com.example.expensemanagerapi.domain.Expense;
import com.example.expensemanagerapi.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Expense> result = new ArrayList<>();
        result = expenseService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month) {
        List<Expense> result = new ArrayList<>();
        if("All".equals(month)) {
            result = expenseService.findByYear(year);
        } else {
            result = expenseService.findByMonthAndYear(month, year);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrUpdateExpense(@RequestBody Expense expense) {
        expenseService.saveOrUpdateExpense(expense);
        return new ResponseEntity("Expense added successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteExpense(@RequestParam("id") String id) {
        expenseService.deleteExpense(id);
    }
}