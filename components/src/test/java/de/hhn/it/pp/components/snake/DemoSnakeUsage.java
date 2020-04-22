package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.OurSnakeItem;
import de.hhn.it.pp.components.snake.provider.OurSnakeLevel;
import de.hhn.it.pp.components.snake.provider.OurSnakeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Creates a non exectubale demo version of Snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class DemoSnakeUsage {

  private static final Logger logger =
          LoggerFactory.getLogger(DemoSnakeUsage.class);


  /**
   * Creates a demo game.
   */
  public static void main(String[] args) throws IllegalParameterException {

    // Create the service
    logger.info(">>> create service");
    SnakeService service = new OurSnakeService();
    logger.info("{}", service);

    // Starts the game, creates the map, spawns snake
    logger.info(">>> start game");
    service.startGame("horst64");
    logger.info("{}", service);

    OurSnakeLevel levelOne = new OurSnakeLevel(1, 0);

    // Runs the first level
    logger.info(">>> starts level 1");
    service.runLevel(levelOne, levelOne.getNeededHighscore());
    logger.info("{}", service);

    // Returns list of all registered players
    logger.info(">>> returns the list of all registered players");
    service.getPlayers();
    logger.info("{}", service);

    SnakePlayerDescriptor player1 = new SnakePlayerDescriptor("horst64");

    // Returns all information of a player
    logger.info(">>> returns all information about horst64");
    service.getPlayer(player1);
    logger.info("{}", service);

    SnakePlayerDescriptor snakePlayerDiscriptor = new SnakePlayerDescriptor("horst64");

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
    service.moveSnake(Directions.UP);
    logger.info("{}", service);

    // Snake moves left
    logger.info(">>> snake moves left");
    service.moveSnake(Directions.LEFT);
    logger.info("{}", service);

    OurSnakeItem snakeFood = new OurSnakeItem(2);

    // Snake collects item
    logger.info(">>> snake collects item");
    service.collect(snakeFood);
    logger.info("{}", service);

    // Snake moves right
    logger.info(">>> snake moves right");
    service.moveSnake(Directions.RIGHT);
    logger.info("{}", service);

    // Snake moves down
    logger.info(">>> snake moves down");
    service.moveSnake(Directions.DOWN);
    logger.info("{}", service);

    // Exits game
    logger.info(">>> exits the game");
    service.exitGame();
    logger.info("{}", service);
  }
}
