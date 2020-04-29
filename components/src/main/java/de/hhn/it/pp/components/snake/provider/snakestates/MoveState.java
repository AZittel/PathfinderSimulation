package de.hhn.it.pp.components.snake.provider.snakestates;

import de.hhn.it.pp.components.snake.State;
import de.hhn.it.pp.components.snake.provider.OurSnake;

//todo javadoc
public class MoveState extends ControlState {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(MoveState.class);
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
