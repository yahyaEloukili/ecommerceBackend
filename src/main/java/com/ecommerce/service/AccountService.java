package com.ecommerce.service;

import com.ecommerce.entities.Role;
import com.ecommerce.entities.Utilisateur;

public interface AccountService {

	Utilisateur saveUser(Utilisateur user) throws Exception;
	Role saveRole(Role role);
	void addRoleToUser(String email, String roleName);
	Utilisateur findUserByEmail(String email);

	Utilisateur updateUser(Utilisateur userJson,Utilisateur userfromdb) throws Exception;

	void addCourseToUser(String coursName, String userName);
}
