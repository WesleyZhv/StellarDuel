package com.stellarduel.model;

import java.util.*;

public class Partie implements IObservable{

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurActif;
    private Grille grille;
    private int tourNumero;
    private boolean partieTerminee;
    private List<IObservateur> observateurs = new ArrayList<>();

    public Partie(Joueur joueur1, Joueur joueur2, Grille grille){
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.grille = grille;
        this.joueurActif = joueur1;
        this.tourNumero = 1;
        this.partieTerminee = false;
    }

    public Joueur getJoueur1(){
        return this.joueur1;
    }

    public Joueur getJoueur2(){
        return this.joueur2;
    }

    public Grille getGrille(){
        return this.grille;
    }

    public Joueur getJoueurActif(){
        return this.joueurActif;
    }

    public int getTourNumero(){
        return this.tourNumero;
    }

    public boolean isPartieTerminee(){
        return this.partieTerminee;
    }

    public void changerTour(){
        if (joueurActif == joueur1) {
            joueurActif = joueur2;
        } else {
            joueurActif = joueur1;
        }
        this.tourNumero++;
        notifierObservateurs();
    }

    public void verifierFinDePartie() {
        if (joueur1.estDefeated() || joueur2.estDefeated()) {
            this.partieTerminee = true;
            notifierObservateurs();
        }
    }

    public Joueur getGagnant(){
        if(!this.partieTerminee){
            return null;
        }

        if(joueur1.estDefeated()){
            return joueur2;
        } else {
            return joueur1;
        }
    }

    public void ajouterObservateur(IObservateur o){
        observateurs.add(o);
    }

    public void notifierObservateurs(){
        for(IObservateur obs : observateurs){
            obs.mettreAJour();
        }
    }

}
