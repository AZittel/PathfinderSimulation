/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.*;

import java.util.List;

public class SpaceInvaders implements SpaceInvadersService {

    @Override
    public void createField(int width, int height) throws IllegalParameterException {

    }

    @Override
    public void createPlayer(int xPos, int yPos) throws IllegalParameterException {

    }

    @Override
    public void createEnemy(int xPosition, int yPosition, EnemyType type, int speed) throws IllegalParameterException {

    }

    @Override
    public void movement(int xPosition, int yPosition) throws IllegalArgumentException {

    }

    @Override
    public void shooting() {

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
    public List<HighScoreEntry> getHighscoreList() {
        return null;
    }

    @Override
    public Position getPositionPlayer() throws IllegalArgumentException {
        return null;
    }

    @Override
    public List<Position> getPositionEnemies() throws IllegalArgumentException {
        return null;
    }

    @Override
    public void restart() {

    }
}