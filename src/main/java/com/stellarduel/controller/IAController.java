package com.stellarduel.controller;

import com.stellarduel.model.*;
import java.util.List;

public class IAController {

    public void jouerTour(Partie partie, GameController gameController){
        List<Vaisseau> flotteIA = partie.getJoueur2().getFlotteVivante();
        List<Vaisseau> flotteHumain = partie.getJoueur1().getFlotteVivante();
        for(Vaisseau vaisseauIA : flotteIA){
            boolean aAttaque = false;
            int meilleurScore = Integer.MIN_VALUE;
            Vaisseau meilleureCible = null;
            for(Vaisseau ennemi : flotteHumain){
                if(vaisseauIA.estAPortee(ennemi)){
                    int pvAvant = ennemi.getPointDeVie();
                    ennemi.recevoirDegats(vaisseauIA.getDegats());
                    int score = minimax(partie, 2, false);
                    if(score > meilleurScore){
                        meilleurScore = score;
                        meilleureCible = ennemi;
                    }
                    ennemi.setPointDeVie(pvAvant);
                    ennemi.setVivant(true);
                }
            }
            if(meilleureCible != null){
                gameController.attaquer(vaisseauIA, meilleureCible);
                aAttaque = true;
            }
            if(!aAttaque){
                gameController.deplacerVaisseau(vaisseauIA, vaisseauIA.getPosX(), vaisseauIA.getPosY()-1);
            }
        }
    }

    public int minimax(Partie partie, int profondeur, boolean estTourIA){
        if (profondeur == 0 || partie.isPartieTerminee()) {
            return evaluer(partie);
        }

        if (estTourIA) {
            int meilleurScore = Integer.MIN_VALUE;
            for (Vaisseau vaisseauIA : partie.getJoueur2().getFlotteVivante()) {
                for (Vaisseau ennemi : partie.getJoueur1().getFlotteVivante()) {
                    if (vaisseauIA.estAPortee(ennemi)) {

                        int pvAvant = ennemi.getPointDeVie();
                        ennemi.recevoirDegats(vaisseauIA.getDegats());

                        int score = minimax(partie, profondeur - 1, false);
                        meilleurScore = Math.max(meilleurScore, score);

                        ennemi.setPointDeVie(pvAvant);
                        ennemi.setVivant(true);

                    }
                }
            }
            return meilleurScore;
        } else { int meilleurScore = Integer.MAX_VALUE;
            for (Vaisseau vaisseauHumain : partie.getJoueur1().getFlotteVivante()){
                for (Vaisseau vaisseauIA : partie.getJoueur2().getFlotteVivante()){
                    if (vaisseauIA.estAPortee(vaisseauHumain)) {
                        int pvAvant = vaisseauHumain.getPointDeVie();
                        vaisseauIA.recevoirDegats(vaisseauHumain.getDegats());

                        int score = minimax(partie, profondeur - 1, true);
                        meilleurScore = Math.min(meilleurScore, score);

                        vaisseauIA.setPointDeVie(pvAvant);
                        vaisseauIA.setVivant(true);
                    }
                }
            }
            return meilleurScore;
        }
    }

    public int evaluer(Partie partie){
    int score = 0;
        List<Vaisseau> flotteIA = partie.getJoueur2().getFlotteVivante();
        List<Vaisseau> flotteHumain = partie.getJoueur1().getFlotteVivante();

        for(Vaisseau v : flotteIA){
            score += v.getPointDeVie();
        }
        for(Vaisseau v : flotteHumain){
            score -= v.getPointDeVie();
        }

        return score;
    }
}
