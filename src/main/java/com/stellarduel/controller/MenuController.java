package com.stellarduel.controller;

import com.stellarduel.view.*;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MenuController {

    private MenuView menuView;
    private GameController gameController;
    private Stage stage;

    public MenuController(MenuView menuView, GameController gameController, Stage stage){
        this.menuView = menuView;
        this.gameController = gameController;
        this.stage = stage;

        this.menuView.getBoutonJoueur().setOnAction(e -> {
                String nom = menuView.getChampNom().getText();
                String difficulte = menuView.getComboDifficulte().getValue();

                FlotteSelectionView flotteView = new FlotteSelectionView();
                new FlotteSelectionController(flotteView, gameController, nom, difficulte);

            stage.setScene(new Scene(flotteView, 800, 600));
        });

    }
}
