package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.Item;
import de.hhn.it.pp.components.snake.provider.Level;
import java.awt.event.KeyEvent;
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
  List<SnakePlayerDiscriptor> getPlayers();

  /**
   * Returns the description of the player with the chosen player name.
   *
   * @param nickName nickname of the player.
   * @return description of the players highscores and games
   * @throws IllegalParameterException if the player does not exist
   */
  SnakePlayerDiscriptor getPlayer(String nickName) throws IllegalParameterException;

  /**
   * Adds a listener to get updates on the progress of the player.
   *
   * @param nick     nick of the player
   * @param listener object implementing the listener interface
   * @throws IllegalParameterException if either the nick does not exist or the listener is a
   *     null reference.
   */
  void addCallback(String nick, SnakePlayerDiscriptor listener) throws IllegalParameterException;

  /**
   * Removes a listener.
   *
   * @param nick     nick of the player
   * @param listener listener to be removed
   */
  void removeCallback(String nick, SnakePlayerDiscriptor listener) throws IllegalParameterException;

  /**
   * Starts the game of Snake.
   *
   * @param nickName nick of the active player
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  void startGame(String nickName) throws IllegalParameterException;

  /**
   * Determine the level order in which the player starts.
   *
   * @param level level where the player plays
   */
  void runLevel(Level level, int highscore) throws IllegalParameterException;


  /**
   * Closes the game.
   */
  void exitGame();

  /**
   * Moves in chosen direction.
   *
   * @throws IllegalParameterException if the given key is invalid
   */
  void moveSnake(KeyEvent key) throws IllegalParameterException;

  /**
   * Snake collides with an obstacle and dies.
   */
  void collide();

  /**
   * Collects items.
   *
   * @param snakeFood food that is collected by the snake.
   */
  int collect(Item snakeFood);
}