package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class MoveState extends ControlState {
  private static final Logger logger =
            LoggerFactory.getLogger(MoveState.class);
  private static final long BREWING_TIME_MILLIS = 1000;

  /**
   * Standard constructor for States.
   *
   * @param maker related maker
   */
  public MoveState(final OurSnake maker) {
    super(maker);
    state = State.MOVING;
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
