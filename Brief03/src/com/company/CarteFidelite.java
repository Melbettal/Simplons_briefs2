package com.company;

public class CarteFidelite {
    private int identifiant;
    private int nbPoints;
    private String statu;
    //
    private static int compteur = 0;
    public static int getCompteur() {
        return compteur;
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public String getStatu() {
        return statu;
    }
    //
    public CarteFidelite(){
        compteur++;
        this.identifiant = compteur;
        //
        this.nbPoints = 0;
        this.statu = "non fid�le";
    }
    //
    public void ajouterPoint(String type){
        this.nbPoints++;
        //
        int pointsCeil = 4;
        if(type != "Lecteur")
            pointsCeil = 3;
        if(this.nbPoints == pointsCeil){
            if(type == "Lecteur")
                this.statu = "fid�le";
            else
                this.statu = "super-fid�le";
        }
    }
}