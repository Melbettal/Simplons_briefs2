package com.entities;

import java.io.Serializable;

public class Article implements Serializable {
	private long id;
	private String nom;
	private String description;
	private double prix;
	private int quantite;
	

public Article( String nom, String description, double prix, int quantite) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
	}
public Article() {
	// TODO Auto-generated constructor stub
}
public long getId() {
		return id;
}
public void setId(long id) {
		this.id = id;
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
@Override
public String toString() {
	return "Article [id=" + id + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantite="
			+ quantite + "]";
}


}

