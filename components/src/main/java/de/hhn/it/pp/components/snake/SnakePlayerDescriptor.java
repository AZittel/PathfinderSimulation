package de.hhn.it.pp.components.snake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description of a player.
 *
 * @author Sören Greiner, Karen Hofele
 */
public class SnakePlayerDescriptor {
  private static final Logger logger =
            LoggerFactory.getLogger(SnakePlayerDescriptor.class);

  private String nickName;
  private int highscore;
  private int level;

  /**
   * Constructor for the current players instance of the game.
   *
   * @param nickName nickname of the current player.
   */
  public SnakePlayerDescriptor(final String nickName) {
    this.nickName = nickName;
    highscore = 0;
    level = 1;
  }

  /**
   * Getter for the player's nickname.
   *
   * @return nickName of the player
   */
  public String getNickName() {
    return nickName;
  }

  /**
   * Setter for the player's nickname.
   *
   * @param nickName new nickname
   */
  public void setNickname(String nickName) {
    this.nickName = nickName;
  }

  /**
   * Getter for the player's highscore.
   *
   * @return highscore
   */
  public int getHighscore() {
    return highscore;
  }

  /**
   * Setter for the new highscore.
   *
   * @param highscore new highscore
   */
  public void setHighscore(final int highscore) {
    this.highscore = highscore;
  }

  /**
   * Getter for current level.
   *
   * @return the current level
   */
  public int getLevel() {
    return level;
  }

  /**
   * Setter for the new current level.
   *
   * @param level new current level
   */
  public void setLevel(final int level) {
    this.level = level;
  }
}
