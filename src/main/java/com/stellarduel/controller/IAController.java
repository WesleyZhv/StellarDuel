package com.stellarduel.controller;

import com.stellarduel.model.*;

public class IAController {

    private IStrategieIA strategie;

    public IAController(IStrategieIA strategie) {
        this.strategie = strategie;
    }

    public void jouerTour(Partie partie, GameController gameController) {
        strategie.jouer(partie, gameController);
    }
}