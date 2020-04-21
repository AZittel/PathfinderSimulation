package de.hhn.it.pp.components.snake;

/**
 * Description of a player.
 *
 * @author Sören Greiner, Karen Hofele
 */
public class SnakePlayerDescriptor {
  private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SnakePlayerDescriptor.class);

  private String nickname;
  private int highscore;
  private int level;

  /**
   * Constructor for the current players instance of the game.
   *
   * @param nickname nickname of the current player.
   */
  public SnakePlayerDescriptor(final String nickname) {
    this.nickname = nickname;
    highscore = 0;
    level = 1;
  }

  /**
   * Getter for the player's nickname.
   * @return nickname of the player
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * Setter for the player's nickname.
   * @param nickname new nickname
   */
  public void setNickname(String nickname) {
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
  public void setHighscore(final int highscore) {
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
  public void setLevel(final int level) {
    this.level = level;
  }
}
