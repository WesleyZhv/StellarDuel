package com.stellarduel.controller;

import com.stellarduel.model.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import com.stellarduel.view.*;

public class GameController {

    private Partie partie;
    private Stage stage;

    public GameController(Stage stage){
        this.stage = stage;
    }

    public void initialiserPartie(String nomJoueur) {

        Joueur joueur1 = new Joueur(nomJoueur, false);
        Joueur joueur2 = new Joueur("IA", true);
        Grille grille = new Grille();

        // Joueur 1
        Vaisseau tank = VaisseauFactory.creer(VaisseauType.TANK, "Titan", 0, 0);
        Vaisseau sniper = VaisseauFactory.creer(VaisseauType.SNIPER, "Ghost", 1, 0);
        Vaisseau support = VaisseauFactory.creer(VaisseauType.SUPPORT, "Medic", 2, 0);
        Vaisseau kamikaze = VaisseauFactory.creer(VaisseauType.KAMIKAZE, "Kamikaze", 3, 0);

        joueur1.ajouterVaisseau(tank);
        joueur1.ajouterVaisseau(sniper);
        joueur1.ajouterVaisseau(support);
        joueur1.ajouterVaisseau(kamikaze);

        grille.placerVaisseau(tank, 0, 0);
        grille.placerVaisseau(sniper, 1, 0);
        grille.placerVaisseau(support, 2, 0);
        grille.placerVaisseau(kamikaze, 3, 0);

        // Joueur 2
        Vaisseau tankIA = VaisseauFactory.creer(VaisseauType.TANK, "Titan IA", 0, 7);
        Vaisseau sniperIA = VaisseauFactory.creer(VaisseauType.SNIPER, "Ghost IA", 1, 7);
        Vaisseau supportIA = VaisseauFactory.creer(VaisseauType.SUPPORT, "Medic IA", 2, 7);
        Vaisseau kamikazeIA = VaisseauFactory.creer(VaisseauType.KAMIKAZE, "Kamikaze IA", 3, 7);

        joueur2.ajouterVaisseau(tankIA);
        joueur2.ajouterVaisseau(sniperIA);
        joueur2.ajouterVaisseau(supportIA);
        joueur2.ajouterVaisseau(kamikazeIA);

        grille.placerVaisseau(tankIA, 0, 7);
        grille.placerVaisseau(sniperIA, 1, 7);
        grille.placerVaisseau(supportIA, 2, 7);
        grille.placerVaisseau(kamikazeIA, 3, 7);

        this.partie = new Partie(joueur1, joueur2, grille);

        GameView gameView = new GameView();
        stage.setScene(new Scene(gameView, 800, 600));
    }

    public void deplacerVaisseau(Vaisseau vaisseau, int x, int y){
        if (!partie.getGrille().estDansGrille(x, y)) {
            return;
        }

        if (partie.getGrille().estOccupee(x, y)) {
            return;
        }

        partie.getGrille().retirerVaisseau(vaisseau.getPosX(), vaisseau.getPosY());
        partie.getGrille().placerVaisseau(vaisseau, x, y);
    }

    public void attaquer(Vaisseau attaquant, Vaisseau cible){
        if (!attaquant.estAPortee(cible)) {
            return;
        }

        cible.recevoirDegats(attaquant.getDegats());

        if (!cible.isVivant()) {
            partie.getGrille().retirerVaisseau(cible.getPosX(), cible.getPosY());
        }

        partie.verifierFinDePartie();
    }

    public void finDeTour(){
        partie.changerTour();
        partie.verifierFinDePartie();
    }

    public Partie getPartie(){
        return this.partie;
    }
}
