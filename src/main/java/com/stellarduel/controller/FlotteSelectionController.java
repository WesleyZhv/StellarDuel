package com.stellarduel.controller;

import com.stellarduel.view.*;

public class FlotteSelectionController {

    private FlotteSelectionView flottView;
    private GameController gameController;
    private String nomJoueur;
    private String difficulte;

    public FlotteSelectionController(FlotteSelectionView flottView, GameController gameController, String nomJoueur, String difficulte){
        this.flottView = flottView;
        this.gameController = gameController;
        this.nomJoueur = nomJoueur;
        this.difficulte = difficulte;

        flottView.getBoutonConfirmer().setOnAction( e -> {
            String[] types = new String[4];
            String[] noms = new String[4];
            for(int i = 0; i<4; i++) {
                types[i] = flottView.getCombosType()[i].getValue();
                noms[i] = flottView.getChampsNom()[i].getText();

            }
            confirmerFlotte(types, noms);
        });

    }
    public void confirmerFlotte(String[] types, String[] noms){
        gameController.initialiserPartie(nomJoueur, difficulte, types, noms);
    }
}
