package de.hhn.it.pp.components.spaceinvaders;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvadersService;

public class SpaceinvaderServiceUsageDemo {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SpaceinvaderServiceUsageDemo.class);



    public static void main(String[] args) throws InterruptedException {
        logger.info("create SpaceInvaderService");
       SpaceinvaderService spaceinvaderService = new SpaceInvaders ();
        logger.info("" + spaceinvaderService);

        Thread.sleep(3000);

        logger.info("create Field");
        int width =200;
        int height =100;
        spaceinvaderService.createField(width, height);
        logger.info("" + spaceinvaderService);

        Thread.sleep(1000);

        logger.info("create Player 1");
        int numlives=3;
        int yPos =100;
        int xPos =50;
        spaceinvaderService.createPlayer(numlives,xPos,yPos);
        logger.info("" + spaceinvaderService);

        Thread.sleep(1000);

        logger.info("create the Invaders");
        int speed=3;
        int yPos =100;
        int xPos =150;
        spaceinvaderService.createPlayer(speed,xPos,yPos);
        logger.info("" + spaceinvaderService);

        Thread.sleep(1000);

        logger.info("restart the game");
        spaceinvaderService.restart();
        logger.info(""+ spaceinvaderService);

        Thread.sleep(1000);
    }

       }

