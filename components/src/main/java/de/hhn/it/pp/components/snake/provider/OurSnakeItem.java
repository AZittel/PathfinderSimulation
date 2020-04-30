package de.hhn.it.pp.components.snake.provider;

/**
 * Creates items that can be collected by the snake.
 *
 * @author Karen Hofele, Sören Greiner
 */

public class OurSnakeItem {

  /** Item's value.*/
  private int value;

  /** Item's x-coordinate */
  private int xPosition;

  /** Item's y-coordinate */
  private int yPosition;

  /**
   * Constructor for items.
   *
   * @param value Item's value
   */
  public OurSnakeItem(int value) {
    this.value = value;
  }

  /**
   * Getter for the item's value.
   *
   * @return item's value
   */
  public int getValue() {
    return value;
  }

  /**
   * Spawns the item.
   *
   * @param xPos x-coordinate of the spawnplace
   * @param yPos y-coordinate of the spawnplace
   */
  public void spawn(int xPos, int yPos){
    //todo implement method
    xPosition = xPos;
    yPosition = yPos;
  }
}
