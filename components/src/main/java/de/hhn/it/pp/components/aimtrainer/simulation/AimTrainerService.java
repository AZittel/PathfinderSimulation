package de.hhn.it.pp.components.aimtrainer.simulation;

/**
 * This Interface shows all interaction with the game AimTrainer.
 *
 */

public interface AimTrainerService {

    /**
     * Creates the main menu of the game.
     */
    void createMainMenu();

    /**
     * Creates a window that plays the game.
     */
    void startGame();

    /**
     *  Creates a window that shows all the highscores.
     */
    void showHighScoreList();

    /**
     * Closes the window of the game.
     */
    void exitGame();
}