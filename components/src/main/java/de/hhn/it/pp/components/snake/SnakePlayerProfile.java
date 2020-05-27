package de.hhn.it.pp.components.snake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
// todo logger

/**
 * Description of a player's profile.
 *
 * @author Sören Greiner, Karen Hofele
 */
public class SnakePlayerProfile {
  private static final Logger logger =
            LoggerFactory.getLogger(SnakePlayerProfile.class);


  private String nickname;
  private int highscore;
  private int level;
  private int id;

  /**
   * Constructor for the current players instance of the game.
   *
   * @param nickname nickname of the current player.
   */

  public SnakePlayerProfile(final String nickname) {
    this.nickname = nickname;
    highscore = 0;
    level = 1;
    id = 0;
  }

  /**
   * Getter for the player's nickname.
   * @return nickname of the player
   */
  public String getPlayer() {
    return nickname;
  }

  /**
   * Setter for the player's nickname.
   * @param nickname new nickname
   */
  public void setPlayer(String nickname) {
    this.nickname = nickname;
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


  public int getId() {
    return id;
  }

  public void setId(final int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "SnakePlayerDescriptor{"
            + "Player='" + nickname + '\''
            + ", highscore='" + highscore + '\''
            + ", level=" + level
            + ", id=" + id
            + '}';
  }
}
