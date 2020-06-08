package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.snake.provider.logic.State;

//todo javadoc

public interface SnakeListener {
    void newState(State state);
}
