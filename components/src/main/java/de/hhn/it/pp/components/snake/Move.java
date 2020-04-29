package de.hhn.it.pp.components.snake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class Move {
  private static final Logger logger =
            LoggerFactory.getLogger(Move.class);

  private Direction direction;

  /**
   * Constructor for the Move direction of the snake.
   *
   * @param direction direction in there the snake moves
   */
  public Move(Direction direction) {
    this.direction = direction;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
