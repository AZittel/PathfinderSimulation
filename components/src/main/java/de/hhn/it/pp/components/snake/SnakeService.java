package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.OurSnakeItem;
import de.hhn.it.pp.components.snake.provider.OurSnakeLevel;
import java.util.ArrayList;

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
  ArrayList<SnakePlayerProfile> getAllPlayerProfiles();

  /**
   * Returns the description of the player with the chosen player name.
   *
   * @param nickname nickname of the player.
   * @return description of the players highscores and games
   * @throws IllegalParameterException if the player does not exist
   */
  SnakePlayerProfile getPlayerProfile(String nickname) throws IllegalParameterException;

  /**
   * Adds a listener to get updates on the progress of the player.
   *
   * @param nickname nickname of the player
   * @param listener object implementing the listener interface
   * @throws IllegalParameterException if either the nickname does not exist or the listener is a
   *     null reference.
   */
  void addCallback(String nickname, SnakePlayerProfile listener)
          throws IllegalParameterException;

  /**
   * Removes a listener.
   *
   * @param nickname nickname of the player
   * @param listener listener to be removed
   */
  void removeCallback(String nickname, SnakePlayerProfile listener)
          throws IllegalParameterException;

  /**
   * Starts the game of Snake.
   *
   * @param nickname nickname of the active player
   * @param winWidth width of the window
   * @param winHeight height of the window
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  void startGame(String nickname, int winWidth, int winHeight) throws IllegalParameterException;

  /**
   * Runs the level.
   *
   * @param level level that should be runned
   * @param highscore highscore that must be achieved to start the next level
   * @throws IllegalParameterException if the highscore or level is invalid.
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
  void moveSnake(Direction key) throws IllegalParameterException;

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
  Direction getCurrentDirection();
}