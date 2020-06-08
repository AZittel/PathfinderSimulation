package de.hhn.it.pp.components.snake.provider;


import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakeListener;
import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;

//todo javadoc
public interface SnakeGame {
  void startGame() throws IllegalStateException;

  void switchLevel() throws IllegalParameterException;

  void endGame() throws IllegalStateException;

  void addCallback(SnakeListener listener) throws IllegalParameterException;

  void removeCallback(SnakeListener listener) throws IllegalParameterException;

  PlayerProfile getProfile();
}
