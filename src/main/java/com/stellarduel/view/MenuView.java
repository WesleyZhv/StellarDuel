package com.stellarduel.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import  javafx.geometry.Pos;

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
        setAlignment(Pos.CENTER);
        this.champNom.setPromptText("Entrez votre nom");
        this.titre.setStyle("-fx-font-size: 32px;");
        setStyle("-fx-background-color: #0a0a1a;");
        this.titre.setStyle("-fx-font-size: 48px; -fx-text-fill: #00aaff; -fx-font-weight: bold;");
        this.champNom.setMaxWidth(300);
        this.boutonJoueur.setStyle("-fx-background-color: #00aaff; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 30;");
        this.boutonJoueur.setMinWidth(150);
    }

    public TextField getChampNom(){
        return this.champNom;
    }

    public Button getBoutonJoueur(){
        return this.boutonJoueur;
    }
}
