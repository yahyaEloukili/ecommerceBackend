package com.ecommerce.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Product> findBySelectedIsTrue(Pageable page);
	@RestResource(path ="/promoProducts")
	public Page<Product> findByPromotionIsTrue(Pageable page);
	@RestResource(path ="/dispoProducts")
	public Page<Product> findByAvailableIsTrue(Pageable page);

	
	//@RestResource(path ="/productsBykeyword")
	public List<Product> findByNameContains(@Param("name") String mc);
	
	
	
	//@RestResource(path ="/productsBykeyword")
	//@Query("select p from Product p where p.name like :x")
	//public List<Product> checrher(@Param("x") String mc);

}
