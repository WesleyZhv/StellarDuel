package com.stellarduel.main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

public class Main extends Application{

    public void start(Stage stage){
    stage.setTitle("Stellar Duel");



    stage.setScene(new Scene(new javafx.scene.layout.StackPane(), 800, 600));
    stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
