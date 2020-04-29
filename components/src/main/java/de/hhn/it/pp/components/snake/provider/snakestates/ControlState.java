package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;

//todo javadoc
public abstract class ControlState {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ControlState.class);

    protected State state;
    protected OurSnake snake;

    public ControlState(OurSnake snake) {
        logger.debug("ControlState - Constructor - " + this.getClass().getSimpleName());
        this.snake = snake;
    }

    //todo javadoc
    public State getState() {
        return state;
    }

    public void setState(final State state) {
        this.state = state;
    }

    public abstract void onStartLevel() throws IllegalStateException;

    public abstract void onEndLevel() throws IllegalStateException;

    public abstract void onCreateEnemy() throws IllegalStateException;

    public abstract void onCreateItem() throws IllegalStateException;

    public abstract void onCreateLevel() throws IllegalStateException;

    public abstract void onMove() throws IllegalStateException;

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
