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
     *Creates a window to play the game.
     */
    void startGame();

    /**
     *Creates the targets.
     * @param xpos position on x axis.
     * @param ypos position on y axis.
     * @param lifetime time until the target disappears.
     */
    void createTarget(double xpos, double ypos, int lifetime);

    /**
     * Deletes the clicked targets.
     * @param xpos position on x axis.
     * @param ypos position on y axis.
     */
    void breakTarget(double xpos, double ypos);

    /**
     * Adds the score of the current session.
     */
    void addSessionScore();

    /**
     *  Creates a window that shows a list with all the highscores.
     */
    void showHighscoreList();

}