package de.hhn.it.pp.components.snake.provider;

import static de.hhn.it.pp.components.snake.Direction.*;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.SnakeService;
import java.util.ArrayList;


/**
 * Implements all methods of SnakeService and AdminSnakeService.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class OurSnakeService implements SnakeService, AdminSnakeService {

  /** Achieved points.*/
  private int achievedScore;

  /** List of all player profiles. **/
  private ArrayList<SnakePlayerProfile> allPlayers;

  /** Current dircetion of the snake. */
  private Direction currentDirection;

  /** Width of the window. */
  private int windowWidth;

  /** Height of the window. */
  private int windowHeight;

  @Override
  public ArrayList<SnakePlayerProfile> getAllPlayers() {
    return allPlayers;
  }

  @Override
  public SnakePlayerProfile getPlayer(String nickname) throws IllegalParameterException {
    //if(allPlayers.contains())
    //todo
    //int index = allPlayers.indexOf
    //return allPlayers.get(index);
    //} else{
    //  throw new IllegalParameterException("Player with name " + nickname + " isn't available.
    //  Register the player first");
    // }
    return null;
  }

  @Override
  public void addCallback(String nickname, SnakePlayerProfile listener)
            throws IllegalParameterException {
        //SnakePlayerDescriptor player = getPlayer(nickname);
        //todo implement method addCallback
  }

  @Override
  public void removeCallback(String nickname, SnakePlayerProfile listener)
          throws IllegalParameterException {
        //SnakePlayerDescriptor player = getPlayer(nickname);
        //todo implement method removeCallback
  }

  @Override
  public void startGame(String nickname, int winWidth, int winHeight)
          throws IllegalParameterException {
    windowWidth = winWidth;
    windowHeight = winHeight;

    if (nickname.length() >= 12) {
      throw new IllegalParameterException("your nickname is too long. 12 characters are allowed.");
    } else if (allPlayers.contains(getPlayer(nickname))) {
      throw new IllegalParameterException("nickname is already used. please choose another one");
    } else {
      SnakePlayerProfile player = new SnakePlayerProfile(nickname);
      allPlayers.add(player);
      int xSpawn = 250; //todo magic numbers entfernen
      int ySpawn = 250;
      new OurSnake(nickname).spawn(xSpawn, ySpawn);
      new OurSnakeItem(1).spawn(20, 50);
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
  public void moveSnake(Direction key) throws IllegalParameterException {
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
  public Direction getCurrentDirection() {
    return currentDirection;
  }

  @Override
  public void addPlayer(SnakePlayerProfile nickname) throws IllegalParameterException {
    if (allPlayers.contains(nickname)) {
      throw new IllegalParameterException("nickname is already registered.");
    } else {
      allPlayers.add(nickname);
    }
  }

  @Override
  public void removePlayer(String nickname) throws IllegalParameterException {
    if (allPlayers.contains(getPlayer(nickname))) {
      allPlayers.remove(getPlayer(nickname));
    } else {
      throw new IllegalParameterException("nickname is not registered, "
                    + "therefore it can't be removed");
    }
  }
}
