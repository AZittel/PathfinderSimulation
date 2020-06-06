/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.spaceinvaders.Position;

import java.util.ArrayList;

//TODO: Das hier zuletzt weil wir von der UI aus zum Cotroller gehen.

public class Player {
    int x;
    int y;
    int numLives;
    int numShutDowns = 0;
    public static ArrayList<Projectile> projectiles = new ArrayList<>();

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void movement(){
        y++;
    }
    /**
     * Player died
     */
    void gameOver() {}
    /**
     * Player move up
     */
    public void shoot(){
        Projectile projectile = new Projectile(10, 10);
        projectiles.add(projectile);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
