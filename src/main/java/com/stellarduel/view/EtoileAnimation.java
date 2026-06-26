package com.stellarduel.view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import java.util.Random;

public class EtoileAnimation {

    private Canvas canvas;
    private double[] etoilesX;
    private double[] etoilesY;
    private double[] vitesse;

    public EtoileAnimation(double largeur, double hauteur){
        this.canvas = new Canvas(largeur, hauteur);
        this.etoilesX = new double[150];
        this.etoilesY = new double[150];
        this.vitesse = new double[150];

        Random random = new Random();
        for(int i = 0; i < 150 ;i++){
            etoilesX[i] = random.nextDouble() * largeur;
            etoilesY[i] = random.nextDouble() * hauteur;
            vitesse[i] = random.nextDouble() * 2 + 0.5;
        }
    }

    public Canvas getCanvas(){
        return this.canvas;
    }

    public void demarrer(){
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(Color.BLACK);
                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                gc.setFill(Color.WHITE);
                for (int i = 0; i < 150 ; i++) {
                    gc.fillOval(etoilesX[i], etoilesY[i], 2, 2);
                    etoilesY[i] += vitesse[i];

                    if(etoilesY[i]>canvas.getHeight()){
                        etoilesY[i] = 0;
                    }
                }

            }
        };
        timer.start();
    }
}
