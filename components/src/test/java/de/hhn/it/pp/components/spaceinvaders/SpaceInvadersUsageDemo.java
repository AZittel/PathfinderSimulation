/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 18.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvadersService;

public class SpaceInvadersUsageDemo {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SpaceInvadersUsageDemo.class);

    public static void main(String[] args) throws InterruptedException, IllegalParameterException {
        //Create the service
        logger.info("create SpaceInvaderService");
        SpaceInvadersService spaceInvadersService = new SpaceInvaders();
        logger.info("" + spaceInvadersService);

        Thread.sleep(3000);

        //Create the field
        logger.info("create Field");
        spaceInvadersService.createField(200, 100);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Create the player
        logger.info("create Player");
        spaceInvadersService.createPlayer(100,50);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Create the "Invaders" (enemies)
        logger.info("create the Invaders");
        spaceInvadersService.createEnemies(3,150,100);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Displays the highscore
        logger.info("display the highscore");
        spaceInvadersService.showHighscore(1);
        logger.info("" + spaceInvadersService);

        //Moving the player
        logger.info("moving");
        spaceInvadersService.movement(1, 2, true);
        logger.info("" + spaceInvadersService);

        //Resets the game
        logger.info("restart the game");
        spaceInvadersService.restart();
        logger.info(""+ spaceInvadersService);

        Thread.sleep(1000);
    }

}