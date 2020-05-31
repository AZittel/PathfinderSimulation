package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for player profiles.
 *
 * @author Sören Greiner, Karen Hofele
 */
public class SnakePlayerProfile {

  /** SnakePlayerProfile's logger. */
  private static Logger logger =
            LoggerFactory.getLogger(SnakePlayerProfile.class);

  /** player's nickname. */
  private String nickname;

  /** player's highscore. */
  private int playerHighscore;

  /** player's level. */
  private int currentLevel;

  /** player's id. */
  private static int playerId = 0;

  /** list for player id's. */
  private ArrayList<Integer> allIds = new ArrayList<>();

  /**
   * Constructor for the current players instance of the game.
   *
   * @param nickname nickname of the current player.
   */
  public SnakePlayerProfile(final String nickname) {
    logger.info("Constructor - {}", nickname);
    this.nickname = nickname;
    playerHighscore = 0;
    currentLevel = 1;
    playerId++;
    allIds.add(playerId);
  }

  /**
   * Getter for the player's nickname.
   *
   * @return nickname of the player
   */
  public String getPlayerNickname() {
    logger.info("get player's nickname: {}", nickname);
    return nickname;
  }

  /**
   * Setter for the player's nickname.
   *
   * @param nickname new nickname
   */
  public void setPlayerNickname(String nickname) {
    logger.info("set player's nickname: {}", nickname);
    this.nickname = nickname;
  }

  /**
   * Getter for the player's highscore.
   *
   * @return highscore
   */
  public int getPlayerHighscore() {
    logger.info("get player's highscore: {}", playerHighscore);
    return playerHighscore;
  }

  /**
   * Setter for the new highscore.
   *
   * @param playerHighscore new highscore
   */
  public void setPlayerHighscore(int playerHighscore) {
    logger.info("set player's highscore: {}", playerHighscore);
    this.playerHighscore = playerHighscore;
  }

  /**
   * Getter for current level.
   *
   * @return the current level
   */
  public int getCurrentLevel() {
    logger.info("get player's current level: {}", currentLevel);
    return currentLevel;
  }

  /**
   * Setter for the new current level.
   *
   * @param currentLevel new current level
   */
  public void setCurrentLevel(int currentLevel) {
    logger.info("set player's current level: {}", currentLevel);
    this.currentLevel = currentLevel;
  }

  /**
   * Getter for player's id.
   *
   * @return player's id
   */
  public int getPlayerId() {
    logger.info("get player's id: {}", playerId);
    return playerId;
  }

  /**
   * Setter for player's id.
   *
   * @param playerId player's id
   */
  public void setPlayerId(final int playerId) throws IllegalParameterException {
    logger.info("set player's id: {}", playerId);
    if (allIds.contains(playerId)) {
      throw new IllegalParameterException("playerId is already chosen, chose another one");
    } else {
      this.playerId = playerId;
    }
  }

  /**
   * to String method for a player profile and its properties.
   *
   * @return player profile and its properties as a string
   */
  @Override
  public String toString() {
    logger.info("profile as string");
    return "SnakePlayerProfile{"
            + "Player='" + nickname + '\''
            + ", highscore='" + playerHighscore + '\''
            + ", level=" + currentLevel
            + ", id=" + playerId
            + '}';
  }
}
