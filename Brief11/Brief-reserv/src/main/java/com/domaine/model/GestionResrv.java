package com.domaine.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gestionResrv")
public class GestionResrv implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_gest")
	private int id_gest;
	
	@Column(name = "nmbr_places")
	private int nmbr_places;
	
	@Column(name = "date")
	private LocalDateTime date ;
	/*@ManyToOne
	@JoinColumn(name = "id")
    private User user;
	*/
		
	

	public GestionResrv(int nmbr_places, LocalDateTime date) {
		super();
		this.nmbr_places = nmbr_places;
		this.date = date;
	}
	
	public GestionResrv() {
		super();
	}

	public int getId_gest() {
		return id_gest;
	}

	public void setId_gest(int id_gest) {
		this.id_gest = id_gest;
	}

	public int getNmbr_places() {
		return nmbr_places;
	}

	public void setNmbr_places(int nmbr_places) {
		this.nmbr_places = nmbr_places;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}


}
