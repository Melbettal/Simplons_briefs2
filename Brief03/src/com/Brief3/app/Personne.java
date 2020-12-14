package com.Brief3.app;

public class Personne {
    private String nom;
    private int age;
    //
    public Personne(String nom, int age){
        this.nom = nom;
        this.age = age;
    }
    //
    @Override
    public String toString(){
        return ("Je suis " + this.nom + ", j'ai " + this.age);
    }
    //
    public void afficher(){
        System.out.println(this.toString());
    }
}