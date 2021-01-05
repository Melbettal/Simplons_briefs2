//***********************************************
//* 		Meryame Elbettal					*
//*												*
//***********************************************

package com.Brief2.app;
import java.util.Scanner;

import com.Brief2.app.Employee;



public class Main {
    public static void main(String[] args) {
    
    	
    	//
    	
    	while(true) {
    		Scanner reader = new Scanner(System.in);
    	    System.out.println("Pour Employee Fixe choisissez : A");
    	    System.out.println("Pour Employee Commissions choisissez : B");
    	    System.out.println("Pour Employee Horraire choisissez :C");
    	    char choice = reader.next().charAt(0);
    	   
    	 
    		switch (choice) {
    	      case 'A':
    	    	  EmployeeFixe employe1 = new EmployeeFixe();
    	    	  System.out.println("Nom d'employee : ");
    	    	  employe1.setNom(reader.next());
    	    	  System.out.println("Votre Salaire : ");
    	    	  employe1.setSalaire(reader.nextDouble());
    	    	  System.out.println("Votre Salaire Mensuel est: ");
    	    	  System.out.println(employe1.afficherSalaire());
    	    	  break;
    	    	
    	      case 'B' : 
    	    	  EmployeeCommission employe2 = new EmployeeCommission();
    	    	  System.out.println("Nom d'employee : ");
    	    	  employe2.setNom(reader.next());
    	    	  System.out.println("Votre Salaire : ");
    	    	  employe2.setSalaire(reader.nextDouble());
    	    	  System.out.println("Votre ventes : ");
    	    	  employe2.setVentes(reader.nextInt());
    	    	  System.out.println("Votre commission : ");
    	    	  employe2.setCommissions(reader.nextDouble());
    	    	  System.out.println("Votre Salaire Mensuel est: ");
    	    	  System.out.println(employe2.calculerComm());
    	    	  break;
    	    	  
    	      case 'C' : 
    	    	  EmployeeHoraire employe3 = new EmployeeHoraire();
    	    	  System.out.println("Nom d'employee : ");
    	    	  employe3.setNom(reader.next());
    	    	  System.out.println("Votre taux horaire : ");
    	    	  employe3.setTh(reader.nextDouble());
    	    	  System.out.println("Votre heures prestées: ");
    	    	  employe3.setHp(reader.nextDouble());
    	    	  System.out.println("Votre Salaire Mensuel est: ");
    	    	  System.out.println(employe3.calculerHor());
    	    	  break;
    	    }
    	}
    }
}