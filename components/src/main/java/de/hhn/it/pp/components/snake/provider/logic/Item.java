package de.hhn.it.pp.components.snake.provider.logic;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.OurSnakeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Creates items that can be collected by the snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class Item {

  /** OurSnakeItem's Logger. */
  private static final Logger logger = LoggerFactory.getLogger(Item.class);

  /** Item's value.*/
  private int value;

  /** Item's x-coordinate. */
  private int xPosition;

  /** Item's y-coordinate. */
  private int yPosition;

  /**
   * Constructor for items.
   *
   * @param value Item's value
   */
  public Item(int value) {
    logger.info("Constructor: created item with value = {}", value);
    this.value = value;
    // get random position for item
    this.xPosition = ThreadLocalRandom.current().nextInt(0, 15);
    this.yPosition = ThreadLocalRandom.current().nextInt(0, 15);
  }

  /**
   * Resets item when collected
   */
  public void reset() {
    this.xPosition = ThreadLocalRandom.current().nextInt(0, 15);
    this.yPosition = ThreadLocalRandom.current().nextInt(0, 15);
  }

  /**
   * Getter for the item's value.
   *
   * @return item's value
   */
  public int getValue() {
    logger.info("item's value = {}", value);
    return value;
  }

  /**
   * Getter for item's xPosition.
   *
   * @return xPosition
   */
  public int getXPosition() {
    return xPosition;
  }

  /**
   * Getter for item's yPosition.
   *
   * @return yPosition
   */
  public int getYPosition() {
    return yPosition;
  }

  /**
   * Setter for xPosition.
   *
   * @param xPos new x-Coordinate
   */
  public void setXPosition(int xPos) {
    xPosition = xPos;
  }

  /**
   * Setter for yPosition.
   *
   * @param yPos new y-Coordinate
   */
  public void setYPosition(int yPos) {
    yPosition = yPos;
  }
}
