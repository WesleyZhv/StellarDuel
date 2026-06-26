package com.stellarduel.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MenuView extends VBox{

    private Label titre;
    private TextField champNom;
    private Button boutonJoueur;

    public MenuView() {
        this.titre = new Label("Stellar Duel");
        this.champNom = new TextField();
        this.boutonJoueur = new Button("Jouer");
        setSpacing(10);
        getChildren().addAll(this.titre, this.champNom, this.boutonJoueur);
    }

    public TextField getChampNom(){
        return this.champNom;
    }

    public Button getBoutonJoueur(){
        return this.boutonJoueur;
    }
}
