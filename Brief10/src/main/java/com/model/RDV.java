package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "RDV")
public class RDV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_rdv")
	private int id_rdv;
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@Column(name = "nom_pet")
	private String nom_pet;

	/*@ManyToOne
	@JoinColumn(name = "id")
    private User user;
	*/
	
	public RDV(int id_rdv, LocalDateTime date, String nom_pet) {
		super();
		this.id_rdv = id_rdv;
		this.date = date;
		this.nom_pet = nom_pet;
	}


	public int getId_rdv() {
		return id_rdv;
	}


	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
	}


	public LocalDateTime getDate() {
		return date;
	}


	public void setDate(LocalDateTime date) {
		this.date = date;
	}


	public String getNom_pet() {
		return nom_pet;
	}


	public void setNom_pet(String nom_pet) {
		this.nom_pet = nom_pet;
	}
	
}
