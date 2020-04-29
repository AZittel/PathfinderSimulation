package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.snake.SnakeListener;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.provider.snakestates.ControlState;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




//todo javadoc
public class OurSnake implements Snake {
  private static final Logger logger =
            LoggerFactory.getLogger(OurSnake.class);
  private static int instance;
  private ControlState controlState;
  private List<SnakeListener> listeners;
  private SnakePlayerProfile descriptor;

  /** x-coordinate of the snake. */
  private int xPosition;

  /** y-coordinate of the snake. */
  private int yPosition;

  /**
   * Constructor to create a OurSnake based on the information in the given
   * SnakePlayerDescriptor.
   */
  public OurSnake(String nickname) {
    listeners = new ArrayList<>();
    SnakePlayerProfile descriptor = new SnakePlayerProfile(nickname);
    descriptor.setInstance(instance++);
    // controlState = new OverState( snake: this);
    updateDescriptor();
  }

  //todo javadoc
  public static int getInstance() {
    return instance;
  }

  public static void setInstance(final int instance) {
    OurSnake.instance = instance;
  }

  private void updateDescriptor() {
    descriptor.setState(controlState.getState());
  }

  @Override
  public void createLevel() throws IllegalParameterException {
    controlState.onCreateLevel();
  }

  @Override
  public void startLevel() throws IllegalStateException {
    controlState.onStartLevel();
  }

  @Override
  public void endLevel() throws IllegalStateException {
    controlState.onEndLevel();
  }

  @Override
  public void move(Move move) throws IllegalParameterException, IllegalStateException {
    controlState.onMove();
  }

  @Override
  public void addCallback(SnakeListener listener) throws IllegalParameterException {
    if (listener == null) {
      throw new IllegalParameterException("Listener was null reference.");
    }

    if (listeners.contains(listener)) {
      throw new IllegalParameterException("Listener already registered.");
    }
    listeners.add(listener);
  }

  @Override
  public void removeCallback(SnakeListener listener) throws IllegalParameterException {
    if (listener == null) {
      throw new IllegalParameterException("Listener was null reference.");
    }

    if (!listeners.contains(listener)) {
      throw new IllegalParameterException("Listener is not registered:" + listener);
    }

    listeners.remove(listener);
  }

  @Override
  public SnakePlayerProfile getDescriptor() {
    return descriptor;
  }

  public ControlState getControlState() {
    return controlState;
  }

  /**
   * sets the state of the Snake and notifies all listeners.
   *
   * @param makerState new maker state
   */
  public void setMakerState(final ControlState makerState) {
    logger.debug("setMakerState - {}", makerState);
    controlState = makerState;
    updateDescriptor();
    notifyListeners(controlState);
  }

  //todo javadoc
  private void notifyListeners(ControlState makerState) {
    for (SnakeListener listener : listeners) {
      listener.newState(makerState.getState());
    }
  }

  @Override
  public void spawn(int xPos, int yPos) {
    xPosition = xPos;
    yPosition = yPos;
  }
}
