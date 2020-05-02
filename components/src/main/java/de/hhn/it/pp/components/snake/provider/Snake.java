package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.SnakePlayerListener;

public interface Snake {

  void startGame() throws IllegalStateException;

  void switchLevel() throws IllegalParameterException; //todo

  void endGame() throws IllegalStateException;

  void move(Move direction) throws IllegalParameterException, IllegalStateException;

  void addCallback(SnakePlayerListener listener) throws IllegalParameterException;

  void removeCallback(SnakePlayerListener listener) throws IllegalParameterException;

  SnakePlayerProfile getDescriptor();
}
