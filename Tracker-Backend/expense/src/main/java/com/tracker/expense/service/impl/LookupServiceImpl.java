package com.tracker.expense.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.expense.dao.LookupRepository;
import com.tracker.expense.service.LookupService;

@Service
public class LookupServiceImpl implements LookupService {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseServiceImpl.class);

	@Autowired
	private LookupRepository lookupRepo;
	
	@Override
	public List<String> getLookupDataByLookuptype(String lookupType) {
		logger.info("inside getLookupDataByLookuptype() method of lookup service");
		return lookupRepo.findLookupDataByLookupType(lookupType);
	}

}
