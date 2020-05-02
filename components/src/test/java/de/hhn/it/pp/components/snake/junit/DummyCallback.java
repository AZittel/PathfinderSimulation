package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyCallback implements SnakePlayerListener {
    private static final Logger logger =
            LoggerFactory.getLogger(DummyCallback.class);

    @Override
    public void newState(State state) { logger.info("Callback called with state " + state);
    }
}
