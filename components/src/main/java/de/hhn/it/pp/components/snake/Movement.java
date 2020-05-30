package de.hhn.it.pp.components.snake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for snake's movement
 */
public class Movement {

  /** Snake's Logger */
  private static final Logger logger = LoggerFactory.getLogger(Movement.class);

  /** current direction of the snake */
  private Direction currentDirection;

  /**
   * Constructor for the Move direction of the snake.
   *
   * @param currentDirection direction in there the snake moves
   */
  public Movement(Direction currentDirection) {
    logger.info("Constructor - {}", currentDirection);
    this.currentDirection = currentDirection;
  }

  /**
   * Getter for current direction
   *
   * @return current direction of the snake
   */
  public Direction getCurrentDirection() {
    logger.info("getter for currentDirection: {}", currentDirection);
    return currentDirection;
  }

  /**
   * Setter for current direction
   *
   * @param direction new current direction of the snake
   */
  public void setCurrentDirection(Direction direction) {
    logger.info("setter for current direction: {}", direction);
    currentDirection = direction;
  }
}
