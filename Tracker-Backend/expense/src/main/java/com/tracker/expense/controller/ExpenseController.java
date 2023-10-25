package com.tracker.expense.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.expense.entities.Expense;
import com.tracker.expense.service.ExpenseService;

@RestController
public class ExpenseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/all_expenses")
	public List<Expense> getAllExpenses(){
		logger.info("inside getAllExpenses() method of expense controller");
		return expenseService.getAllExpenses();
	}
	
	@PostMapping("/new_expense")
	public Expense saveExpense(@RequestBody Expense expense) {
		logger.info("inside saveExpense() method of expense controller, expense is {}",expense);
		return expenseService.saveExpense(expense);
	}
	
}
