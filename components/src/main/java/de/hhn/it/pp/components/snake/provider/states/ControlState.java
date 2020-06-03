package de.hhn.it.pp.components.snake.provider.states;

import de.hhn.it.pp.components.snake.provider.OurSnakeGame;
import de.hhn.it.pp.components.snake.provider.logic.State;

public abstract class ControlState {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ControlState.class);

    protected State state;
    protected OurSnakeGame player;

    public ControlState(OurSnakeGame player) {
        logger.debug("ControlState - Constructor - " + this.getClass().getSimpleName());
        this.player = player;
    }

    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public abstract void onStartGame() throws IllegalStateException;

    public abstract void onSwitchLevel() throws IllegalStateException;

    public abstract void onEndGame() throws IllegalStateException;

    public abstract void onMove() throws IllegalStateException;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

