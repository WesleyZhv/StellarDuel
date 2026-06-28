package com.stellarduel.view;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class FlotteSelectionView extends StackPane {

    private Label titre;
    private ComboBox<String>[] combosType;
    private TextField[] champsNom;
    private Button boutonConfirmer;
    private EtoileAnimation etoile;

    public FlotteSelectionView(){
        this.combosType = new ComboBox[4];
        this.champsNom = new TextField[4];
        this.boutonConfirmer = new Button("Confirmer");
        this.titre = new Label("Choisissez votre flotte");

        for(int i = 0; i<4; i++){
            combosType[i] = new ComboBox<>();
            combosType[i].getItems().addAll("TANK", "SNIPER","SUPPORT","KAMIKAZE");
            combosType[i].setValue("TANK");
            champsNom[i] = new TextField();
            champsNom[i].setPromptText("Nom du vaisseau : " + (i+1));
        }

        VBox contenu = new VBox(15);
        contenu.getChildren().add(titre);
        this.titre.setStyle("-fx-font-size: 36px; -fx-text-fill: #00aaff; -fx-font-weight: bold;");
        contenu.setAlignment(Pos.CENTER);

        for(int i = 0; i<4; i++) {
            HBox creationVaisseau = new HBox(combosType[i], champsNom[i]);
            contenu.getChildren().add(creationVaisseau);
        }
        contenu.getChildren().add(boutonConfirmer);
        this.etoile = new EtoileAnimation(800, 600);
        this.etoile.demarrer();
        getChildren().addAll(etoile.getCanvas(), contenu);
    }

    public ComboBox<String>[] getCombosType(){
        return this.combosType;
    }

    public TextField[] getChampsNom(){
        return this.champsNom;
    }

    public Button getBoutonConfirmer(){
        return this.boutonConfirmer;
    }
}

