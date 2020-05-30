package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.snake.Movement;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// todo javadoc
//todo logger
public class Snake {

  /** Snake's Logger */
  private static final Logger logger =
            LoggerFactory.getLogger(Snake.class);

  /** Counter for profile id's */
  private static int idCounter;

  /** variable for player's profile */
  private SnakePlayerProfile profile;

  /**
   * Constructor to create a OurSnake based on the information in the given
   * SnakePlayerProfile.
   *
   * @param profile profile that is chosen to play the game.
   */
  public Snake(SnakePlayerProfile profile) {
    logger.info("Constructor - {}", profile);
    this.profile = profile;
  }

  public static int getIdCounter() {
    logger.info("getter for id counter");
    return idCounter;
  }

  public static void setIdCounter(final int idCounter) {
    logger.info("setter for id counter - {}", idCounter);
    Snake.idCounter = idCounter;
  }

  public SnakePlayerProfile getProfile() {
    logger.info("Getter for profile: {}", profile);
    return profile;
  }

  public void endGame(){
    //logger.info();
  }

  // todo implementieren oder weglassen?
  public void move(Movement direction){
  }


  public void startGame(){

  }



public void switchLevel(){}
}

