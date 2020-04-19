package de.hhn.it.pp.components.tetris;
import java.io.IOException;

/**
 * This Interface is an Interface for Tetris that shows all the
 * functionality to interact with our game.
 */

public interface TetrisService {

    /**
     * Start a game of Tetris
     */
    void startGame() throws IllegalStateException;

    /**
     * Select a difficulty setting for Tetris
     */
    void setDifficulty() throws IllegalStateException;

    /**
     *  Move the current Tetromino (left/right/down)
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
     */
    void save() throws IOException;

    /**
     * Loads a previously saved game
     */
    void load() throws IOException;
}
