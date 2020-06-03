package de.hhn.it.pp.components.snake;

import de.hhn.it.pp.components.snake.provider.logic.SnakeGameState;

public interface SnakeListener {

    void newSnakeGameState(SnakeGameState gameState);

}
