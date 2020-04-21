package de.hhn.it.pp.components.minesweeper;

import de.hhn.it.pp.components.minesweeper.exceptions.InvalidGameStateException;



/**
 * This Interface is an Interface for the Game MineSweeper that shows all the
 * functionality to interact with our game.
 */
public interface MinesweeperService {
    /**
     * Creates a field of buttons.
     * @param  width width for the field.
     * @param height height for the field.
     * @throws IllegalArgumentException if the width or height is invalid.
     * @throws InvalidGameStateException is thrown if the game is already running.
     */
    void createField(int width, int height) throws IllegalArgumentException,InvalidGameStateException;

    /**
     * Sets the bombs on the field.
     * @param  bombCount bombCount is the count of the bombs distributed.
     * @throws IllegalArgumentException if the bombCount is a invalid number.
     * @throws InvalidGameStateException is thrown if the game is already running.
     */
    void setBombs(int bombCount) throws IllegalArgumentException, InvalidGameStateException;

    /**
     *  Resets the Game.
     */
    void restart();

    /**
     *  Starts the Game.
     */
    void startGame();

    /**
     *  Closes the Game.
     */
    void endGame();

    /**
     *  @param x x-Pos of the clicked field.
     *  @param y y-Pos of the clicked field.
     *  Resets the Game.
     */
    void turn(int x, int y);

}
