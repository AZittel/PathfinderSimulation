package de.hhn.it.pp.components.snake;

/**
 * Description of a player.
 *
 * @author Sören Greiner, Karen Hofele
 */
public class SnakePlayerDescriptor {
  private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(SnakePlayerDescriptor.class);

  private String player;
  private int highscore;
  private int level;
  private State state;
  private int instance;

  /**
   * Constructor for the current players instance of the game.
   *
   * @param nickname nickname of the current player.
   */
  public SnakePlayerDescriptor(final String nickname) {
    this.player = nickname;
    highscore = 0;
    level = 1;
    instance = 0;
  }

  /**
   * Getter for the player's nickname.
   * @return nickname of the player
   */
  public String getNickname() {
    return player;
  }

  /**
   * Setter for the player's nickname.
   * @param nickname new nickname
   */
  public void setNickname(String nickname) {
    this.player = nickname;
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
