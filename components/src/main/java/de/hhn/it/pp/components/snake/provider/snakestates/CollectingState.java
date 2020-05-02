package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class CollectingState extends ControlState {
  private static final Logger logger =
            LoggerFactory.getLogger(CollectingState.class);

  /**
   * Standard constructor for States.
   *
   * @param snake related maker
   */
  public CollectingState(final OurSnake snake) {
    super(snake);
    state = State.COLLECTING;
  }

  @Override
  public void onStartGame() throws IllegalStateException {

  }

  @Override
  public void onSwitchLevel() throws IllegalStateException {

  }

  @Override
  public void onEndGame() throws IllegalStateException {

  }

  @Override
  public void onMove() throws IllegalStateException {

  }


}
