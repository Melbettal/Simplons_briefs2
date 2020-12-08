//***********************************************
//* 		Meryame Elbettal					*
//*												*
//***********************************************

package com.Brief2.app;

import com.Brief2.app.Employee;

public class EmployeeFixe extends Employee {

	
	//Constructors 
	public EmployeeFixe(String nom, double salaire) {
		super(nom, salaire);
	}

	public EmployeeFixe() {
		
	}
	
	public double afficherSalaire()
	{
        return (this.getSalaire());
	}
}
