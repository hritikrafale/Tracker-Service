package com.tracker.expense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.expense.entities.LookupData;

@Repository
public interface LookupRepository extends JpaRepository<LookupData, Long> {

	List<LookupData> findByLookupType(String lookupType);

}
