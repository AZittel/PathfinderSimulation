/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.Enemies;
import de.hhn.it.pp.components.spaceinvaders.Field;
import de.hhn.it.pp.components.spaceinvaders.Player;

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

    @Override
    public void collide(boolean collision) throws GameOverException {

    }

    @Override
    public void addHighScore(List<String> highscoreList) {

    }

    @Override
    public void getHighscoreList(List<String> highscoreList) {

    }

    @Override
    public void getPositionPlayer(int xPosition, int yPosition) throws IllegalArgumentException {

    }

    @Override
    public void getPositionEnemies(int xPosition, int yPosition, int speed) throws IllegalArgumentException {

    }

    @Override
    public void restart() {}

}
