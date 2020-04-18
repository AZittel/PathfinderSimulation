/**
  @Author Darko Miklic, Marc Nauendorf
 * @Version 18.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * This Interface is an Interface for the Game Space Invaders that shows all the
 * functionality to interact with our game.
 */
public interface SpaceInvadersService {
    /**
     * Creates a the background field
     * @param width width for the field
     * @param height height for the field
     * @throws IllegalParameterException if the width or height is invalid
     */
    void createField(int width, int height) throws IllegalParameterException;

    /**
     * Creates the player
     * @param yPos for the position on the y axis
     * @param xPos for the position on the x axis
     * @throws IllegalParameterException if the width or height is invalid
     */
    void createPlayer(int xPos, int yPos) throws IllegalParameterException;

    /**
     * Creates the enemies
     * @param xPosition for the position on the x axis
     * @param yPosition for the position on the y axis
     * @param speed for the movement speed of the enemies
     * @throws IllegalParameterException if the xPos, yPos or speed is invalid
     */
    void createEnemies(int xPosition, int yPosition, int speed) throws IllegalParameterException;

    /**
     * @param xMovement direction of move x
     * @param yMovement direction of move y
     * @param shoot boolean for shoot
     * @throws IllegalArgumentException direction steps out of window
     */
    void movement(int xMovement, int yMovement, boolean shoot) throws  IllegalArgumentException;

    /**
     * @param score the counter for destroyed enemies
     */
    void showHighscore(int score);

    /**
     *  Resets the Game.
     */
    void restart();
}
