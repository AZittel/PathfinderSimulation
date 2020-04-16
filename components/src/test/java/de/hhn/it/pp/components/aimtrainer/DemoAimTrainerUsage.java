package de.hhn.it.pp.components.aimtrainer;

import de.hhn.it.pp.components.aimtrainer.provider.AimTrainer;
import de.hhn.it.pp.components.aimtrainer.provider.Settings;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;


public class DemoAimTrainerUsage {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(DemoAimTrainerUsage.class);

    public static void main(String[] args) throws InterruptedException, IllegalParameterException {

        //Create Interface for Aimtrainer
        logger.info(">>> create AimTrainer Service");
        AimTrainerService aimtrainerService = new AimTrainer();
        logger.info("" + aimtrainerService);

        Thread.sleep(2000);

        //Start the Game
        logger.info(">>> Starting Training session");
        aimtrainerService.startGame("Nick", new Settings());
        logger.info("" + aimtrainerService);

        Thread.sleep(2000);

        //Create target to break
        logger.info(">>> Creating breakable target");
        //aimtrainerService.createTarget();
        logger.info("" + aimtrainerService);

        Thread.sleep(2000);

        //Break the target
        logger.info(">>> Target has been hit! Breaking target");
        //aimtrainerService.breakTarget();
        logger.info("" + aimtrainerService);

        Thread.sleep(2000);

        //Add score of Session
        logger.info(">>> Adding Score of Session to Highscore-list");
        //aimtrainerService.addSessionScore();
        logger.info("" + aimtrainerService);

        Thread.sleep(2000);

        //Show Highscore-list
        logger.info(">>> Displaying Highscore-list");
        //aimtrainerService.showHighSoreList();
        logger.info("" + aimtrainerService);

    }
}
