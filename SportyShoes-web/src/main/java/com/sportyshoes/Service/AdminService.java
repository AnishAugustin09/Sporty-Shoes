package com.sportyshoes.Service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.Model.Admin;
import com.sportyshoes.Repository.AdminRepository;

/*This is Service Class, where you can write all the Business Logics

By giving @Service annotation, this class is converted as Service class*/
@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminrepository;
	
	@PostConstruct
	public void init() {
		Admin a= new Admin("admin","121212");
		adminrepository.save(a);
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method validate the Admin email & Password
	 * 
	 * This method is called from Controller class(LoginController)
	 */
	public Boolean validate(String id, String pass) {
		Admin a= adminrepository.findById(id).get();
		return id==(a.getEmailId())&& pass.equalsIgnoreCase(a.getPassword());
		
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method update the Admin Password
	 * 
	 * This method is called from Controller class(LoginController)
	 */
	public void forgorPassword(String id, Admin a) {
			Admin admin=adminrepository.findById(id).get();
			admin.setPassword(a.getPassword());
			adminrepository.save(admin);
		
	}
}
