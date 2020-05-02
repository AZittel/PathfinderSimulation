package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;

/**
 * Admin interface to the OurSnakeService to add / remove a Player to / from the service.
 *
 * @author Sören Greiner, Karen Hofele
 */
public interface AdminSnakePlayerService {

  /**
   * Adds a new player to the game.
   *
   * @param descriptor of the new player.
   * @throws IllegalParameterException if the descriptor is a null reference or incomplete.
   */
  void addSnakePlayer(SnakePlayerDescriptor descriptor) throws IllegalParameterException;

  /**
   * Removes a player from the game.
   *
   * @param snakePlayerId id of the player that should be removed.
   * @throws IllegalParameterException if the nickname of the player does not exist.
   */
  void removeSnakePlayer(int snakePlayerId) throws IllegalParameterException;
}