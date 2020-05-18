/*
 @Author Darko Miklic, Marc Nauendorf
  * @Version 18.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.provider.GameOverException;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;

import java.util.Collections;

public class SpaceInvadersUsageDemo {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SpaceInvadersUsageDemo.class);

    public static void main(String[] args) throws InterruptedException, IllegalParameterException, GameOverException, IllegalArgumentException {
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

        //Moving the player
        logger.info("moving");
        spaceInvadersService.movement(1, 2);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Asks for the position of the player
        logger.info("get position player");
        spaceInvadersService.getPositionPlayer(new int[2][3]);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Shoots projectiles at the enemies
        logger.info("shooting");
        spaceInvadersService.shooting(true);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Ask for the position of the enemies
        logger.info("get position enemies");
        spaceInvadersService.getPositionEnemies(new int[5][6], 3);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);


        //Adds the new highscore to the highscore list
        logger.info("add highscore");
        spaceInvadersService.addHighScore(Collections.singletonList("Player 1 1000 Points"));
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Displays the highscore
        logger.info("get highscore list");
        spaceInvadersService.getHighscoreList(Collections.singletonList("Player 1 1000 Points"));
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        //Resets the game
        logger.info("restart the game");
        spaceInvadersService.restart();
        logger.info(""+ spaceInvadersService);

        Thread.sleep(1000);
    }

}