/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.Position;

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
    void gameOver() {
    }
    /**
     * Player move up
     */
    void playerMoveUp() {
    }
    /**
     * Player move down
     */
    void playerMoveDown(){
    }
    /**
     * Player move right
     */
    void playerMoveRight(){
    }
    /**
     * Player move left
     */
    void playerMoveLeft(){
    }
    /**
     * Player is shooting
     */
    void shot(){
    }
}
