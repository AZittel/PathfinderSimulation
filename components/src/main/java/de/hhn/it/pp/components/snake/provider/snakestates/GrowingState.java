package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class GrowingState extends ControlState {
  private static final Logger logger =
            LoggerFactory.getLogger(GrowingState.class);

  /**
   * Standard constructor for States.
   *
   * @param snake related maker
   */
  public GrowingState(final OurSnake snake) {
    super(snake);
    state = State.GROWING;
  }

  @Override
  public void onStartLevel() throws IllegalStateException {
  }

  @Override
  public void onEndLevel() throws IllegalStateException {
  }

  @Override
  public void onCreateEnemy() throws IllegalStateException {
  }

  @Override
  public void onCreateItem() throws IllegalStateException {
  }

  @Override
  public void onCreateLevel() throws IllegalStateException {
  }

  @Override
  public void onMove() throws IllegalStateException {
  }
}
