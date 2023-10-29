package com.tracker.expense.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LookupService {
	public List<String> getLookupDataByLookuptype(String lookupType);
}
