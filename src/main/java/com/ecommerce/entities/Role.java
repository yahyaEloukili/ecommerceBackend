package com.ecommerce.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity

public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	

    private String name;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")
    @JsonIgnore	
    private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Long id, String name, List<com.ecommerce.entities.Utilisateur> utilisateurs) {
		super();
		Id = id;
		this.name = name;
		this.utilisateurs = utilisateurs;
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
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	@Override
	public String toString() {
		return "Role [Id=" + Id + ", name=" + name + ", utilisateurs=" + utilisateurs + "]";
	}
    
    


    
}
