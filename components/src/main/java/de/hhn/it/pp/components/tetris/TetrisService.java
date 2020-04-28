package de.hhn.it.pp.components.tetris;
import de.hhn.it.pp.components.tetris.provider.logic.Tetromino;

import java.io.IOException;

/**
 * This Interface is an Interface for Tetris that shows all the
 * functionality to interact with our game.
 */

public interface TetrisService {

    /**
     * Start a game of Tetris
     * @throws IllegalStateException if the method is called while in an active game
     */
    void startGame() throws IllegalStateException;

    /**
     * Select a difficulty setting for Tetris
     * @throws IllegalStateException if the method is called while in an active game
     */
    void setDifficulty() throws IllegalStateException;

    /**
     * Move the current Tetromino (left/right/down)
     * @param direction the direction in which the Tetromino should be moved
     * @throws NullPointerException if the value of the string is null
     */
    void move(String direction) throws NullPointerException;

    /**
     * Rotate the current Tetromino
     */
    void rotate();

    /**
     * Reset the board and score value back to default (0)
     */
    void reset();

    /**
     * Saves the current game progress
     * @throws IOException if a file can not be saved for some reason
     */
    void save() throws IOException;

    /**
     * Loads a previously saved game
     * @throws IOException if the save file can't be found
     */
    void load() throws IOException;

    /**
     * Shows the rotation value of the currently active Tetromino
     * @throws IllegalStateException in case the game is currently not in the correct (activeGame) state
     * @throws NullPointerException if there is no Tetromino
     */
    int getCurrentTetrominoRotation() throws IllegalStateException, NullPointerException;

    /**
     * Returns the current speed value of the active Tetromino
     * @throws IllegalStateException if the method is called while not in an active game
     */
    int getCurrentTetrominoSpeed() throws IllegalStateException;

    /**
     * Shows the location of a specified Tetromino
     * @param tetromino the Tetromino who gets located
     * @throws NullPointerException if the Tetromino can't be found
     */
    void getTetrominoLocation(Tetromino tetromino) throws NullPointerException;

    /**
     * Shows the rotation value of a specified Tetromino
     * @throws NullPointerException if there is no Tetromino
     */
    int getTetrominoRotation() throws NullPointerException;
}
