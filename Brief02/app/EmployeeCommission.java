//***********************************************
//* 		Meryame Elbettal					*
//*												*
//***********************************************

package com.Brief2.app;

import com.Brief2.app.Employee;

public class EmployeeCommission extends Employee {

	private double ventes;
	private double commissions;
	
	
	//Constructors 
	public EmployeeCommission(String nom, double salaire, double ventes, double commissions) {
		super(nom, salaire);
		this.ventes = ventes;
		this.commissions = commissions;
	}

	public EmployeeCommission(Employee e, double ventes, double commissions ) {
		super(e.getNom(),e.getSalaire());
		this.ventes = ventes;
		this.commissions = commissions;	}

	public EmployeeCommission() {
		// TODO Auto-generated constructor stub
	}

	//Getters & setters
	public double getVentes() {
		return ventes;
	}
	
	public double getCommissions() {
		return commissions;
	}
	
	public void setVentes(double ventes) {
		this.ventes = ventes;
	}

	public void setCommissions(double commissions) {
		this.commissions = commissions;
	}
	
	
	public double calculerComm()
	{
        return (this.getSalaire()+this.getVentes()*this.getCommissions());
	}
}
