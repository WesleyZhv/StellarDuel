package com.stellarduel.controller;

import com.stellarduel.view.*;

public class MenuController {

    private MenuView menuView;
    private GameController gameController;

    public MenuController(MenuView menuView, GameController gameController){
        this.menuView = menuView;
        this.gameController = gameController;

        this.menuView.getBoutonJoueur().setOnAction(e -> {
                String nom = menuView.getChampNom().getText();
                String difficulte = menuView.getComboDifficulte().getValue();
                this.gameController.initialiserPartie(nom, difficulte);

        });

    }
}
