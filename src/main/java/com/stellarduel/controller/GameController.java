package com.stellarduel.controller;

import com.stellarduel.model.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import com.stellarduel.view.*;
import javafx.scene.paint.Color;
import com.stellarduel.storage.GameStorage;
import javafx.scene.control.Tooltip;

public class GameController implements IObservateur {

    private Partie partie;
    private Stage stage;
    private GameView gameView;
    private Vaisseau vaisseauSelectionne;
    private IAController iaController;
    private GameStorage gameStorage;

    public GameController(Stage stage) {
        this.stage = stage;
        this.vaisseauSelectionne = null;
        this.iaController = new IAController();
        this.gameStorage = new GameStorage();
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
        this.partie.ajouterObservateur(this);

        this.gameView = new GameView();
        stage.setScene(new Scene(gameView, 800, 600));
        rafraichirGrille();
        brancherClics();
        brancherBoutons();
    }

    public void deplacerVaisseau(Vaisseau vaisseau, int x, int y) {
        if (!partie.getGrille().estDansGrille(x, y)) {
            return;
        }

        if (partie.getGrille().estOccupee(x, y)) {
            return;
        }

        partie.getGrille().retirerVaisseau(vaisseau.getPosX(), vaisseau.getPosY());
        partie.getGrille().placerVaisseau(vaisseau, x, y);

    }

    public void attaquer(Vaisseau attaquant, Vaisseau cible) {
        if (!attaquant.estAPortee(cible)) {
            return;
        }

        cible.recevoirDegats(attaquant.getDegats());

        if (!cible.isVivant()) {
            partie.getGrille().retirerVaisseau(cible.getPosX(), cible.getPosY());
        }

        partie.verifierFinDePartie();
    }

    public void finDeTour() {
        partie.changerTour();
        partie.verifierFinDePartie();
        if (partie.getJoueurActif().estIA()) {
            iaController.jouerTour(partie, this);
            rafraichirGrille();
            partie.changerTour();
        }
    }

    public Partie getPartie() {
        return this.partie;
    }

    public void rafraichirGrille() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                gameView.getCase(x, y).setFill(Color.DARKBLUE);
            }
        }
        for (Vaisseau v : partie.getJoueur1().getFlotteVivante()) {
            gameView.getCase(v.getPosX(), v.getPosY()).setFill(Color.CYAN);
        }
        for (Vaisseau v : partie.getJoueur2().getFlotteVivante()) {
            gameView.getCase(v.getPosX(), v.getPosY()).setFill(Color.RED);
        }

        for (Vaisseau v : partie.getJoueur1().getFlotteVivante()) {
            Tooltip tip = new Tooltip(v.getNom() + "\nPV: " + v.getPointDeVie() + "\nDégâts: " + v.getDegats() + "\nPortée: " + v.getPortee());
            Tooltip.install(gameView.getCase(v.getPosX(), v.getPosY()), tip);
        }

        for (Vaisseau v : partie.getJoueur2().getFlotteVivante()) {
            Tooltip tip = new Tooltip(v.getNom() + "\nPV: " + v.getPointDeVie() + "\nDégâts: " + v.getDegats() + "\nPortée: " + v.getPortee());
            Tooltip.install(gameView.getCase(v.getPosX(), v.getPosY()), tip);
        }

        gameView.getLabelJoueur().setText("Joueur actif : " + partie.getJoueurActif().getNom());
        gameView.getLabelTour().setText("Tour : " + partie.getTourNumero());

        if (partie.isPartieTerminee()) {
            VictoryView victoryView = new VictoryView(partie.getGagnant().getNom());
            stage.setScene(new Scene(victoryView, 800, 600));
            victoryView.getBoutonRejouer().setOnAction(e -> {
                stage.setScene(new Scene(new MenuView(), 800, 600));
            });
        }


    }

    public void brancherClics() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                final int fx = x;
                final int fy = y;
                gameView.getCase(fx, fy).setOnMouseClicked(e -> {
                    Vaisseau v = partie.getGrille().getVaisseau(fx, fy);
                    if (v != null && partie.getJoueurActif().getFlotte().contains(v)) {
                        vaisseauSelectionne = v;
                        rafraichirGrille();
                        gameView.getCase(fx, fy).setFill(Color.YELLOW);
                    } else if (v == null && vaisseauSelectionne != null) {
                        deplacerVaisseau(vaisseauSelectionne, fx, fy);
                        vaisseauSelectionne = null;
                        rafraichirGrille();
                    } else if (v != null && vaisseauSelectionne != null && partie.getJoueur2().getFlotteVivante().contains(v)) {
                        attaquer(vaisseauSelectionne, v);
                        vaisseauSelectionne = null;
                        rafraichirGrille();
                    }
                });

            }
        }
    }

    public void brancherBoutons() {
        gameView.getBoutonSauvegarder().setOnAction(e -> {
            gameStorage.sauvegarder(partie);
        });

        gameView.getBoutonCharger().setOnAction(e -> {
            partie = gameStorage.charger();
            rafraichirGrille();
        });

        gameView.getBoutonFinTour().setOnAction(e -> {
            finDeTour();
            rafraichirGrille();
        });
    }

    public void mettreAJour(){
        rafraichirGrille();
    }
}
