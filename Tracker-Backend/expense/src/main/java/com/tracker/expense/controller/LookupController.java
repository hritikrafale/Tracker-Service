package com.tracker.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.expense.service.LookupService;

@CrossOrigin
@RestController
@RequestMapping("/api/lookup")
public class LookupController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);
	
	@Autowired
	private LookupService lookupService;

	@GetMapping("/{lookupType}")
	public ResponseEntity<List<String>> getLookupDataByLookupType(@PathVariable String lookupType){
		logger.info("inside getLookupDataByLookupType() method of Lookup controller");
		List<String> lookupData = null;
		try {
			lookupData = lookupService.getLookupDataByLookuptype(lookupType);
		}catch(Exception exception) {
			logger.error("getting exception while fetching lookup data for lookup type{}, exception is {}",lookupType, exception.getMessage());
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}
		if(lookupData == null) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lookupData, HttpStatus.OK);
	}
	
}
