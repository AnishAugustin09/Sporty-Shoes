package com.sportyshoes.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.Model.Product;
import com.sportyshoes.Model.PurchaseRecord;
import com.sportyshoes.Model.User;
import com.sportyshoes.Service.ProductService;
import com.sportyshoes.Service.PurchaseRecordService;
import com.sportyshoes.Service.UserService;

@RestController
@RequestMapping("/sportyshoes")
public class SearchController {

	/*
	 * This class is to view all the repository in the webpage
	 * 
	 * because, the HttpGet method is used for all the methods
	 * 
	 * Only view operations will be done in this class
	 */
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	PurchaseRecordService purchaserecordService;

	/*
	 * This method is to view all the Product
	 * 
	 * It call the method from ProductService class
	 */
	@GetMapping("/products")
	public List<Product> getallProducts(){
		return productService.getallProduct();
	}
	
	/*
	 * This method is to view all the Product by Id
	 * 
	 * It call the method from ProductService class
	 */
	@GetMapping("/products/{id}")
	public Product getallProductsbyId(@PathVariable Long id){
		return productService.getbyId(id);
	}
	
	/*
	 * This method is to view all the Users
	 * 
	 * It call the method from UsersService class
	 */
	@GetMapping("/users")
	public List<User> getallUser(){
		return userService.getallUser();
	}
	
	/*
	 * This method is to view all the Users by Id
	 * 
	 * It call the method from UsersService class
	 */
	@GetMapping("/users/{id}")
	public User getuserbyId(@PathVariable int id){
		return userService.getbyId(id);
	}
	
	/*
	 * This method is to view all the PurchaseRecord
	 * 
	 * It call the method from PurchaseRecordService class
	 */
	@GetMapping("/records")
	public List<PurchaseRecord> getallRecord(){
		return purchaserecordService.getallRecords();
	}
	
	/*
	 * This method is to view all the PurchaseRecord by Id
	 * 
	 * It call the method from PurchaseRecordService class
	 */
	@GetMapping("/records/{id}")
	public PurchaseRecord getrecordsbyId(@PathVariable("id") int id){
		return purchaserecordService.getbyId(id);
	}
	
	/*
	 * This method is to view all the Users by email
	 * 
	 * It call the method from UserService class
	 * 
	 * For this method, i'd used the NativeQuery to access the Entity data(email)
	 */
	@RequestMapping(value="/user/{email}",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getByEmail(@PathVariable("email") String email){
		return userService.getUserByEmail(email);
	}
	
	/*
	 * This method is to view all the PurchaseRecord by Category
	 * 
	 * It call the method from PurchaseRecordService class
	 * 
	 * For this method, i'd used the NativeQuery to access the Entity data(Category)
	 */
	@RequestMapping(value="/record/{category}",method=RequestMethod.GET)
	@ResponseBody
	public List<PurchaseRecord> getRecordbyCategory(@PathVariable("category") String category){
		return purchaserecordService.getbyCategory(category);
	}
	
	@RequestMapping(value="/record/date/{date}",method=RequestMethod.GET)
	@ResponseBody
	public List<PurchaseRecord> getRecordbyDate(@PathVariable("date") String date){
		return purchaserecordService.getbydate(date);
	}
	
}
