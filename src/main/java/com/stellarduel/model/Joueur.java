package com.stellarduel.model;

import java.util.*;
import java.util.stream.Collectors;

public class Joueur {

    private String nom;
    private List<Vaisseau> flotte;
    private boolean estIA;

    public Joueur(String nom, boolean estIA){
        this.nom = nom;
        flotte = new ArrayList<>();
        this.estIA = estIA;
    }

    public String getNom(){
        return this.nom;
    }

    public List<Vaisseau> getFlotte(){
        return this.flotte;
    }

    public boolean estIA(){
        return estIA;
    }

    public void ajouterVaisseau(Vaisseau vaisseau){
        flotte.add(vaisseau);
    }

    public List<Vaisseau> getFlotteVivante(){
        List<Vaisseau> vivants = flotte.stream().filter(v -> v.isVivant()).collect(Collectors.toList());
        return vivants;
    }

    public boolean estDefeated(){
        return getFlotteVivante().isEmpty();
    }
}
