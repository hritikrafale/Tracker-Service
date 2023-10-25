package com.tracker.expense.mapper;

import org.springframework.stereotype.Component;

import com.tracker.expense.dto.ExpenseDto;
import com.tracker.expense.entities.Expense;

@Component
public class ExpenseDtoToExpenseEntityMapper {
	
	public Expense mapDtoToEntity(ExpenseDto expenseDto) {
		Expense expense = new Expense();
		expense.setExpenseAmount(expenseDto.getExpenseAmount());
		expense.setExpenseCategory(expenseDto.getExpenseCategory());
		expense.setExpenseDate(expenseDto.getExpenseDate());
		expense.setExpenseDescription(expenseDto.getExpenseDescription());
		return expense;
	}
	
}
