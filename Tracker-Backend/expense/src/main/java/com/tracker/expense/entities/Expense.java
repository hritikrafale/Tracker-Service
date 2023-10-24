package com.tracker.expense.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="expense")
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expenseId;
	private double expenseAmount;
	private String expenseDescription;
	private String expenseCategory;
	private String expenseDate;
}
