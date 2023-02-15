package com.sportyshoes.Service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.Model.Product;
import com.sportyshoes.Model.User;
import com.sportyshoes.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired 
	ProductRepository productRepository;
	
	@PostConstruct
	public void init() {
		Product u1= new Product("Adidas-Ez","Adidas","Running");
		Product u2= new Product("Nike-Ez","Nike","Formal");
		Product u3= new Product("Nivea-Ez","Nivea","Running");
		Product u4= new Product("Adidas-Ez","Adidas","Formal");
		Product u5= new Product("Nike-Ez","Nike","Running");
		
		productRepository.save(u1);
		productRepository.save(u2);
		productRepository.save(u3);
		productRepository.save(u4);
		productRepository.save(u5);
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get all the Products 
	 * 
	 * This method is called from Controller class(SearchController)
	 */
	public List<Product> getallProduct(){
		return productRepository.findAll();
	}
	/*
	 * Actual Business method + API calls
	 * 
	 * This method get all the Products by Id
	 * 
	 * This method is called from Controller class(SearchController)
	 */
	public Product getbyId(Long id) {
		return productRepository.findById(id).get();
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method add the Products in DB
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void addProduct(Product p) {
		productRepository.save(p);
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method update the Products in DB
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void updateProduct(Product p, long id) {
		if(productRepository.findById(id).isPresent()) {
			Product product =productRepository.findById(id).get();
			product.setName(p.getName());
			product.setBrand(p.getBrand());
			product.setCategory(p.getCategory());
			productRepository.save(product);
		}
	}
	
	/*
	 * Actual Business method + API calls
	 * 
	 * This method Deletes the Products in DB
	 * 
	 * This method is called from Controller class(CRUDController)
	 */
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
