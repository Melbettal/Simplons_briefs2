package com.entities;

import java.io.Serializable;

public class User implements Serializable {
	
	private int id;
	private String nom_complet;
	private String Email;
	private String mdp;
	
	public User(int id, String nom_complet, String email, String mdp) {
		super();
		this.id = id;
		this.nom_complet = nom_complet;
		Email = email;
		this.mdp = mdp;
	}

	public User(String nom_complet, String email, String mdp) {
		super();
		this.nom_complet = nom_complet;
		Email = email;
		this.mdp = mdp;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom_complet() {
		return nom_complet;
	}

	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}

	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
public void validationEmail(String email) throws Exception {
	// TODO Auto-generated method stub
		if (email != null && email.trim().length() != 0) {
			if(!email.matches( "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")) {
				throw new Exception("Merci de saisie un Email valide !");
			}
		}
		else {
			throw new Exception("Merci de saisir un Email! ");
		}
}

private void validationMdp( String mdp, String confmdp ) throws Exception{
    if ( mdp != null && confmdp != null ) {
        if ( !mdp.equals( confmdp ) ) {
            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
        } else if ( mdp.length() < 3 ) {
            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
        }
    } else {
        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
    }
}

}



