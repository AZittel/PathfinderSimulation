package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for Snake's Head.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class SnakeHead {

  /** Snakehead's logger. */
  private static final Logger logger = (Logger) LoggerFactory.getLogger(SnakeHead.class);

  /** Snakehead's direction at the beginning. */
  Direction headDirection = Direction.UP;

  /** Snakehead's x-Position. */
  private int headXPosition;

  /** Snakehead's y-Position. */
  private int headYPosition;

  /**
   * Constructor.
   *
   * @param x initial x-Coordinate
   * @param y initial y-Coordinate
   */
  public SnakeHead(int x, int y) {
    logger.info("Constructor with x-coordinate {} and y-coordinate {}", x, y);
    this.headXPosition = x;
    this.headYPosition = y;
  }

  /**
   * Getter for snakehead's direction.
   *
   * @return head's direction
   */
  public Direction getHeadDirection() {
    logger.info("get snakehead's direction");
    return headDirection;
  }

  /**
   * Setter for snakehead's direction.
   *
   * @param headDirection head's new direction
   */
  public void setHeadDirection(Direction headDirection) {
    logger.info("sets new direction for snake's head - {}", headDirection);
    this.headDirection = headDirection;
  }

  /**
   * Getter for Snakehead's x-Position.
   *
   * @return head's x-coordinate
   */
  public int getHeadXPosition() {
    logger.info("get snakehead's x-coordinate");
    return headXPosition;
  }

  /**
   * Setter for Snakehead's x-Position.
   *
   * @param headXPosition head's new x-coordinate
   */
  public void setHeadXPosition(int headXPosition) {
    logger.info("set snakehead's new x-coordinate {}", headXPosition);
    this.headXPosition = headXPosition;
  }

  /**
   * Getter for Snakehead's y-Position.
   *
   * @return head's y-coordinate
   */
  public int getHeadYPosition() {
    logger.info("get snakehead's y-coordinate");
    return headYPosition;
  }

  /**
   * Setter for Snakehead's y-Position.
   *
   * @param headYPosition new y-coordinate
   */
  public void setHeadYPosition(int headYPosition) {
    logger.info("set snakehead's y-coordinate {}", headYPosition);
    this.headYPosition = headYPosition;
  }
}
