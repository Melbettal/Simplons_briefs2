package com.entities;

import java.sql.Date;

public class Vote {

	private Date date;
	private int id_user; 
	private int id_produit;
	

	public Vote(Date date, int id_user, int id_produit) {
		super();
		this.date = date;
		this.id_user = id_user;
		this.id_produit = id_produit;
	}
	
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getId_user() {
		return id_user;
	}


	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


	public int getId_produit() {
		return id_produit;
	}


	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}



}