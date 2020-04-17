/**
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.Enemies;
import de.hhn.it.pp.components.spaceinvaders.Field;

public class SpaceInvaders implements SpaceInvadersService {


    @Override
    public void createField(int width, int height) {
        new Field();
    }

    @Override
    public void createPlayer(int xPos, int yPos) { }

    @Override
    public void createEnemies(int xPosition, int yPosition, int speed) {
        new Enemies();
    }

    @Override
    public void restart() {}

}
