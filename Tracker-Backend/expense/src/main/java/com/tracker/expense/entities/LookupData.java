package com.tracker.expense.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name="lookup")
public class LookupData {
	@Id
	private Long lookupId;
	private String lookupType;
	private String lookupData;
}
