package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.snake.provider.snakestates.ControlState;

public interface SnakePlayerListener {
    void newState(State state);
}
