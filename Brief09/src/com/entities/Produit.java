package com.entities;

import java.io.Serializable;

public class Produit implements Serializable {
	
	private int id;
	private String nom_produit;
	private String description_produit;
	private double prix_produit;
	private int quantite_produit;

public Produit(int id, String nom_produit, String description_produit, double prix_produit, int quantite_produit) {
	super();
	this.id = id;
	this.nom_produit = nom_produit;
	this.description_produit = description_produit;
	this.prix_produit = prix_produit;
	this.quantite_produit = quantite_produit;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom_produit() {
	return nom_produit;
}

public void setNom_produit(String nom_produit) {
	this.nom_produit = nom_produit;
}

public String getDescription_produit() {
	return description_produit;
}

public void setDescription_produit(String description_produit) {
	this.description_produit = description_produit;
}

public double getPrix_produit() {
	return prix_produit;
}

public void setPrix_produit(double prix_produit) {
	this.prix_produit = prix_produit;
}

public int getQuantite_produit() {
	return quantite_produit;
}

public void setQuantite_produit(int quantite_produit) {
	this.quantite_produit = quantite_produit;
}



}

