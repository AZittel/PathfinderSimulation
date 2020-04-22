package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.OurSnakeItem;
import de.hhn.it.pp.components.snake.provider.OurSnakeLevel;
import java.util.List;

/**
 * This SnakeService is an interface for a running instance of the game snake,
 * e. g. on a smartphone or on an PC.
 *
 * @author Karen Hofele, Sören Greiner
 */
public interface SnakeService {

  /**
   * Returns a list of registered players from snake.
   *
   * @return List of registered players.
   */
  List<SnakePlayerDescriptor> getPlayers();

  /**
   * Returns the description of the player with the chosen player name.
   *
   * @param nickName nickname of the player.
   * @return description of the players highscores and games
   * @throws IllegalParameterException if the player does not exist
   */
  SnakePlayerDescriptor getPlayer(String nickName) throws IllegalParameterException;

  /**
   * Adds a listener to get updates on the progress of the player.
   *
   * @param nickName nickName of the player
   * @param listener object implementing the listener interface
   * @throws IllegalParameterException if either the nickName does not exist or the listener is a
   *     null reference.
   */
  void addCallback(String nickName, SnakePlayerDescriptor listener) throws IllegalParameterException;

  /**
   * Removes a listener.
   *
   * @param nickName nickName of the player
   * @param listener listener to be removed
   */
  void removeCallback(String nickName, SnakePlayerDescriptor listener) throws IllegalParameterException;

  /**
   * Starts the game of Snake.
   *
   * @param nickName nickName of the active player
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  void startGame(String nickName) throws IllegalParameterException;

  /**
   * Determine the level order in which the player starts.
   *
   * @param level level where the player plays
   */
  void runLevel(OurSnakeLevel level, int highscore) throws IllegalParameterException;

  /**
   * Closes the game.
   *
   * @return true if the game was exited
   */
  boolean exitGame();

  /**
   * Moves in chosen direction.
   *
   * @throws IllegalParameterException if the given key is invalid
   */
  void moveSnake(Directions key) throws IllegalParameterException;

  /**
   * Collects items.
   *
   * @param snakeFood food that is collected by the snake.
   */
  int collect(OurSnakeItem snakeFood);

  /**
   * Getter for the current direction of the snake.
   *
   * @return current direction
   */
  Directions getCurrentDirection();
}