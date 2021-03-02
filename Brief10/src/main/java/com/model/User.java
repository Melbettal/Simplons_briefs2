package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "nom_complet")
	private String nom_complet;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mdp")
	private String mdp; 

	/*@OneToMany(mappedBy = "User", orphanRemoval = true)
    private List<RDV> rdv;
	@OneToMany(mappedBy = "User", orphanRemoval = true)
    private List<FAQ> faq;*/
    

	public User(String nom_complet, String email, String mdp) {
		super();
		this.nom_complet = nom_complet;
		this.email = email;
		this.mdp = mdp;
	}

	public User() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom_complet() {
		return nom_complet;
	}

	public void setNom_complet(String nom_complet) {
		this.nom_complet = nom_complet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}