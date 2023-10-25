package com.tracker.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.expense.entities.Expense;

@Service
public interface ExpenseService {
	public Expense getExpenseById(Long expenseId) throws Exception;
	public List<Expense> getAllExpenses();
	public void deleteExpense(Long expenseId);
	public Expense saveExpense(Expense expense);
	public Expense updateExpense(Expense expense, Long expenseId) throws Exception;
}
