package com.stellarduel.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VaisseauTest {

    @Test
    public void testRecevoirDegats(){
        Vaisseau tank = VaisseauFactory.creer(VaisseauType.TANK, "Titan", 0, 0);
        tank.recevoirDegats(50);
        assertEquals(150, tank.getPointDeVie());
    }

    @Test
    public void testMortVaisseau(){
        Vaisseau tank = VaisseauFactory.creer(VaisseauType.TANK,"Titan",0,0);
        tank.recevoirDegats(250);
        assertFalse(tank.isVivant());
    }

    @Test
    public void testEstAPortee(){
        Vaisseau tank = VaisseauFactory.creer(VaisseauType.TANK,"Titan",0,0);
        Vaisseau sniper = VaisseauFactory.creer(VaisseauType.SNIPER, "Elite", 0,0);
        assertTrue(tank.estAPortee(sniper));
    }
}