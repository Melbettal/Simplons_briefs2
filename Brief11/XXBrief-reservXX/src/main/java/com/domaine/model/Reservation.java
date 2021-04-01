package com.domaine.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gestionResrv")
public class Reservation {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_reserv")
	private int id_gest;
	
	//matnssaych t ajouter description
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "validation")
	private Boolean validation;

	/*@ManyToOne
	@JoinColumn(name = "id")
    private User user;
	*/
		
	public Reservation(int id_gest, Date date, Boolean validation) {
		super();
		this.id_gest = id_gest;
		this.date = date;
		this.validation = validation;
	}

	public int getId_gest() {
		return id_gest;
	}

	public void setId_gest(int id_gest) {
		this.id_gest = id_gest;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	

}
