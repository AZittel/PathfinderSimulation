package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;

/**
 * This SnakePlayerService is an interface for a running instance of the game snake,
 * e. g. on a smartphone or on a PC.
 *
 * @author Karen Hofele, Sören Greiner
 */
public interface SnakeService {

  /**
   * Adds a listener to get updates on the state of the player.
   *
   * @param id id of the player
   * @param listener object implementing the listener interface
   * @throws IllegalParameterException if either the nickname does not exist or the listener is a
   *     null reference.
   *
  void addCallback(int id, SnakeListener listener) throws IllegalParameterException;

  /**
   * Removes a listener.
   *
   * @param id id of the player
   * @param listener listener to be removed
   *
  void removeCallback(int id, SnakeListener listener) throws IllegalParameterException;
*/
  /**
   * Starts the game snake for the player.
   *
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  void startGame() throws IllegalParameterException;
}
