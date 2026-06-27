package com.stellarduel.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;

public class MenuView extends StackPane {

    private Label titre;
    private TextField champNom;
    private Button boutonJoueur;
    private EtoileAnimation etoile;
    private ComboBox<String> comboDifficulte;

    public MenuView() {
        this.titre = new Label("Stellar Duel");
        this.champNom = new TextField();
        this.boutonJoueur = new Button("Jouer");
        this.comboDifficulte = new ComboBox<String>();
        this.comboDifficulte.getItems().addAll("Facile", "Normal");
        this.comboDifficulte.setValue("Normal");

        this.titre.setStyle("-fx-font-size: 48px; -fx-text-fill: #00aaff; -fx-font-weight: bold;");
        this.champNom.setMaxWidth(300);
        this.champNom.setPromptText("Entrez votre nom");
        this.boutonJoueur.setStyle("-fx-background-color: #00aaff; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10 30;");
        this.boutonJoueur.setMinWidth(150);

        this.etoile = new EtoileAnimation(800, 600);
        this.etoile.demarrer();

        VBox contenu = new VBox(20, titre, champNom, comboDifficulte, boutonJoueur);
        contenu.setAlignment(Pos.CENTER);

        getChildren().addAll(etoile.getCanvas(), contenu);
    }

    public TextField getChampNom() {
        return this.champNom;
    }

    public Button getBoutonJoueur() {
        return this.boutonJoueur;
    }

    public ComboBox<String> getComboDifficulte(){
        return this.comboDifficulte;
    }
}