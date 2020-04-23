package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakeListener;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.snake.provider.snakestates.ControlState;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.snakestates.OverState;

import java.util.ArrayList;
import java.util.List;

public class OurSnake implements Snake{
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(OurSnake.class);
    private static int instance;
    private ControlState controlState;
    private List<SnakeListener> listeners;
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
        descriptor.setInstance(instance++);
       // controlState = new OverState( snake: this);
        updateDescriptor();
    }
    public static int instance() {
        return instance;
    }

    public static void setInstance(final int instance){
        OurSnake.instance = instance;
    }

    private void updateDescriptor() {
        descriptor.setState(controlState.getState());
    }

    @Override
    public void createLevel() throws IllegalParameterException {
        controlState.onCreateLevel();
    }

    public void startLevel() throws IllegalStateException {
        controlState.onStartLevel();
    }

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
    public SnakePlayerDescriptor getDescriptor() {
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
        this.controlState = makerState;
        updateDescriptor();
        notifyListeners(controlState);
    }

    private void notifyListeners(ControlState makerState) {
        for (SnakeListener listener : listeners) {
            listener.newState(makerState.getState());
        }
    }
}
