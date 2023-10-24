package com.tracker.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.expense.entities.Expense;

@Service
public interface ExpenseService {
	public List<Expense> getAllExpenses();
	public Expense saveExpense(Expense expense);
}
