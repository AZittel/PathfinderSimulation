package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// todo javadoc
//todo logger
public class SnakeGame {

  /** Snake's Logger. */
  private static final Logger logger =
          LoggerFactory.getLogger(SnakeGame.class);

  /** Counter for profile id's. */
  private static int idCounter;

  /** variable for player's profile. */
  private PlayerProfile profile;

  /**
   * Constructor to create a OurSnake based on the information in the given
   * SnakePlayerProfile.
   *
   * @param profile profile that is chosen to play the game.
   */
  public SnakeGame(PlayerProfile profile) {
    logger.info("Constructor - {}", profile);
    this.profile = profile;
  }

  public static int getIdCounter() {
    logger.info("getter for id counter");
    return idCounter;
  }

  public static void setIdCounter(final int idCounter) {
    logger.info("setter for id counter - {}", idCounter);
    SnakeGame.idCounter = idCounter;
  }

  public PlayerProfile getProfile() {
    logger.info("Getter for profile: {}", profile);
    return profile;
  }

  public void endGame(){
    //logger.info();
  }

  // todo implementieren oder weglassen?
  public void move(Direction direction){
  }


  public void startGame(){

  }



  public void switchLevel(){}
}
