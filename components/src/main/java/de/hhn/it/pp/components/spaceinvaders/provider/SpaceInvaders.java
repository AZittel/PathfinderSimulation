package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.Enemies;
import de.hhn.it.pp.components.spaceinvaders.Field;
import de.hhn.it.pp.components.spaceinvaders.Player;

public class SpaceInvaders implements SpaceInvadersService {


    @Override
    public void createField(int width, int height) {
        new Field();
    }

    @Override
    public void createPlayer(int xPos, int yPos) {
        new Player();
    }

    @Override
    public void createEnemies(int xPos, int yPos, int speed) {
        new Enemies();
    }

    @Override
    public void restart() {
    }

}
