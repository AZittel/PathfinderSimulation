package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.Item;
import de.hhn.it.pp.components.snake.provider.Level;
import de.hhn.it.pp.components.snake.provider.Snake;
import java.awt.event.KeyEvent;



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
  public static void main(String[] args) throws IllegalParameterException {

    // Create the service
    logger.info(">>> create service");
    SnakeService service = new Snake();
    logger.info("{}", service);

    // Starts the game, creates the map, spawns snake
    logger.info(">>> start game");
    service.startGame("horst64");
    logger.info("{}", service);

    Level levelOne = new Level(1, 0);

    // Runs the first level
    logger.info(">>> starts level 1");
    service.runLevel(levelOne, levelOne.getNeededHighscore());
    logger.info("{}", service);

    // Returns list of all registered players
    logger.info(">>> returns the list of all registered players");
    service.getPlayers();
    logger.info("{}", service);

    // Returns all information of a player
    logger.info(">>> returns all information about horst64");
    service.getPlayer("horst64");
    logger.info("{}", service);

    SnakePlayerDiscriptor snakePlayerDiscriptor = new SnakePlayerDiscriptor("horst64");

    // Adds a listener to a player to get updates on the progress
    logger.info(">>> adds listener to horst64");
    service.addCallback("horst64", snakePlayerDiscriptor);
    logger.info("{}", service);

    // Removes the listener from player
    logger.info(">>> removes listener from horst64");
    service.removeCallback("horst64", snakePlayerDiscriptor);
    logger.info("{}", service);

    // Snake moves up
    logger.info(">>> snake moves up");
    //service.moveSnake();
    logger.info("{}", service);

    // Snake moves left
    logger.info(">>> snake moves left");
    //service.moveSnake();
    logger.info("{}", service);

    Item snakeFood = new Item(2);

    // Snake collects item
    logger.info(">>> snake collects item");
    service.collect(snakeFood);
    logger.info("{}", service);

    // Snake moves right
    logger.info(">>> snake moves right");
    //service.moveSnake();
    logger.info("{}", service);

    // Snake moves down
    logger.info(">>> snake moves down");
    //service.moveSnake();
    logger.info("{}", service);

    // Snake collides and dies
    logger.info(">>> snake collides with obstacle and dies");
    service.collide();
    logger.info("{}", service);

    // Exits game
    logger.info(">>> exits the game");
    service.exitGame();
    logger.info("{}", service);
  }

}
