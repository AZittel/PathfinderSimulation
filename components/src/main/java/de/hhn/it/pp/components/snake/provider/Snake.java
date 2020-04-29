package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.Move;
import de.hhn.it.pp.components.snake.SnakeListener;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;

//todo javadoc
public interface Snake {

  void createLevel() throws IllegalParameterException;

  void startLevel() throws IllegalStateException;

  void endLevel() throws IllegalStateException;

  void move(Move move) throws IllegalParameterException, IllegalStateException;

  void addCallback(SnakeListener listener) throws IllegalParameterException;

  void removeCallback(SnakeListener listener) throws IllegalParameterException;

  SnakePlayerProfile getDescriptor();

  void spawn(int yPos, int xPos);
}
