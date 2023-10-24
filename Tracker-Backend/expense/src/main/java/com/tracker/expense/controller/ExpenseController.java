package com.tracker.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.expense.entities.Expense;
import com.tracker.expense.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/all_expenses")
	public List<Expense> getAllExpenses(){
		return expenseService.getAllExpenses();
	}
	
	@PostMapping("/new_expense")
	public Expense saveExpense(@RequestBody Expense expense) {
		System.out.println("Expense : ");
		return expenseService.saveExpense(expense);
	}
	
}
