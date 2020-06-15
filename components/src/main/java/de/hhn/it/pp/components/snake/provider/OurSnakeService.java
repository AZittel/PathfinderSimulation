package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements all methods of SnakeService and AdminSnakeService.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class OurSnakeService implements SnakeService {

  /** OurSnakePlayerService's Logger. */
  private static final Logger logger = LoggerFactory.getLogger(OurSnakeService.class);

  public OurSnakeService() {
    logger.info("Constructor");
  }

  /**
   * Starts the game snake for the player.
   *
   * @throws IllegalParameterException if the nickname is too long or already chosen.
   */
  @Override
  public void startGame() {
  }
}
