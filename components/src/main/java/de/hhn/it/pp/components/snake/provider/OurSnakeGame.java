package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakeListener;
import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;
import de.hhn.it.pp.components.snake.provider.states.ControlState;

import java.util.ArrayList;
import java.util.List;

//todo javadoc
//todo logging

public class OurSnakeGame implements SnakeGame {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(OurSnakeGame.class);
    private static int idCounter;
    private ControlState controlState;
    private List<SnakeListener> listeners;
    private PlayerProfile profile;

    /**
     * Constructor to create a OurSnake based on the information in the given
     * SnakePlayerDescriptor.
     *
     * @param profile Descriptor with basic facts about the Snake to be created
     */
    public OurSnakeGame (PlayerProfile profile) {
        logger.info("Constructor - {}", profile);
        listeners = new ArrayList<>();
        this.profile = profile;
        //this.profile.setPlayerId(idCounter++);
        //controlState = new OverState( snake: this);
        updatePlayerProfile();
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(final int idCounter) {
        OurSnakeGame.idCounter = idCounter;
    }

    private void updatePlayerProfile() {
        profile.setCurrentState(controlState.getState());
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
    public PlayerProfile getProfile() {
        return profile;
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
        updatePlayerProfile();
        notifyListeners(controlState);
    }

    /**
     *
     * @param controlState
     */
    private void notifyListeners(ControlState controlState) {
        for (SnakeListener listener : listeners) {
            listener.newState(controlState.getState());
        }
    }
}
