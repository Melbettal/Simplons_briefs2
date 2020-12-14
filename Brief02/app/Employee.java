//***********************************************
//* 		Meryame Elbettal					*
//*												*
//***********************************************

package com.Brief2.app;

public class Employee {

	private String nom;
	private double salaire;
	
	public Employee()
	{
		
	}
	
	//Constructors 
	public Employee(String nom, double salaire) 
	{
		this.nom = nom;
		this.salaire=salaire;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	public double getSalaire() {
		return salaire;
	}

	@Override
	public String toString() 
	{
		return "Votre Nom est : "+this.nom + "Votre salaire mensuel est : "+ this.salaire ;
	}
}
