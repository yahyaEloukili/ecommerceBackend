package com.ecommerce;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.entities.Category;
import com.ecommerce.entities.Product;

import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
		categoryRepository.save(new Category(null,"computers",null,null,null));
		categoryRepository.save(new Category(null,"printers",null,null,null));
		categoryRepository.save(new Category(null,"smart phones",null,null,null));
		Random rnd = new Random();
		categoryRepository.findAll().forEach(c->{
			for(int i=0 ;i<10;i++) {
				Product p = new Product();
				p.setName(RandomString.make(18));
			p.setDescription(RandomString.make(18));
				p.setCurrentPrice(100+rnd.nextInt(10000));
				p.setAvailable(rnd.nextBoolean());
				p.setSelected(rnd.nextBoolean());
				p.setPromotion(rnd.nextBoolean());
				p.setCategory(c);
				p.setPhotoName("unknown.png");
				productRepository.save(p);
			}
			
		});
		
	}

}
