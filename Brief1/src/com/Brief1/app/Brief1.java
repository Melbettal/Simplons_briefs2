//***********************************************
//* 		Meryame Elbettal					*
//*												*
//***********************************************

package com.Brief1.app;

import java.text.DecimalFormat;
import java.util.Scanner;


public class Brief1 {
    public static void main(String[] args) {
        System.out.println("Bonjour !");
        
        System.out.println("Entrez votre nom :");
        Scanner MyObj = new Scanner(System.in);
        String nom = MyObj.nextLine();
        
        System.out.println(String.format("Bienvenue %s !", nom));
        
        System.out.println("Veuillez introduire votre nombre d'heures travaillés : ");
        Integer wH = MyObj.nextInt();
        
        if (wH <= 60) {
            System.out.println("Veuillez introduire la tarif par heure: ");
            double tarifPH = MyObj.nextDouble();
            double ind = tarifPH;
            if (wH <= 40) {
                Double total = wH * tarifPH ;
            if (wH > 40) {
            	double extraH = wH - 40 ;
            	double tarifFinal = tarifPH + (0.5 * tarifPH);
            	
                System.out.println("Votre indemnisation est " + ind + "MAD" );
                

            }
            System.out.println("Votre indemnisation est " + ind + "MAD" );
        } else if (wH > 60) {
            System.out.println(" informations erronés !");
        }
        }
        }
    }

