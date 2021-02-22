package com.entities;

//import java.io.Serializable;

public class Produit  {
	
	private int id;
	private String image;
	private String nom;
	private String description;
	private double prix;
	private int quantite;


	public Produit(int id, String image, String nom, String description, double prix, int quantite) {
		super();
		this.id = id;
		this.image = image;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public Produit (String image, String nom, String description, double prix, int quantite) {
		this.image = image;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
}

