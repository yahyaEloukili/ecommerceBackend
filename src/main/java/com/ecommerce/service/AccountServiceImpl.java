package com.ecommerce.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.RoleRepository;
import com.ecommerce.dao.UtilisateurRepository;
import com.ecommerce.entities.Role;
import com.ecommerce.entities.Utilisateur;




@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	 @Autowired
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	 @Autowired
	    private UtilisateurRepository utilisateurRepository;
	    @Autowired
	    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        Role role = roleRepository.findByName(roleName);
        Utilisateur user = utilisateurRepository.findByEmail(email);
        user.getRoles().add(role);
    }

    @Override
    public Utilisateur findUserByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

	@Override
	public Utilisateur saveUser(Utilisateur user) {

    	String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
       
        user.setPassword(hashPw);
        return utilisateurRepository.save(user);
	}

	

}
