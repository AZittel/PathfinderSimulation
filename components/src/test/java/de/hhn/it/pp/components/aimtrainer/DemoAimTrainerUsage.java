package de.hhn.it.pp.components.aimtrainer;

import de.hhn.it.pp.components.aimtrainer.provider.AimTrainer;
import de.hhn.it.pp.components.aimtrainer.provider.Difficulty;
import de.hhn.it.pp.components.aimtrainer.provider.Settings;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;


public class DemoAimTrainerUsage {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(DemoAimTrainerUsage.class);

    public static void main(String[] args) throws InterruptedException, IllegalParameterException {

        //Create Interface for Aimtrainer
        logger.info(">>> create AimTrainer Service");
        AimTrainer trainer = new AimTrainer();
        logger.info("Trainer-Object: " + trainer);

        Thread.sleep(2000);

        //Create settings
        logger.info(">>> Creating Settings data");
        Settings settings = new Settings((Difficulty.BEGINNER));
        logger.info("Settings-Object:" + trainer.settings);
        logger.info("Default Difficulty: " + trainer.settings.getDifficulty());

        Thread.sleep(2000);

        //Change Settings
        logger.info(">>> Changing difficulty to AMATEUR");
        trainer.settings.setDifficulty(Difficulty.AMATEUR);
        logger.info("Difficulty: " + trainer.settings.getDifficulty());

        Thread.sleep(2000);

        //Start the Game
        logger.info(">>> Starting Training session");
        trainer.startGame("Noob42", trainer.settings);

        Thread.sleep(2000);

        //Create target to break
        logger.info(">>> Creating breakable target");
        trainer.createTarget(trainer.settings.getDifficulty());
        logger.info("TargetState: " + trainer.target.getState());

        Thread.sleep(2000);

        //Break the target
        logger.info(">>> Target has been hit! Breaking target");
        trainer.breakTarget(trainer.target);
        logger.info("TargetState: " + trainer.target.getState());

        Thread.sleep(2000);

        //Create target to break
        logger.info(">>> Creating breakable target");
        trainer.createTarget(trainer.settings.getDifficulty());
        logger.info("TargetState: " + trainer.target.getState());

        Thread.sleep(3000);

        //Break the target
        logger.info(">>> Target has been missed!");
        trainer.missedTarget(trainer.target);
        logger.info("TargetState: " + trainer.target.getState());

        Thread.sleep(2000);

        //Calculate Session score
        logger.info(">>> Session has ended, calculating Score");
        trainer.calculateSessionScore(trainer.targetStates);
        logger.info("" + trainer.score);

        Thread.sleep(2000);

        //Add score of Session
        logger.info(">>> Adding Score of Session to Highscore-list");
        trainer.addSessionScore(trainer.score);

        Thread.sleep(2000);

        //Show Highscore-list
        logger.info(">>> Displaying Highscore-list");
        trainer.showHighScoreList(trainer.highScores);
        logger.info("" + trainer.highScores.toString());

        Thread.sleep(3000);

    }
}
