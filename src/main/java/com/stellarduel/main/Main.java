package com.stellarduel.main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import com.stellarduel.view.MenuView;
import com.stellarduel.controller.GameController;
import com.stellarduel.controller.MenuController;


public class Main extends Application{

    public void start(Stage stage){
    stage.setTitle("Stellar Duel");
    MenuView menuView = new MenuView();
    GameController gameController = new GameController();
    MenuController menuController = new MenuController(menuView, gameController);


    stage.setScene(new Scene(menuView, 800,600));
    stage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}
