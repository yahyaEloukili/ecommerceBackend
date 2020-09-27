package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ecommerce.entities.Product;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository  extends JpaRepository<Product, Long>{
	
	@RestResource(path ="/selectedProducts")
	public List<Product> findBySelectedIsTrue();

	
	//@RestResource(path ="/productsBykeyword")
	public List<Product> findByNameContains(@Param("name") String mc);
	
	//@RestResource(path ="/productsBykeyword")
	//@Query("select p from Product p where p.name like :x")
	//public List<Product> checrher(@Param("x") String mc);

}
