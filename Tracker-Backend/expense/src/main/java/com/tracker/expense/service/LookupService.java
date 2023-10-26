package com.tracker.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.expense.entities.LookupData;

@Service
public interface LookupService {
	public List<LookupData> getLookupDataByLookuptype(String lookupType);
}
