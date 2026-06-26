package com.stellarduel.view;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;

public class GameView extends BorderPane{

    private Rectangle[][] grilleCases;
    private GridPane grillePane;
    private Label labelTour;
    private Label labelJoueur;
    private Button boutonFinTour;
    private Button boutonSauvegarder;
    private Button boutonCharger;

    public GameView(){
        this.grilleCases = new Rectangle[8][8];
        this.grillePane = new GridPane();
        this.labelTour = new Label("Tour 1");
        this.labelJoueur = new Label("Joueur actif : ");
        this.boutonFinTour = new Button("Fin de tour");
        this.boutonSauvegarder = new Button("Sauvegarder");
        this.boutonCharger = new Button("Charger");

        for(int x = 0; x < 8 ;x++){
            for(int y = 0; y < 8 ;y++){
                Rectangle rect = new Rectangle(60,60);
                rect.setFill(Color.DARKBLUE);
                rect.setStroke(Color.CYAN);
                this.grilleCases[x][y] = rect;
                grillePane.add(rect, x,y);
            }
        }
        VBox panneauInfo = new VBox(10, labelJoueur, labelTour, boutonSauvegarder, boutonCharger);
        setCenter(grillePane);
        setRight(panneauInfo);
        setBottom(boutonFinTour);
    }

    public GridPane getGrillePane(){
        return this.grillePane;
    }

    public Rectangle getCase(int x, int y){
        return this.grilleCases[x][y];
    }

    public Label getLabelTour(){
        return this.labelTour;
    }

    public Label getLabelJoueur() {
        return this.labelJoueur;
    }

    public Button getBoutonFinTour(){
        return this.boutonFinTour;
    }

    public Button getBoutonSauvegarder(){
        return this.boutonSauvegarder;
    }

    public Button getBoutonCharger(){
        return this.boutonCharger;
    }

}
