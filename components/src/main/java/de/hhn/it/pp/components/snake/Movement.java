package de.hhn.it.pp.components.snake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
//todo logger
public class Movement {
  private static final Logger logger = LoggerFactory.getLogger(Movement.class);

  private Direction currentDirection;

  /**
   * Constructor for the Move direction of the snake.
   *
   * @param currentDirection direction in there the snake moves
   */
  public Movement(Direction currentDirection) {
    this.currentDirection = currentDirection;
  }

  public Direction getCurrentDirection() {
    return currentDirection;
  }

  public void setCurrentDirection(Direction direction) {
    currentDirection = direction;
  }
}
