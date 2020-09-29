
package com.ecommerce.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;


import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import antlr.collections.List;

@Entity

//@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Utilisateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	private String nom;
	
	private String prenom;

	private String gender;

	private String email;

	private String adress;

	private String telephone;

	private String password ;
	

	private transient java.util.List<Long> roles_id;
	private transient java.util.List<Long> courses_id;
	//private transient String confirmPassword;
	public java.util.List<Long> getRoles_id() {
		return roles_id;
	}


	



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}





	@ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<Role>();
	
	
	
	

	public Utilisateur() {
	
	}

	public Utilisateur(Long id, String nom, String prenom, String email, String adress, String telephone,
			String password, boolean access, Collection<Role> roles) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adress = adress;
		this.telephone = telephone;
		
		this.roles = roles;
	
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

@JsonIgnore	
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}


	
	public Collection<Role> getRoles() {
		return roles;
	}

	
	public void setRoles(Collection<Role> roles) {
		
		this.roles = roles;
	}






	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", gender=" + gender + ", email="
				+ email + ", adress=" + adress + ", telephone=" + telephone + ", password=" + password + ", roles="
				+ roles + "]";
	}




	


	
}
