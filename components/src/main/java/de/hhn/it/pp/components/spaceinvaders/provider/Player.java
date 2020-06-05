/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.Position;

//TODO: Das hier zuletzt weil wir von der UI aus zum Cotroller gehen.

public class Player extends Position {
    int numLives;
    int numShutDowns = 0;

    public Player(int x, int y) {
        super(x, y);
    }

    void movement(){}
    /**
     * Player died
     */
    void gameOver() {}
    /**
     * Player move up
     */
    void shoot(){}
}
