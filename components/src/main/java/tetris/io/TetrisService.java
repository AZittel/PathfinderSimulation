package tetris.io;

/**
 * This Interface is an Interface for Tetris that shows all the
 * functionality to interact with our game.
 */

public interface TetrisService {

    /**
     * Start a game of Tetris
     */
    void startGame();

    /**
     * Select a difficulty setting for Tetris
     */
    void setDifficulty();
}
