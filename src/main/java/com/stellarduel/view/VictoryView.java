package com.stellarduel.view;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class VictoryView extends VBox {

    private Label labelGagnant;
    private Button boutonRejouer;

    public VictoryView(String nomGagnant){
    labelGagnant = new Label(nomGagnant + " a gagné !");
        labelGagnant.setStyle("-fx-font-size: 36px; -fx-text-fill: #00aaff;");
        setStyle("-fx-background-color: #0a0a1a;");

    boutonRejouer = new Button("Rejouer");
    setAlignment(Pos.CENTER);
    setSpacing(20);
    getChildren().addAll(labelGagnant, boutonRejouer);

    }

    public Label getLabelGagnant(){
        return this.labelGagnant;
    }

    public Button getBoutonRejouer(){
        return this.boutonRejouer;
    }

}
