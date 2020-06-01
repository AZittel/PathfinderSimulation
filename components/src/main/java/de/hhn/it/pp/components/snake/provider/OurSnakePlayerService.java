package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.helper.CheckingHelper;
import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
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

  /** OurSnakePlayerService's Logger. */
  private static final Logger logger = LoggerFactory.getLogger(OurSnakePlayerService.class);

  /** Map for all player profiles. */
  private Map<Integer, Snake> allPlayersProfiles;

  /** window's height. */
  private static int windowHeight;

  /** window's width. */
  private static int windowWidth;

  /** Current dircetion of the snake. */
  private Direction currentDirection;

  public OurSnakePlayerService() {
    logger.info("Constructor");
    allPlayersProfiles = new HashMap<>();
  }

  /**
   * Returns the player from the HashMap with the chosen player id.
   *
   * @param id id of the chosen player
   * @return returns the chosen player
   * @throws IllegalParameterException if the chosen player id is not used
   */
  private Snake getPlayerById(int id)throws IllegalParameterException {
    logger.info("getPlayerByNickname: id = {}", id);
    if (!allPlayersProfiles.containsKey(id)) {
      throw new IllegalParameterException("Player with id " + id + " does not exist.");
    }
    return allPlayersProfiles.get(id);
  }

  /**
   * Returns a list of registered players from snake.
   *
   * @return List of registered players.
   */
  @Override
  public List<SnakePlayerProfile> getAllSnakePlayerProfiles() {
    logger.info("getSnakePlayers: no params");
    List<SnakePlayerProfile> results = new ArrayList<>();
    for (Snake player : allPlayersProfiles.values()) {
      results.add(player.getProfile());
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
  public SnakePlayerProfile getSnakePlayerProfile(int id) throws IllegalParameterException {
    logger.info("getSnakePlayer: id = {}", id);
    Snake player = getPlayerById(id);
    return player.getProfile();
  }

  /**
   * Starts the game snake for the player.
   *
   * @param id id of the active player
   * @param winHeight windowheight
   * @param winWidth windowwidth
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  @Override
  public void startGame(int id, int winHeight, int winWidth) throws IllegalParameterException {
    logger.info("startGame: id = {}", id);
    Snake player = getPlayerById(id);
    windowHeight = winHeight;
    windowWidth = winWidth;
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
   * Ends the game of the current player when he Collided/Solved the last Level or
   * closed the Game.
   *
   * @param id id of the player
   * @throws IllegalParameterException
   */
  @Override
  public void endGame(int id) throws IllegalParameterException {
    logger.info("endGame: id = {}", id);
    Snake player = getPlayerById(id);
    player.endGame();
    //todo Exception werfen
  }

  @Override
  public void moveSnake(int id, Direction direction) throws IllegalParameterException {
    logger.info("usedKey: id = {}, direction = {}", id, direction);
    Snake player = getPlayerById(id);
    if (direction == null) {
      throw new IllegalParameterException("Direction is a null reference.");
    }
    player.move(direction);
  }

  // Methods for the AdminSnakePlayerService

  /**
   * Adds a new player profile to the game.
   *
   * @param profile of the new player.
   * @throws IllegalParameterException if the descriptor is a null reference or incomplete.
   */
  @Override
  public void addSnakePlayerProfile(SnakePlayerProfile profile) throws IllegalParameterException {
    logger.info("addSnakePlayer: descriptor = {}", profile);
    CheckingHelper.assertThatIsNotNull(profile, "descriptor");
    CheckingHelper.assertThatIsReadableString(profile.getPlayerNickname(), "nickname");

    Snake player = new Snake(profile);
    allPlayersProfiles.put(player.getProfile().getPlayerId(), player);
  }

  /**
   * Removes a player from the game.
   *
   * @param id id of the player that should be removed.
   * @throws IllegalParameterException if the nickname of the player does not exist.
   */
  @Override
  public void removeSnakePlayerProfile(int id) throws IllegalParameterException {
    logger.info("removeSnakePlayer, id = {}", id);
    if (!allPlayersProfiles.containsKey(id)) {
      throw new IllegalParameterException("player with nickname " + id + " not regestered.");
    }
    allPlayersProfiles.remove(id);
  }

  /**
   * Getter for windowheight.
   *
   * @return windowheight
   */
  public static int getWindowHeight() {
    logger.info("window height: {}", windowHeight);
    return windowHeight;
  }

  /**
   * Getter for windowwidth.
   *
   * @return windowidth
   */
  public static int getWindowWidth() {
    logger.info("window width: {}", windowWidth);
    return windowWidth;
  }
}
