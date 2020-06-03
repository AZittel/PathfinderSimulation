/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.SpaceInvadersService;

import java.util.List;

public class SpaceInvaders implements SpaceInvadersService {

    @Override
    public void createField(int width, int height) {new Field();}

    @Override
    public void createPlayer(int xPos, int yPos) {new Player();}

    @Override
    public void createEnemies(int xPosition, int yPosition, int speed) {new Enemies();}

    @Override
    public void movement(int xMovement, int yMovement) throws IllegalArgumentException {

    }

    @Override
    public void shooting(boolean shoot) {

    }

    public boolean collide(boolean collision) throws GameOverException {
            return collision;
    }

    @Override
    public void addHighScore(List<String> highscoreList) {

    }

    @Override
    public List<String> getHighscoreList(List<String> highscoreList) {
            return highscoreList;
    }

    @Override
    public int[][] getPositionPlayer(int[][] arr) throws IllegalArgumentException {
            return arr;
    }

    @Override
    public int[][] getPositionEnemies(int[][] arr, int speed) throws IllegalArgumentException {
            return arr;
    }

    @Override
    public void restart() {}

}
