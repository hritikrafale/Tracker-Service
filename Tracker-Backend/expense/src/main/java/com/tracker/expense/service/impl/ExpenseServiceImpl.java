package com.tracker.expense.service.impl;

import java.util.List;
import java.util.Optional;

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
	public Expense getExpenseById(Long expenseId) throws Exception {
		logger.info("inside getExpenseById() method of expense service class");
		Optional<Expense> expense = expenseRepo.findById(expenseId);
		if(!expense.isPresent()) {
			throw new Exception("Expense with expenseId" + expenseId + "does not exist!");
		}
		return expense.get();
	}
	
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

	@Override
	public Expense updateExpense(Expense updatedExpense, Long expenseId) throws Exception {
		logger.info("inside updateExpense() method of expense service");
		Optional<Expense> currExpenseData = expenseRepo.findById(expenseId);
		if(!currExpenseData.isPresent()) {
			throw new Exception("Expense with expenseId" + expenseId + "does not exist!");
		}
		updatedExpense.setExpenseId(currExpenseData.get().getExpenseId());
		logger.info("updated expense is {}",updatedExpense);
		return expenseRepo.save(updatedExpense);
	}
	
	@Override
	public void deleteExpense(Long expenseId) {
		logger.info("inside deleteExpense() method of expense service");
		expenseRepo.deleteById(expenseId);
	}
}
