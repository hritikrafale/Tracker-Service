package com.tracker.expense.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.expense.dao.ExpenseRepository;
import com.tracker.expense.entities.Expense;
import com.tracker.expense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense saveExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

}
