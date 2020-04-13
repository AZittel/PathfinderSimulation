package de.hhn.it.pp.components.snake.simulation;


/**
 * Provides the functionality to interact with the game Snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public interface SnakeService {

  /**
  * Creates the mainmenu from the game.
  */
  void createMainMenu();

  /**
   * Creates a new window where the game is running.
   */
  void startGame();

  /**
   * Closes the game.
   */
  void exitGame();

  /**
   * Creates a new window where the highscore is listed.
   */
  void showHighscore();

  /**
   * Moves in chosen direction.
   * (1 = up) (2 = left) (3 = right) (4 = down).
   *
   * @param direction attribute for the chosen direction.
   * @throws IllegalArgumentException if the given number is invalid (>4 or <1).
   */
  void move(int direction) throws IllegalArgumentException;

  /**
   * Snake collides with an obstacle and dies.
   */
  void collide();

  /**
   * Collects items.
   */
  void collect();

  /**
   * Spawns the item.
   *
   * @param xPos x-coordinate
   * @param yPos y-coordinate
   */
  void spawn(int xPos, int yPos);
}
