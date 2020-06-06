/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvaders implements SpaceInvadersService {



    @Override
    public void createField(int width, int height) throws IllegalParameterException {
    }

    @Override
    public void createPlayer() throws IllegalParameterException {

    }

    @Override
    public void createEnemy(int xPosition, int yPosition, EnemyType type, int speed) throws IllegalParameterException {

    }

    public void collection(Enemy aliens){

    }

    @Override
    public void movement(int xPosition, int yPosition) throws IllegalArgumentException {

    }

    @Override
    public void shooting() {

    }
    public void moveAlien(){
    }

    public int shutDown(){
     return 0;
    }
    @Override
    public void addListener(InvaderListener listener) throws IllegalParameterException {

    }

    @Override
    public void removeListener(InvaderListener listener) throws IllegalParameterException {

    }

    @Override
    public void addHighScore(List<String> highscoreList) {

    }

    @Override
    public ArrayList getHighscoreList() {
        return null;
    }

    @Override
    public Position getPositionPlayer() throws IllegalArgumentException {
        return null;
    }


    @Override
    public void getPositionEnemies() throws IllegalArgumentException {
    }

    @Override
    public void restart() {

    }
    public boolean gameOver() {
        return false;
    }

    @Override
    public int collection() {
        return 0;
    }

    public int numOfLives(){return 0;}
}