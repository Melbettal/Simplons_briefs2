//***********************************************
//* 		Meryame Elbettal					*
//*												*
//***********************************************

package com.Brief2.app;
import com.Brief2.app.Employee;

public class EmployeeHoraire extends Employee {

	private double th;
	private double hp;
	
	
	//Constructors 
	public EmployeeHoraire(String nom, int salaire, double th, double hp) {
		super(nom, salaire);
		this.th = th;
		this.hp = hp;
	}
	
	public EmployeeHoraire(Employee e, double th, double hp ) {
		super(e.getNom(),e.getSalaire());
		this.th = th;
		this.hp = hp;	}

	public EmployeeHoraire() {
		// TODO Auto-generated constructor stub
	}

	//Getters 
	public double getTh() {
		return th;
	}
	
	public double getHp() {
		return hp;
	}
	
	//setters
	public void setTh(double th) {
		this.th = th;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}
	
	public double calculerHor()
	{
        return (this.getTh() * this.getHp());
	}
}