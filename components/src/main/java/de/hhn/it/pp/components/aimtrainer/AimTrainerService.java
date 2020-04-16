package de.hhn.it.pp.components.aimtrainer;

import de.hhn.it.pp.components.aimtrainer.provider.Settings;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * This Interface shows all interaction with the game AimTrainer.
 *
 */

public interface AimTrainerService {

    /**
     *Creates a window to play the game.
     * @param nickname Nick of the active player.
     * @param settings Settings for this Session.
     * @throws IllegalParameterException nickname is to long or settings are invalid.
     */
    void startGame(String nickname, Settings settings) throws IllegalParameterException;

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