package de.hhn.it.pp.components.snake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description of a player's profile.
 *
 * @author Sören Greiner, Karen Hofele
 */
public class SnakePlayerProfile {
  private static final Logger logger =
            LoggerFactory.getLogger(SnakePlayerProfile.class);

  private String playerProfile;
  private int highscore;
  private int level;
  private State state;
  private int instance;

  /**
   * Constructor for the current players instance of the game.
   *
   * @param nickname nickname of the current player.
   */
  public SnakePlayerProfile(final String nickname) {
    playerProfile = nickname;
    highscore = 0;
    level = 1;
    instance = 0;
  }

  /**
   * Getter for the player's nickname.
   * @return nickname of the player
   */
  public String getNickname() {
    return playerProfile;
  }

  /**
   * Setter for the player's nickname.
   * @param nickname new nickname
   */
  public void setNickname(String nickname) {
    playerProfile = nickname;
  }

  /**
   * Getter for the player's highscore.
   * @return highscore
   */
  public int getHighscore() {
    return highscore;
  }

  /**
   * Setter for the new highscore.
   * @param highscore new highscore
   */
  public void setHighscore(int highscore) {
    this.highscore = highscore;
  }

  /**
   * Getter for current level.
   * @return the current level
   */
  public int getLevel() {
    return level;
  }

  /**
   * Setter for the new current level.
   * @param level new current level
   */
  public void setLevel(int level) {
    this.level = level;
  }

  /**
   * Getter for the current state.
   * @return the current state
   */
  public State getState() {
    return state;
  }

  /**
   * Setter for the new current state.
   * @param state new current state
   */
  public void setState(State state) {
    this.state = state;
  }

  /**
   * Getter for the current instance.
   * @return the current instance
   */
  public int getInstance() {
    return instance;
  }

  /**
   * Setter for the new current instance.
   * @param instance new current instance
   */
  public void setInstance(int instance) {
    this.instance = instance;
  }
}
