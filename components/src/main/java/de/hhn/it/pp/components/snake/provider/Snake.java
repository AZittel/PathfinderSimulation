package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.Movement;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// todo javadoc
//todo logger
public class Snake {
  private static final Logger logger =
            LoggerFactory.getLogger(Snake.class);
  private static int idCounter;
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
    profile.setId(idCounter++);
  }

  public static int getIdCounter() {
    logger.info("getter for id");
    return idCounter;
  }

  public static void setIdCounter(final int idCounter) {
    Snake.idCounter = idCounter;
  }

  public SnakePlayerProfile getProfile() {
    return profile;
  }

  public void endGame(){

  }

  // todo implementieren oder weglassen?
  public void move(Movement direction){
  }


  public void startGame(){

  }



public void switchLevel(){}
}

