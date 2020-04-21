package de.hhn.it.pp.components.snake.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakeService;
import java.awt.event.KeyEvent;
import java.util.List;


public class OurSnakeService implements SnakeService {

  /**
   * Achieved points.
   */
  private int achievedScore;

  /**
   * List of all nicknames.
   */
  private List<String> profiles;

  @Override
  public List<SnakePlayerDescriptor> getPlayers() {
    return null;
  }

  @Override
  public SnakePlayerDescriptor getPlayer(String nick) throws IllegalParameterException {
    return null;
  }

  @Override
  public void addCallback(String nick, SnakePlayerDescriptor listener)
          throws IllegalParameterException {

  }

  @Override
  public void removeCallback(String nick, SnakePlayerDescriptor listener)
          throws IllegalParameterException {

  }

  @Override
  public void startGame(String nickName) throws IllegalParameterException {
    new OurSnakeItem(1).spawn(20, 50);
    if (nickName.length() >= 12) {
      throw new IllegalParameterException("your nickname is too long. 12 characters are allowed.");
    } else if (profiles.contains(nickName)) {
      throw new IllegalParameterException("nickname is already used. please choose another one");
    } else {
      profiles.add(nickName);
    }
  }

  @Override
  public void runLevel(OurSnakeLevel level, int highscore) throws IllegalParameterException {
    if (highscore == 0 || highscore < 10) {
      level.load(1); //TODO id überarbeiten
    }
    if (highscore < 0) {
      throw new IllegalParameterException("invalid highscore");
    }

  }

  @Override
  public void exitGame() {

  }

  @Override
  public void moveSnake(KeyEvent key) throws IllegalParameterException {
    if (key.getKeyCode() == KeyEvent.VK_W || key.getKeyCode() == KeyEvent.VK_UP) {
      boolean moveUp = true;
    }
    if (key.getKeyCode() == KeyEvent.VK_S || key.getKeyCode() == KeyEvent.VK_DOWN) {
      boolean moveDown = true;
    }
    if (key.getKeyCode() == KeyEvent.VK_A || key.getKeyCode() == KeyEvent.VK_LEFT) {
      boolean moveLeft = true;
    }
    if (key.getKeyCode() == KeyEvent.VK_D || key.getKeyCode() == KeyEvent.VK_RIGHT) {
      boolean moveRight = true;
    } else {
      throw new IllegalParameterException("Invalid key. Please press WASD or arrow keys.");
    }
  }

  @Override
  public int collect(OurSnakeItem snakeFood) {
    achievedScore += snakeFood.getValue();
    return achievedScore;
  }
}
