package com.tracker.expense.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExpenseDto {
	private double expenseAmount;
	private String expenseDescription;
	private String expenseCategory;
	private String expenseDate;
}
