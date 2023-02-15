package com.sportyshoes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.Model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	/*
	 * This is ProductRepository Interface
	 * 
	 * This JpaRepository is the Core for JPA access
	 * 
	 * By this interface we can access all the API calls
	 * 
	 * In this Program, I've used - findAll(), findById(), save() etc...
	 */
}
