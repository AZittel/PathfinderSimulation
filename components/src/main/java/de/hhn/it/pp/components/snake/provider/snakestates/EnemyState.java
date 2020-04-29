package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//todo javadoc
public class EnemyState extends ControlState {
  private static final Logger logger =
            LoggerFactory.getLogger(EnemyState.class);

  /**
   * Standard constructor for States.
   *
   * @param snake related maker
   */
  public EnemyState(final OurSnake snake) {
    super(snake);
    state = State.CREATE_ENEMY;
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
