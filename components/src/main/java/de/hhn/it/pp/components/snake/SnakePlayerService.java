package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import java.util.List;

/**
 * This SnakePlayerService is an interface for a running instance of the game snake,
 * e. g. on a smartphone or on a PC.
 *
 * @author Karen Hofele, Sören Greiner
 */
public interface SnakePlayerService {
  /**
   * Returns a list of registered players from snake.
   *
   * @return List of registered players.
   */
  List<SnakePlayerProfile> getAllSnakePlayerProfiles();

  /**
   * Returns the description of the player with the chosen player id.
   *
   * @param id id of the player.
   * @return description of the players highscores and games
   * @throws IllegalParameterException if the player does not exist
   */
  SnakePlayerProfile getSnakePlayerProfile(int id) throws IllegalParameterException;

  /**
   * Adds a listener to get updates on the state of the player.
   *
   * @param id id of the player
   * @param listener object implementing the listener interface
   * @throws IllegalParameterException if either the nickname does not exist or the listener is a
   *     null reference.
   */
  //void addCallback(int id, SnakePlayerListener listener) throws IllegalParameterException;

  /**
   * Removes a listener.
   *
   * @param id id of the player
   * @param listener listener to be removed
   */
  //void removeCallback(int id, SnakePlayerListener listener) throws IllegalParameterException;

  /**
   * Starts the game snake for the player.
   *
   * @param id id of the active player
   * @param winHeight windowheight
   * @param winWidth windowwidth
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  void startGame(int id, int winHeight, int winWidth) throws IllegalParameterException;

  /**
   * Switches the Current Level.
   *
   * @param id level that should be run
   * @param highscore highscore that must be achieved to start the next level
   * @throws IllegalParameterException if the highscore or level is invalid.
   */
  void switchLevel(int id, int highscore) throws IllegalParameterException;

  /**
   * Ends the game of Snake.
   *
   * @param id id of the player
   * @throws IllegalParameterException if the chosen nickname isn't playing
   */
  void endGame(int id) throws  IllegalParameterException;

  /**
   * Moves in chosen direction.
   *
   * @throws IllegalParameterException if the given key is invalid
   */
  void moveSnake(int id, Movement direction) throws IllegalParameterException;


}