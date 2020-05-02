package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.helper.CheckingHelper;
import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements all methods of SnakeService and AdminSnakeService.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class OurSnakePlayerService implements SnakePlayerService, AdminSnakePlayerService {
  private static final Logger logger =
            LoggerFactory.getLogger(OurSnakePlayerService.class);

  private Map<Integer, Snake> players;

  public OurSnakePlayerService() {
    players = new HashMap<>();
  }

  /** Current dircetion of the snake. */
  private Direction currentDirection;

  /**
   * Returns the player from the HashMap with the chosen player id.
   *
   * @param id id of the chosen player
   * @return returns the chosen player
   * @throws IllegalParameterException if the chosen player id is not used
   */
  private Snake getPlayerById(int id)throws IllegalParameterException {
    logger.info("getPlayerByNickname: id = {}", id);
    if (!players.containsKey(id)) {
      throw new IllegalParameterException("Player with id " + id + " does not exist.");
    }
    return players.get(id);
  }

  /**
   * Returns a list of registered players from snake.
   *
   * @return List of registered players.
   */
  @Override
  public List<SnakePlayerDescriptor> getSnakePlayers() {
    logger.info("getSnakePlayers: no params");
    List<SnakePlayerDescriptor> results = new ArrayList<>();
    for (Snake player : players.values()) {
      results.add(player.getDescriptor());
    }
    return results;
  }

  /**
   * Returns the description of the player with the chosen player name.
   *
   * @param id id of the player.
   * @return description of the players highscores and games
   * @throws IllegalParameterException if the player does not exist
   */
  @Override
  public SnakePlayerDescriptor getSnakePlayer(int id) throws IllegalParameterException {
    logger.info("getSnakePlayer: id = {}", id);
    Snake player = getPlayerById(id);
    return player.getDescriptor();
  }

  /**
   * Adds a listener to get updates on the state of the player.
   *
   * @param id id of the player
   * @param listener object implementing the listener interface
   * @throws IllegalParameterException if either the nickname does not exist or the listener is a
   *     null reference.
   */
  @Override
    public void addCallback(int id, SnakePlayerListener listener) throws IllegalParameterException {
    logger.info("addCallback: id = {}, listener = {}", id, listener);
    Snake player = getPlayerById(id);
    player.addCallback(listener);
  }

  /**
   * Removes a listener.
   *
   * @param id id of the player
   * @param listener listener to be removed
   */
  @Override
  public void removeCallback(int id, SnakePlayerListener listener)
          throws IllegalParameterException {
    logger.info("removeCallback: id = {}, listener = {}");
    Snake player = getPlayerById(id);
    player.removeCallback(listener);
  }

  /**
   * Starts the game snake for the player.
   *
   * @param id id of the active player
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  @Override
  public void startGame(int id) throws IllegalParameterException {
    logger.info("startGame: id = {}", id);
    Snake player = getPlayerById(id);
    player.startGame();
  }

  /**
   * Switches the Current Level.
   *
   * @param id id of the player which level get switched
   * @param highscore highscore that must be achieved to start the next level
   * @throws IllegalParameterException if the highscore or level is invalid.
   */
  @Override
  public void switchLevel(int id, int highscore) throws IllegalParameterException {
    logger.info("switchLevel: id = {}", id);
    Snake player = getPlayerById(id);
    player.switchLevel();
  }

  /**
   * Ends the game of the current player when he Collided/Solved the last Level or Closed the Game.
   *
   * @param id id of the player
   * @throws IllegalParameterException
   */
  @Override
  public void endGame(int id) throws IllegalParameterException {
    logger.info("endGame: id = {}", id);
    Snake player = getPlayerById(id);
    player.endGame();

  }

  @Override
  public void moveSnake(final int id, final Move direction) throws IllegalParameterException {
    logger.info("usedKey: id = {}, direction = {}", id, direction);
    Snake player = getPlayerById(id);
    if (direction == null) {
      throw new IllegalParameterException("Direction is a null reference.");
    }
    player.move(direction);
  }

  // Methods for the AdminSnakePlayerService

  /**
   * Adds a new player to the game.
   *
   * @param descriptor of the new player.
   * @throws IllegalParameterException if the descriptor is a null reference or incomplete.
   */
  @Override
  public void addSnakePlayer(SnakePlayerDescriptor descriptor) throws IllegalParameterException {
    logger.info("addSnakePlayer: descriptor = {}", descriptor);
    CheckingHelper.assertThatIsNotNull(descriptor, "descriptor");
    CheckingHelper.assertThatIsReadableString(descriptor.getPlayer(), "nickname");

    Snake player = new OurSnake(descriptor);
    players.put(player.getDescriptor().getId(), player);
  }

  /**
   * Removes a player from the game.
   *
   * @param id id of the player that should be removed.
   * @throws IllegalParameterException if the nickname of the player does not exist.
   */
  @Override
  public void removeSnakePlayer(int id) throws IllegalParameterException {
    logger.info("removeSnakePlayer, id = {}", id);
    if (!players.containsKey(id)) {
      throw new IllegalParameterException("player with nickname " + id + " not regestered.");
    }
    players.remove(id);
  }
}
