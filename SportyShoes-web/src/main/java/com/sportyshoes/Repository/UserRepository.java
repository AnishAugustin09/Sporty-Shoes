package com.sportyshoes.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportyshoes.Model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {

	/*
	 * This is UserRepository Interface
	 * 
	 * This JpaRepository is the Core for JPA access
	 * 
	 * By this interface we can access all the API calls
	 * 
	 * In this Program, I've used - findAll(), findById(), save() etc...
	 */
	
	@Query(value="select * from user  where Email=?1",nativeQuery=true)
	List<User> findByEmail(String Email);//Native Query
}
