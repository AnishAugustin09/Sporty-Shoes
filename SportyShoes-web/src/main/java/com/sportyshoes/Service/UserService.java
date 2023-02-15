package com.sportyshoes.Service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.Model.User;
import com.sportyshoes.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		User u1= new User(1,"John","john@1","Male","Canada");
		User u2= new User(2,"Lisa","lisa@90","FeMale","Yukon");
		User u3= new User(3,"Rob","rob@7","Male","Manitoba");
		User u4= new User(4,"Tessa","tessa@32","FeMale","Nova Scotia");
		User u5= new User(5,"ken","ken@45","Male","Canada");
		
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		userRepository.save(u4);
		userRepository.save(u5);
	}
	/*
	 * Actual Business method + API calls
	 * 
	 * This method add the User 
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void addUser(User u){
		userRepository.save(u);
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get the User 
	 * 
	 * This method is called from Controller class(searchController)
	 */
	public List<User> getallUser(){
		return userRepository.findAll();
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get the User by id 
	 * 
	 * This method is called from Controller class(searchController)
	 */
	public User getbyId(int id) {
		return userRepository.findById(id).get();	 
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method Update the User 
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void updateUser(User u, int id) {
		if(userRepository.findById(id).isPresent()) {
			User user= userRepository.findById(id).get();
			user.setId(u.getId());
			user.setName(u.getName());
			user.setEmail(u.getEmail());
			user.setGender(u.getGender());
			user.setAddress(u.getAddress());
			userRepository.save(user);
			
		}
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method Delete the User by id 
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get the User by email 
	 * 
	 * This method is called from Controller class(SearchController)
	 */
	public List<User> getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
}
