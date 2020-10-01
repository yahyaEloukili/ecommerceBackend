package com.ecommerce.service;

import com.ecommerce.entities.Role;
import com.ecommerce.entities.Utilisateur;

public interface AccountService {

	Utilisateur saveUser(Utilisateur user);
	Role saveRole(Role role);
	void addRoleToUser(String email, String roleName);
	Utilisateur findUserByEmail(String email);

	

	
}
