package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.awt.event.KeyEvent;

public interface Snake {

    void startGame() throws IllegalStateException;

    void switchLevel() throws IllegalParameterException;

    void endGame() throws IllegalStateException;

    void move(Move direction) throws IllegalParameterException, IllegalStateException;

    void addCallback(SnakePlayerListener listener) throws IllegalParameterException;

    void removeCallback(SnakePlayerListener listener) throws IllegalParameterException;

    SnakePlayerDescriptor getDescriptor();
}
