package com.sportyshoes.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.Model.Admin;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin, String> {

	/*
	 * This is AdminRepository Interface
	 * 
	 * This JpaRepository is the Core for JPA access
	 * 
	 * By this interface we can access all the API calls
	 * 
	 * In this Program, I've used - findAll(), findById(), save() etc...
	 */
}
