package com.stellarduel.model;

public class Grille {

    private static final int TAILLE = 8;
    private Vaisseau[][] cases;

    public Grille(){
        this.cases = new Vaisseau[TAILLE][TAILLE];
    }

    public void placerVaisseau(Vaisseau vaisseau, int x, int y){
    vaisseau.setPosX(x);
    vaisseau.setPosY(y);
    this.cases[x][y] = vaisseau;
    }

    public void retirerVaisseau(int x, int y){
    this.cases[x][y] = null;
    }

    public Vaisseau getVaisseau(int x, int y){
    return this.cases[x][y];
    }

    public boolean estOccupee(int x, int y){
        return this.cases[x][y] != null;
    }

    public boolean estDansGrille(int x, int y){
        return x >= 0 && x < TAILLE && y >= 0 && y < TAILLE;
    }

}
