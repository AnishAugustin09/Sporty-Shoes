package com.sportyshoes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportyshoes.Model.Admin;
import com.sportyshoes.Service.AdminService;

@Controller
public class LoginController {

	/*
	 * It is the begining of the program, where it validates the admin email &
	 * password. if the admin email and password was correct, it'll allow the access
	 * the page
	 */
	@Autowired
	AdminService adminservice;
	
	/*
	 * This is the first step of the program,
	 * 
	 * it return a index.html page, localhos:8080.
	 */
	@RequestMapping("/") 
	public String adminLogin() {
		return "index";
	}
	
	/*
	 * This method will validates the admin emailid and password
	 * 
	 * if its correct, it'll return to spotyshoes.html page
	 * 
	 * else it'll redirect to index.html page
	 * 
	 * This method call the method in AdminService class
	 */
	@GetMapping("/validate")
	public String validate(@RequestParam("adminid") String adminId, @RequestParam("adminpass") String password,Model m ) {
		
		boolean validAdmin= adminservice.validate(adminId, password);
		if(!validAdmin) {
			//String msg="Sorry!! invalid id or password";
			//m.addAttribute("message", msg);
			return "index";
		}else {
			//String msg="Welcome"+adminId;
			//m.addAttribute("message", msg);
			return "sportyshoes";
		}
	}
	
	/*
	 * This method is for update the password if the
	 * 
	 * admin want to change password
	 * 
	 * It'll call the method from AdminService class
	 */	public void forgotPassword(String id, Admin a) {
		adminservice.forgorPassword(id, a);
	}
}
