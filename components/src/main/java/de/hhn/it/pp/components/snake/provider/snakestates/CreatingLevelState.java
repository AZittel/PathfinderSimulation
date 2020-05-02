package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class CreatingLevelState extends ControlState {
  private static final Logger logger =
            LoggerFactory.getLogger(CreatingLevelState.class);

  /**
   * Standard constructor for States.
   *
   * @param snake related maker
   */
  public CreatingLevelState(final OurSnake snake) {
    super(snake);
    state = State.CREATING_LEVEL;
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
