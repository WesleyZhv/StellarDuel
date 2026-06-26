package com.stellarduel.storage;

import com.stellarduel.model.Partie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;

public class GameStorage {

    private static final String CHEMIN_FICHIER = "save.json";

    public GameStorage(){}

    public void sauvegarder(Partie partie){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(CHEMIN_FICHIER);
            gson.toJson(partie, writer);
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public Partie charger(){
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(CHEMIN_FICHIER);
            Partie partie = gson.fromJson(reader, Partie.class);
            reader.close();
            return partie;
        } catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
