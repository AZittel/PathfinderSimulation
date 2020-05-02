package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class LevelReadyState extends ControlState {
  private static final Logger logger =
            LoggerFactory.getLogger(LevelReadyState.class);

  /**
   * Standard constructor for States.
   *
   * @param snake related maker
   */
  public LevelReadyState(final OurSnake snake) {
    super(snake);
    state = State.LEVEL_READY;
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
