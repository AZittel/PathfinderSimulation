package de.hhn.it.pp.components.minesweeper;

import java.awt.Point;

/**
 * This Interface is an Interface for the Game MineSweeper that shows all the
 * functionality to interact with our game.
 */
public interface MinesweeperService {

    /**
     * To start a Game u need to start the Menu and
     * choose the difficulty.
     */
    void startMenu();

    /**
     * Creates a field of buttons.
     * @param  width width for the field.
     * @param height height for the field.
     * @throws IllegalArgumentException if the width or height is invalid.
     */
    void createField(int width, int height) throws  IllegalArgumentException;

    /**
     * Sets the bombs on the field.
     * @param  bombCount bombCount is the count of the bombs distributed.
     * @throws IllegalArgumentException if he cant set a Bomb on that button.
     */
    void setBombs(int bombCount) throws IllegalArgumentException;

    /**
     *  Resets the Game.
     */
    void reset();



}
