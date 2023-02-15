package com.sportyshoes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.Model.Admin;
import com.sportyshoes.Model.Product;
import com.sportyshoes.Model.PurchaseRecord;
import com.sportyshoes.Model.User;
import com.sportyshoes.Service.AdminService;
import com.sportyshoes.Service.ProductService;
import com.sportyshoes.Service.PurchaseRecordService;
import com.sportyshoes.Service.UserService;

@RestController
@RequestMapping("/admin")
public class CRUDcontroller {
  /*
   * This Controller will handle the CRUD Operations
   * 
   * Autowire all the SERVICE classes 
   * 
   * Create methods for the CRUD Operations
   * 
   * Only Admin can do the CRUD Operations
   * */
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	PurchaseRecordService purchaserecordService;
	@Autowired
	AdminService adminservice;
	
	/*
	 * This method is to add the Product in the Product Repository. It call the
	 * methos from (ProductService) Class
	 */
	@PostMapping("/admin/addProduct")
	public void addProduct(@RequestBody Product p) {
		productService.addProduct(p);
	}
	
	/*
	 * This method is to update the Product in the Product Repository. It call the
	 * methos from (ProductService) Class
	 */
	@PutMapping("/updateProduct/{id}")
	public void updateProductbyId(@RequestBody Product p,@PathVariable Long id) {
		productService.updateProduct(p, id);
	}
	
	/*
	 * This method is to delete the Product in the Product Repository. It call the
	 * methos from (ProductService) Class
	 */
	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProductbyId(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
	/*
	 * This method is to add the User in the Product Repository. It call the
	 * methos from (UserService) Class
	 */
	@PostMapping("/addUser")
	public void addUser(@RequestBody User u) {
		userService.addUser(u);
	}
	
	/*
	 * This method is to update the User in the Product Repository. It call the
	 * methos from (UserService) Class
	 */
	@PutMapping("/updateUser/{id}")
	public void updateuserbyId(@RequestBody User u,@PathVariable int id) {
		userService.updateUser(u, id);
	}
	
	/*
	 * This method is to delete the User in the Product Repository. It call the
	 * methos from (UserService) Class
	 */
	@DeleteMapping("/deleteUser/{id}")
	public void deleteuserbyId(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	/*
	 * This method is to add the PurchaseRecord in the Product Repository. It call the
	 * methos from (PurchaseRecordService) Class
	 */
	@PostMapping("/admin/addRecord")
	public void addRecord(@RequestBody PurchaseRecord pr) {
		purchaserecordService.addRecord(pr);
	}
	
	/*
	 * This method is to update the PurchaseRecord in the Product Repository. It call the
	 * methos from (PurchaseRecordService) Class
	 */
	@PutMapping("/updateRecord/{id}")
	public void updateRecordbyId(@RequestBody PurchaseRecord pr,@PathVariable int id) {
		purchaserecordService.updateRecord(pr, id);
	}
	
	/*
	 * This method is to delete the PurchaseRecord in the Product Repository. It call the
	 * methos from (PurchaseRecordService) Class
	 */
	@DeleteMapping("/deleteRecord/{id}")
	public void deleteRecordbyId(@PathVariable int id) {
		purchaserecordService.deleteRecord(id);
	}
	
	@PutMapping("/updatePassword/{id}")
	public void updatePassword(@PathVariable("id") String id, @RequestBody Admin a) {
		adminservice.forgorPassword(id, a);
	}
	
	
}
