package com.ecommerce.controllers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dao.RoleRepository;
import com.ecommerce.dao.UtilisateurRepository;
import com.ecommerce.entities.Role;
import com.ecommerce.entities.Utilisateur;
import com.ecommerce.service.AccountService;




@RestController
@CrossOrigin(value = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE} )
public class AccountRestController {

@Autowired
UtilisateurRepository utilisateurRepository;

@Autowired
RoleRepository roleRepository;

    @Autowired
    AccountService accountService;
    @PostMapping(value="/register",consumes={"application/json"})
    public Utilisateur register( @RequestBody Utilisateur userForm) throws Exception {
    	if(userForm.getEmail()!=null) {
    		Utilisateur user=  utilisateurRepository.findByEmail(userForm.getEmail());
    		if(user!=null) {
    			throw new RuntimeException("user already exist");
    		}
    	}
    List<Role> roles = new ArrayList<Role>(); 
    if(userForm.getRoles_id()!=null && userForm.getRoles_id().size()!=0) {
    	
   for (Long id  :  userForm.getRoles_id()) {
	
	   Role role =	roleRepository.findById(id).get();
	   roles.add(role);
	
   }
   userForm.setRoles(roles);
}
 accountService.saveUser(userForm);
   

  return  userForm;
    }
 
   





}
