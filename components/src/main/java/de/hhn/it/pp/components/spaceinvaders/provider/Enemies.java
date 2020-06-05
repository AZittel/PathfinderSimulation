/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;


import de.hhn.it.pp.components.spaceinvaders.EnemyType;

import java.util.ArrayList;

public class Enemies {
    ArrayList<Enemies> aliens = new ArrayList<>();



    public Enemies(int x, int y, EnemyType standard, int speed) {
    }


    /**
     * creating an Array of Enemies
     */
    // Erzeugt ein Array von der Größe 20
    public void createAlien(){

        /* for(int i = 0; i <20; i++){
        Enemies enemy = new Enemies();
        aliens.add(enemy);
        } */

    }
    /**
     * Enemies can move to their goal
     */
    public void moveAlien(){
    }

    void shutDown(){

    }

}
