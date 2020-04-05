/**
 * @Author Darko Miklic, Marc Nauendorf
 * @Version 05.04.2020
 */

package de.hhn.it.pp.components.SpaceInvaders;

/**
 * This Interface is an Interface for the Game Space Invaders that shows all the
 * functionality to interact with our game.
 */
public interface SpaceInvadersService {
    /**
     * Creates a the background field
     * @param width width for the field
     * @param height height for the field
     */
    void createField(int width, int height);

    /**
     * Creates the player
     * @param xPos for the position on the x axis
     * @param yPos for the position on the y axis
     */
    void createPlayer(int xPos, int yPos);

    /**
     * Creates the enemies
     * @param xPos for the position on the x axis
     * @param yPos for the position on the y axis
     * @param speed for the movement speed of the enemies
     */
    void createEnemies(int xPos, int yPos, int speed);
}
