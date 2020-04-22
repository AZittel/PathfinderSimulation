package de.hhn.it.pp.components.snake.provider;

import static de.hhn.it.pp.components.snake.Directions.*;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.Directions;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakeService;
import java.util.List;

/**
 * Implements all methods of SnakeService and AdminSnakeService.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class OurSnakeService implements SnakeService, AdminSnakeService {

  /** Achieved points.*/
  private int achievedScore;

  /** List of all nicknames.*/
  private List<String> profiles;

  private List<SnakePlayerDescriptor> allPlayers;

  /** Current dircetion of the snake. */
  private Directions currentDirection;

  @Override
  public List<SnakePlayerDescriptor> getPlayers() {
    //return allPlayers; //todo überarbeiten!
    return null;
  }

  @Override
  public SnakePlayerDescriptor getPlayer(String nickName) throws IllegalParameterException {
    return allPlayers.get(Integer.parseInt(nickName)); //todo übearbeiten! Exception werfen!
  }

  @Override
  public void addCallback(String nickName, SnakePlayerDescriptor listener)
          throws IllegalParameterException {
    SnakePlayerDescriptor player = getPlayer(nickName);
    //todo implement method addCallback
  }

  @Override
  public void removeCallback(String nickName, SnakePlayerDescriptor listener)
          throws IllegalParameterException {
    SnakePlayerDescriptor player = getPlayer(nickName);
    //todo implement method removeCallback
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
    if (highscore < 10) {
      level.load(1); //TODO id überarbeiten
    }
    if (highscore < 0) {
      throw new IllegalParameterException("invalid highscore");
    }

  }

  @Override
  public boolean exitGame() {
    return true;
  }

  @Override
  public void moveSnake(Directions key) throws IllegalParameterException {
    if (key == LEFT) {
      currentDirection = LEFT;
    } else if (key == RIGHT) {
      currentDirection = RIGHT;
    } else if (key == DOWN) {
      currentDirection = DOWN;
    } else if (key == UP) {
      currentDirection = UP;
    } else {
      throw new IllegalParameterException("Invalid key. Please press WASD or arrow keys.");
    }
  }

  @Override
  public int collect(OurSnakeItem snakeFood) {
    achievedScore += snakeFood.getValue();
    return achievedScore;
  }

  @Override
  public Directions getCurrentDirection() {
    return currentDirection;
  }

  @Override
  public void addPlayer(SnakePlayerDescriptor nickName) throws IllegalParameterException {
    if (allPlayers.contains(nickName)) {
      throw new IllegalParameterException("nickname is already registered.");
    } else {
      allPlayers.add(nickName);
    }
  }

  @Override
  public void removePlayer(SnakePlayerDescriptor nickName) throws IllegalParameterException {
    if (allPlayers.contains(nickName)) {
      allPlayers.remove(nickName);
    } else {
      throw new IllegalParameterException("nickname is not registered, "
              + "therefore it can't be removed");
    }
  }
}

