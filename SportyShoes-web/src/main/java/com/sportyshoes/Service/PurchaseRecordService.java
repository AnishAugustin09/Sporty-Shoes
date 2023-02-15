package com.sportyshoes.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sportyshoes.Model.PurchaseRecord;
import com.sportyshoes.Repository.PurchaseRecordRepository;

import ch.qos.logback.classic.Logger;

@Service
public class PurchaseRecordService {


	
	@Autowired
	PurchaseRecordRepository prp;
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get all the PurchaseRecord
	 * 
	 * This method is called from Controller class(SearchController)
	 */
	public List<PurchaseRecord> getallRecords(){
		return prp.findAll();
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get all the PurchaseRecord by Id
	 * 
	 * This method is called from Controller class(SearchController)
	 */
	public PurchaseRecord getbyId(int id) {
		return prp.findById(id).get();
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method add the PurchaseRecord 
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void addRecord(PurchaseRecord pr) {
		 prp.save(pr);
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method update the PurchaseRecord 
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	
	public void updateRecord(PurchaseRecord pr, int id) {
		if(prp.findById(id).isPresent()) {
			PurchaseRecord purchaserecord=prp.findById(id).get();
			purchaserecord.setProductName(pr.getProductName());
			purchaserecord.setProductCategory(pr.getProductCategory());
			purchaserecord.setProductPrice(pr.getProductPrice());
			purchaserecord.setPurchasedBy(pr.getPurchasedBy());
			purchaserecord.setPaymentType(pr.getPaymentType());
			purchaserecord.setUserAddress(pr.getUserAddress());
			purchaserecord.setDatoOfPurchase(pr.getDatoOfPurchase());
			prp.save(purchaserecord);
		}
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method Deletes the PurchaseRecord 
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void deleteRecord(int id) {
		prp.deleteById(id);
	}
	LocalDate d = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	String formattedString = d.format(formatter);
	@PostConstruct
	public void init() {
		PurchaseRecord pr1= new PurchaseRecord(1,"ADIDAS","Running",1900.45,"Ryan Dessio","New York","Credit Card",formattedString);

		PurchaseRecord pr2= new PurchaseRecord(2,"BATA","Formal",900.25,"Steve","Greenville","UPI",formattedString);
		PurchaseRecord pr3= new PurchaseRecord(3,"PUMA","Running",1200.45,"Hardin","Phenix City","Cash",formattedString);
		PurchaseRecord pr4= new PurchaseRecord(4,"REEBOK","Formal",1999.45,"Tessa","New York","Cash",formattedString);
		PurchaseRecord pr5= new PurchaseRecord(5,"REDTAPE","Running",2900.45,"Rachel","Phenix City","UPI",formattedString);
		PurchaseRecord pr6= new PurchaseRecord(6,"NIKE","Formal",1250.45,"Rebecca","Greenville","UPI",formattedString);
		PurchaseRecord pr7= new PurchaseRecord(7,"HIGHLANDER","Running",800.45,"Jacky","Phenix City","UPI",formattedString);
		PurchaseRecord pr8= new PurchaseRecord(8,"ROADSTER","Formal",1900.45,"Fin","Greenville","UPI",formattedString);

		prp.save(pr1);
		prp.save(pr2);
		prp.save(pr3);
		prp.save(pr4);
		prp.save(pr5);
		prp.save(pr6);
		prp.save(pr7);
		prp.save(pr8);
		
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get the PurchaseRecord by Category
	 * 
	 * This method is called from Controller class(SearchController)
	 * 
	 * Native Query used here
	 */
	public List<PurchaseRecord> getbyCategory(String category){
		return prp.findByCategory(category);
	}
	
	public List<PurchaseRecord> getbydate(String date){
		return prp.findByDate(date);
	}
	

}
