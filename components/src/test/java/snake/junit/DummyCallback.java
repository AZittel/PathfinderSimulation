package snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.State;

public class DummyCallback implements SnakePlayerListener {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(DummyCallback.class);

    @Override
    public void newState(State state) { logger.info("Callback called with state " + state);
    }
}
