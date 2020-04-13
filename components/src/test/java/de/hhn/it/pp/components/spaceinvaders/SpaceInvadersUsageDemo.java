/**
 @Author Darko Miklic, Marc Nauendorf
  * @Version 13.04.2020
 */

package de.hhn.it.pp.components.spaceinvaders;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvadersService;

public class SpaceInvadersUsageDemo {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SpaceInvadersUsageDemo.class);

    public static void main(String[] args) throws InterruptedException, IllegalParameterException {
        logger.info("create SpaceInvaderService");
        SpaceInvadersService spaceInvadersService = new SpaceInvaders ();
        logger.info("" + spaceInvadersService);

        Thread.sleep(3000);

        logger.info("create Field");
        int width =200;
        int height =100;
        spaceInvadersService.createField(width, height);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        logger.info("create Player 1");

        int yPos =100;
        int xPos =50;
        spaceInvadersService.createPlayer(xPos,yPos);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        logger.info("create the Invaders");
        int speed=3;
        int xPosition=150;
        int yPosition=100;

        spaceInvadersService.createEnemies(xPosition,yPosition,speed);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        logger.info("restart the game");
        spaceInvadersService.restart();
        logger.info(""+ spaceInvadersService);

        Thread.sleep(1000);
    }

}