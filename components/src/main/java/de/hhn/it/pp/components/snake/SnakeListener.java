package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.snake.provider.logic.State;

public interface SnakeListener {
    void newState(State state);
}
