package com.tracker.expense.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.expense.entities.LookupData;

@Repository
public interface LookupRepository extends JpaRepository<LookupData, Long> {

	@Query("SELECT ld.lookupData FROM LookupData ld WHERE ld.lookupType = ?1")
    List<String> findLookupDataByLookupType(String category);

}
