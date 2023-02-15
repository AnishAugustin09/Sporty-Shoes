package com.sportyshoes.Repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.Model.PurchaseRecord;

@Repository
@Transactional
public interface PurchaseRecordRepository extends JpaRepository<PurchaseRecord, Integer> {

	/*
	 * This is PurchaseRecordRepository Interface
	 * 
	 * This JpaRepository is the Core for JPA access
	 * 
	 * By this interface we can access all the API calls
	 * 
	 * In this Program, I've used - findAll(), findById(), save() etc...
	 */
	
	@Query(value="select * from Purchase_Record where Category=?1",nativeQuery=true)
	List<PurchaseRecord> findByCategory(String Category);//Native Query

	@Query(value="select * from Purchase_Record where Purchase_Date=?1",nativeQuery=true)
	List<PurchaseRecord> findByDate(String Purchase_Date);//Native Query
}
