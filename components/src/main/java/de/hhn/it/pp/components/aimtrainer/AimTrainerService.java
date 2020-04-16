package de.hhn.it.pp.components.aimtrainer;

import de.hhn.it.pp.components.aimtrainer.provider.Difficulty;
import de.hhn.it.pp.components.aimtrainer.provider.Settings;
import de.hhn.it.pp.components.aimtrainer.provider.Target;
import de.hhn.it.pp.components.aimtrainer.provider.TargetState;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This Interface shows all interaction with the game AimTrainer.
 *
 */

public interface AimTrainerService {

    /**
     * Changes Settings to given type of Difficulty.
     * @param difficulty Difficulty setting to change to
     * @throws IllegalStateException difficulty does not exist.
     */
    void changeSettings(Difficulty difficulty) throws IllegalStateException;

    /**
     * Creates a window to play the game.
     * @param nickname Nick of the active player.
     * @param settings Settings for this Session.
     * @throws IllegalParameterException Nickname is to long or settings are invalid.
     * @throws IllegalStateException Used type of Settings is not accessible or does not exist.
     */
    void startGame(String nickname, Settings settings) throws IllegalParameterException, IllegalStateException;

    /**
     * Creates the targets.
     * @param difficulty Difficulty setting for this Session.
     * @throws IllegalStateException difficulty does not exist.
     */
    void createTarget(Difficulty difficulty) throws IllegalStateException;

    /**
     * Deletes the clicked targets.
     * @param target The target to be deleted.
     * @throws IllegalParameterException target does not exist.
     */
    void breakTarget(Target target) throws IllegalParameterException;

    /**
     * Calculates the score based on Hit and Miss rate.
     * @param targetStates List containing all end target states.
     * @throws IllegalParameterException Provided list is empty or does not exist.
     */
    void calculateSessionScore(ArrayList<TargetState> targetStates) throws IllegalParameterException;

    /**
     * Adds the calculated score to Score list.
     * @param score Calculated Score of Session.
     * @throws IllegalParameterException parameter has an invalid value.
     */
    void addSessionScore(int score) throws IllegalParameterException;

    /**
     *  Creates a window that shows a list with all the HighScores.
     * @param highScores Map containing the top 10 Player Scores.
     * @throws IllegalParameterException Provided list is empty or does not exist.
     */
    void showHighScoreList(HashMap<String, Integer> highScores) throws IllegalParameterException;

}