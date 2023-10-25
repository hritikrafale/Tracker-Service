package com.tracker.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.expense.dto.ExpenseDto;
import com.tracker.expense.entities.Expense;
import com.tracker.expense.mapper.ExpenseDtoToExpenseEntityMapper;
import com.tracker.expense.service.ExpenseService;

@CrossOrigin
@RestController
public class ExpenseController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

	@Autowired
	ExpenseService expenseService;
	
	@Autowired
	ExpenseDtoToExpenseEntityMapper mapper;
	
	@GetMapping("/expense/{expenseId}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long expenseId) {
		logger.info("inside getExpenseById() method of expense controller");
		Expense expense = null;
		try {
			expense = expenseService.getExpenseById(expenseId);
		} catch (Exception exception) {
			logger.error("getting exception while fetching data for id{}, exception is {}",expenseId, exception.getMessage());
			return new ResponseEntity<>(new Expense(), HttpStatus.NO_CONTENT);
		}
		if(expense == null) {
			return new ResponseEntity<>(new Expense(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(expense, HttpStatus.OK);
	}
	
	@GetMapping("/all_expenses")
	public ResponseEntity<List<Expense>> getAllExpenses(){
		logger.info("inside getAllExpenses() method of expense controller");
		List<Expense> expenseList = null;
		try {
			expenseList = expenseService.getAllExpenses();
		} catch (Exception exception) {
			logger.error("getting exception while fetching data for all existing expenses, exception is {}", exception.getMessage());
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}
		if(expenseList == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(expenseList, HttpStatus.OK);
	}
	
	@PostMapping("/new_expense")
	public ResponseEntity<Expense> saveExpense(@RequestBody ExpenseDto expenseDto) {
		logger.info("inside saveExpense() method of expense controller, expense is {}",expenseDto);
		Expense expense = mapper.mapDtoToEntity(expenseDto);
		Expense response = null;
		try {
			response = expenseService.saveExpense(expense);
		} catch (Exception exception) {
			logger.error("getting exception while saving data for expense{}, exception is {}",expense, exception.getMessage());
			return new ResponseEntity<>(new Expense(), HttpStatus.NO_CONTENT);
		}
		if(response == null) {
			return new ResponseEntity<>(new Expense(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update_expense/{expenseId}")
	public ResponseEntity<Expense> updateExpense(@RequestBody ExpenseDto expenseDto, @PathVariable Long expenseId) {
		logger.info("inside updateExpense() method of expense controller, EXPENSE is {}",expenseDto);
		Expense expense = mapper.mapDtoToEntity(expenseDto);
		Expense response = null;
		try {
			response = expenseService.updateExpense(expense, expenseId);
		} catch (Exception exception) {
			logger.error("getting exception while updating data for expense{}, exception is {}",expense, exception.getMessage());
			return new ResponseEntity<>(new Expense(), HttpStatus.NO_CONTENT);
		}
		if(response == null) {
			return new ResponseEntity<>(new Expense(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_expense/{expenseId}")
	public void deleteExpense(@PathVariable Long expenseId) {
		logger.info("inside deleteExpense() method of expense controller, EXPENSE ID is {}",expenseId);
		try {
			expenseService.deleteExpense(expenseId);
		} catch (Exception exception) {
			logger.error("getting exception while deleting expense with expenseId{}, exception is {}",expenseId, exception.getMessage());
		}
	}
}
