package com.ecommerce.controllers;



import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entities.Product;

@RestController
public class CatalogueController {

	@Autowired
	private ProductRepository productRepository;

	

	@GetMapping(path = "/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
		Product p = productRepository.findById(id).get();
	//System.out.println(Files.readAllBytes(Paths.get(System.getProperty("user.home"))));
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/ecom/products/"+p.getPhotoName()));
	}
	@GetMapping(path = "/pro/{id}")
	public Product returnr(@PathVariable("id") Long id) {
		return productRepository.findById(id).get();
	}
	
}
