package com.ecommerce;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.ecommerce.dao.CategoryRepository;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.dao.UtilisateurRepository;
import com.ecommerce.entities.Category;
import com.ecommerce.entities.Product;
import com.ecommerce.service.AccountService;

import net.bytebuddy.utility.RandomString;
import com.ecommerce.entities.*;
@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	 AccountService accountService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
}
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Product.class,Category.class);
		
		
		repositoryRestConfiguration.exposeIdsFor(Utilisateur.class);
		repositoryRestConfiguration.exposeIdsFor(Role.class);
	
		
	

		//add roles
				accountService.saveRole(new Role(1L,"Admin",null));
				accountService.saveRole(new Role(2L,"Publisher",null));
				accountService.saveRole(new Role(3L,"User",null));
			
				Utilisateur admin = new Utilisateur();
				admin.setPassword(bCryptPasswordEncoder.encode("1234"));
				admin.setEmail("admin@hotmail.com");
				admin.setName("admin");

				utilisateurRepository.save(admin);
				accountService.addRoleToUser(admin.getEmail(), "Admin");
		
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
