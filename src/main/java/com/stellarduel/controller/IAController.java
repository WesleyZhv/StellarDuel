package com.stellarduel.controller;

import com.stellarduel.model.*;
import com.stellarduel.controller.*;
import java.util.List;

public class IAController {

    public void jouerTour(Partie partie, GameController gameController){
        List<Vaisseau> flotteIA = partie.getJoueur2().getFlotteVivante();
        List<Vaisseau> flotteHumain = partie.getJoueur1().getFlotteVivante();
        for(Vaisseau vaisseauIA : flotteIA){
            boolean aAttaque = false;
            for(Vaisseau ennemi : flotteHumain){
                if(vaisseauIA.estAPortee(ennemi)){
                    gameController.attaquer(vaisseauIA, ennemi);
                    aAttaque = true;
                    break;
                }
            }
            if(!aAttaque) {
                gameController.deplacerVaisseau(vaisseauIA, vaisseauIA.getPosX(), vaisseauIA.getPosY()-1);
            }
        }
    }
}
