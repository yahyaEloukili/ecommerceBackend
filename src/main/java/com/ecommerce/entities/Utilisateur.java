package com.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;



@Entity
public class Utilisateur implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String name;
	private String password;
	private String email;
	


	@ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();
	private transient java.util.List<Long> roles_id;

	//private transient String confirmPassword;
	public java.util.List<Long> getRoles_id() {
		return roles_id;
	}


	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


@JsonIgnore
	public String getPassword() {
		return password;
	}


@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	public Utilisateur(Long id, String name, String password, String email, List<Role> roles) {
		super();
		Id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.roles = roles;
	}



	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
