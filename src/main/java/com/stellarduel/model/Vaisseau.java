package com.stellarduel.model;

public class Vaisseau {

    private String nom;
    private VaisseauType type;
    private int pointDeVie;
    private int degats;
    private int portee;
    private int posX;
    private int posY;
    private boolean vivant;

    public Vaisseau(String nom, VaisseauType type, int pointDeVie, int degats, int portee, int posX, int posY) {
        this.nom = nom;
        this.type = type;
        this.pointDeVie = pointDeVie;
        this.degats = degats;
        this.portee = portee;
        this.posX = posX;
        this.posY = posY;
        this.vivant = true;
    }

    public String getNom(){
        return this.nom;
    }

    public VaisseauType getType(){
        return this.type;
    }

    public int getPointDeVie(){
        return this.pointDeVie;
    }

    public int getDegats(){
        return this.degats;
    }

    public int getPortee(){
        return this.portee;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public boolean isVivant(){
        return this.vivant;
    }

    public void setPointDeVie(int pointDeVie){
        this.pointDeVie = pointDeVie;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public void setVivant(boolean vivant){
        this.vivant = vivant;
    }

    public void recevoirDegats(int degats){
        this.pointDeVie -= degats;
              if(pointDeVie <= 0){
                this.vivant = false;
              }
    }

    public boolean estAPortee(Vaisseau cible) {
        int distanceX = Math.abs(cible.getPosX() - this.posX); //on calcule combien de cases séparent les deux vaisseaux horizontalement.
        int distanceY = Math.abs(cible.getPosY() - this.posY); //même chose verticalement.
        return (distanceX + distanceY) <= this.portee; // on additionne les deux distances et on vérifie si c'est dans la portée. return renvoie directement le résultat du test
    }

}