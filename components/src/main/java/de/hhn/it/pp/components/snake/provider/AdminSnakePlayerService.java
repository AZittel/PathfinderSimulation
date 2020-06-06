package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.PlayerProfile;

/**
 * Admin interface to the OurSnakeService to add / remove a Player to / from the service.
 *
 * @author Sören Greiner, Karen Hofele
 */
public interface AdminSnakePlayerService {
  /**
   * Adds a new player profile to the game.
   *
   * @param profile of the new player.
   * @throws IllegalParameterException if the profile is a null reference or incomplete.
   */
  void addSnakePlayerProfile(PlayerProfile profile) throws IllegalParameterException;

  /**
   * Removes a player profile from the game.
   *
   * @param snakePlayerId id of the player profile that should be removed.
   * @throws IllegalParameterException if the nickname of the player does not exist.
   */
  void removeSnakePlayerProfile(int snakePlayerId) throws IllegalParameterException;
}
