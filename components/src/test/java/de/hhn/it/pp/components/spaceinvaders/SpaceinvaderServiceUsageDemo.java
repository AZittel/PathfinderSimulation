package de.hhn.it.pp.components.spaceinvaders;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvadersService;

public class SpaceinvaderServiceUsageDemo {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SpaceinvaderServiceUsageDemo.class);



   
    public void main(String[] args) throws InterruptedException, IllegalParameterException {
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
        int yPosinvader =100;
        int xPosinvader =150;
        spaceInvadersService.createEnemies(speed,xPosinvader,yPosinvader);
        logger.info("" + spaceInvadersService);

        Thread.sleep(1000);

        logger.info("restart the game");
        spaceInvadersService.restart();
        logger.info(""+ spaceInvadersService);

        Thread.sleep(1000);
    }

       }

