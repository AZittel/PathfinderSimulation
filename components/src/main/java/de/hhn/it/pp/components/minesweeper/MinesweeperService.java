package de.hhn.it.pp.components.minesweeper;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.exceptions.BooouuummmmException;
import de.hhn.it.pp.components.minesweeper.exceptions.InvalidGameStateException;

/**
 * This Interface is an Interface for the Game MineSweeper that shows all the
 * functionality to interact with our game.
 */
public interface MinesweeperService {
    /**
     * Creates a field of buttons.
     *
     * @param width  width for the field.
     * @param height height for the field.
     * @throws IllegalArgumentException  if the width or height is invalid.
     * @throws InvalidGameStateException is thrown if the game is already running.
     */
    FieldInformation[][] createField(int width, int height) throws IllegalArgumentException, InvalidGameStateException, IllegalParameterException;

    /**
     * Sets the bombs on the field.
     *
     * @param bombCount bombCount is the count of the bombs distributed.
     * @throws IllegalArgumentException  if the bombCount is a invalid number.
     * @throws InvalidGameStateException is thrown if the game is already running.
     */
    void setBombs(int bombCount) throws IllegalArgumentException, InvalidGameStateException;

    /**
     * Resets the Game.
     */
    FieldInformation[][] restart(int widht, int height) throws InvalidGameStateException, IllegalArgumentException, IllegalParameterException;

    /**
     * Starts the Game.
     */
    void startGame() throws InvalidGameStateException;

    /**
     * Closes the Game.
     */
    void endGame() throws InvalidGameStateException;

    /**
     * Checks the clicked field.
     * @param x x-Pos of the clicked field.
     * @param y y-Pos of the clicked field.
     */
    FieldInformation[][] turn(int x, int y) throws BooouuummmmException;

    /**
     * Sets the bombs which are used to test our program and to see if the program gets the bombs location.
     */
    void setFixBombs(BombPosition[] positions);


    /**
     * Getter for getting bombs.
     */
    BombPosition[] getBombs();

    /**
     * @return returns the current Points.
     */
    int getPoints();

    /**
     *
     * @return the Field.
     */
    FieldInformation[][] getField();

}



