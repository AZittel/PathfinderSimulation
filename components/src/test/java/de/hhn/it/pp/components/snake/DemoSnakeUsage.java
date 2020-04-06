package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.snake.simulation.Snake;
import de.hhn.it.pp.components.snake.simulation.SnakeService;

/**
 * Creates a non exectubale demo version of Snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class DemoSnakeUsage {

  private static final org.slf4j.Logger logger =
          org.slf4j.LoggerFactory.getLogger(DemoSnakeUsage.class);


  /**
   * Creates a demo game.
   */
  public static void main(String[] args){

    // Create the service
    logger.info(">>> create service");
    SnakeService service = new Snake();
    logger.info("" + service);

    // Create the main menu
    logger.info(">>> create the main menu");
    service.createMainMenu();
    logger.info("" + service);

     // Starts the game, creates the map, spawns snake
     logger.info(">>> start game");
     service.startGame();
     logger.info("" + service);

     // Spawns item
     logger.info(">>> spawns item");
     service.spawn(23,49);
     logger.info("" + service);

     // Snake moves up
     logger.info(">>> snake moves up");
     service.move(1);
     logger.info("" + service);

     // Snake moves left
     logger.info(">>> snake moves left");
     service.move(2);
     logger.info("" + service);

     // Snake collects item
     logger.info(">>> snake collects item");
     service.collect();
     logger.info("" + service);

     // Snake moves right
     logger.info(">>> snake moves right");
     service.move(3);
     logger.info("" + service);

     // Snake moves down
     logger.info(">>> snake moves down");
     service.move(4);
     logger.info("" + service);

     // Snake collides and dies
     logger.info(">>> snake collides with obstacle and dies");
     service.collide();
     logger.info("" + service);

     // Shows highscore
     logger.info(">>> shows highscore");
     service.showHighscore();
     logger.info("" + service);

     // Exits game
     logger.info(">>> exits the game");
     service.exitGame();
     logger.info("" + service);
 }

}
