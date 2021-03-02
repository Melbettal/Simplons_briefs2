package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "client")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends User {

    private static final long serialVersionUID = 1L;

    //@Column(name = "id_client")
    //private long id_client;

    
    
	public Client(long id_client, String nom_complet, String email, String mdp) {
		// TODO Auto-generated constructor stub
		super(nom_complet, email, mdp);
	}
	
	public Client() {
		super();
	}
}
