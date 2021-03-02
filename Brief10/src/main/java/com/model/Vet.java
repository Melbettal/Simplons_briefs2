package com.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

@Entity
@Table(name = "vet")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vet extends User {

    private static final long serialVersionUID = 1L;


	public Vet(String nom_complet, String email, String mdp) {
		// TODO Auto-generated constructor stub
		super(nom_complet, email, mdp);
	}
	
	public Vet() {
		super();
	}
}
