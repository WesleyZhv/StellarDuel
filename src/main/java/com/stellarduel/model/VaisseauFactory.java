package com.stellarduel.model;

public class VaisseauFactory {

    public static Vaisseau creer(VaisseauType type, String nom, int posX, int posY){
            switch (type) {
                case TANK:
                    return new Vaisseau(nom, VaisseauType.TANK, 200, 20, 2, posX, posY);

                case SNIPER:
                    return new Vaisseau(nom, VaisseauType.SNIPER, 60, 80, 5, posX, posY);

                case SUPPORT:
                    return new Vaisseau(nom, VaisseauType.SUPPORT, 100, 30, 3, posX, posY);

                case KAMIKAZE:
                    return new Vaisseau(nom, VaisseauType.KAMIKAZE, 80, 120, 1, posX, posY);

                default:
                    throw new IllegalArgumentException("Type de vaisseau inconnu : " + type);
            }
        }
    }

