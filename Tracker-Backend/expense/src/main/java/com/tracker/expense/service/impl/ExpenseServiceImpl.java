package com.tracker.expense.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.expense.dao.ExpenseRepository;
import com.tracker.expense.entities.Expense;
import com.tracker.expense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

	@Autowired
	ExpenseRepository expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
		logger.info("inside getAllExpenses() method of expense service class");
		return expenseRepo.findAll();
	}

	@Override
	public Expense saveExpense(Expense expense) {
		logger.info("inside saveExpense() method of expense service");
		return expenseRepo.save(expense);
	}

}
