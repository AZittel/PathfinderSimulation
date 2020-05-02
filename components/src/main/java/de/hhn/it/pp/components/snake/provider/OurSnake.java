package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.provider.snakestates.ControlState;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.ArrayList;
import java.util.List;


public class OurSnake implements Snake {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(OurSnake.class);
    private static int idCounter;
    private ControlState controlState;
    private List<SnakePlayerListener> listeners;
    private SnakePlayerDescriptor descriptor;

    /**
     * Constructor to create a OurSnake based on the information in the given
     * SnakePlayerDescriptor.
     *
     * @param descriptor Descriptor with basic facts about the Snake to be created
     */
    public OurSnake(SnakePlayerDescriptor descriptor) {
        logger.debug("Constructor - {}", descriptor);
        listeners = new ArrayList<>();
        this.descriptor = descriptor;
        descriptor.setId(idCounter++);
        //controlState = new OverState( snake: this);
        updateDescriptor();
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(final int idCounter) {
        OurSnake.idCounter = idCounter;
    }

    private void updateDescriptor() {
        descriptor.setState(controlState.getState());
    }

    @Override
    public void startGame() throws IllegalStateException {
        controlState.onStartGame();
    }

    @Override
    public void switchLevel() throws IllegalParameterException {
        controlState.onSwitchLevel();
    }

    @Override
    public void endGame() throws IllegalStateException {
        controlState.onEndGame();
    }

    @Override
    public void move(Move direction) throws IllegalParameterException, IllegalStateException {
        controlState.onMove();
    }

    @Override
    public void addCallback(SnakePlayerListener listener) throws IllegalParameterException {
        if (listener == null) {
            throw new IllegalParameterException("Listener was null reference.");
        }
        if (listeners.contains(listener)) {
            throw new IllegalParameterException("Listener already registered.");
        }
        listeners.add(listener);
    }

    @Override
    public void removeCallback(SnakePlayerListener listener) throws IllegalParameterException {
        if (listener == null) {
            throw new IllegalParameterException("Listener was null reference.");
        }
        if (!listeners.contains(listener)) {
            throw new IllegalParameterException("Listener is not registered:" + listener);
        }
        listeners.remove(listener);
    }

    @Override
    public SnakePlayerDescriptor getDescriptor() {
        return descriptor;
    }

    public ControlState getControlState() {
        return controlState;
    }

    /**
     * sets the state of the Snake and notifies all listeners.
     *
     * @param controlState new maker state
     */
    public void setControlState(final ControlState controlState) {
        logger.debug("setMakerState - {}", controlState);
        this.controlState = controlState;
        updateDescriptor();
        notifyListeners(controlState);
    }

    private void notifyListeners(ControlState controlState) {
        for (SnakePlayerListener listener : listeners) {
            listener.newState(controlState.getState());
        }
    }
}
