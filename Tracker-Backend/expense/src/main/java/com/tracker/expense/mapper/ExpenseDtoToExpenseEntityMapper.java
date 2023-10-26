package com.tracker.expense.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.tracker.expense.dto.ExpenseDto;
import com.tracker.expense.entities.Expense;

@Component
public class ExpenseDtoToExpenseEntityMapper {
	
	public Expense mapDtoToEntity(ExpenseDto expenseDto) {
		Expense expense = new Expense();
		expense.setExpenseAmount(expenseDto.getExpenseAmount());
		expense.setExpenseCategory(expenseDto.getExpenseCategory());
		expense.setExpenseDate(formatDate(expenseDto.getExpenseDate()));
		expense.setExpenseDescription(expenseDto.getExpenseDescription());
		return expense;
	}
	
	public LocalDate formatDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formatter);
	}
}
