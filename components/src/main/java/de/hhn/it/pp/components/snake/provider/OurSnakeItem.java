package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates items that can be collected by the snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class OurSnakeItem {

  /** OurSnakeItem's Logger. */
  private static final Logger logger = LoggerFactory.getLogger(OurSnakeItem.class);

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
  public OurSnakeItem(int value) {
    logger.info("Constructor: created item with value = {}", value);
    this.value = value;
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
   * Spawns an item.
   *
   * @param xPos x-coordinate of the spawnplace
   * @param yPos y-coordinate of the spawnplace
   * @throws IllegalParameterException if the coordinates are outside the playfield
   */
  public void spawn(int xPos, int yPos) throws IllegalParameterException {
    logger.info("spawned item at pos={} {}", xPos, yPos);
    if (xPos > OurSnakePlayerService.getWindowWidth()
            || yPos > OurSnakePlayerService.getWindowHeight()) {
      throw new IllegalParameterException("Coordinates are outside the playfield");
    } else if (xPos < 0 || yPos < 0) {
      throw new IllegalParameterException("Coordinates are too small");
    } else {
      xPosition = xPos;
      yPosition = yPos;
    }
  }
}
