package de.hhn.it.pp.components.snake.provider.logic;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for the playable snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class Snake {

  /** Snake's Logger. */
  private static final Logger logger = LoggerFactory.getLogger(Snake.class);

  /** Variable waits for new direction for head, needed for key handler. */
  public static boolean waitToMove = false;

  /** Snake's head with start coordinates. */
  protected static SnakeHead snakeHead = new SnakeHead(15, 15);

  /** ArrayList for all tails of the snake. */
  public static ArrayList<SnakeTail> allTails = new ArrayList<>();

  /** Collectible item. */
  public static Item collectibleItem = new Item(1);

  /** Score. */
  public static int score = 0;

  /** Highscore. */
  public static int highscore = 0;

  /**
   * Adds a tail to the snake.
   */
  public static void addTail() {
    logger.info("adds a new tail");
    //there's no tail/first tail
    if (allTails.size() < 1) {
      allTails.add(new SnakeTail(snakeHead.getHeadXPosition(), snakeHead.getHeadYPosition()));
    } else {
      //there are already tails
      allTails.add(new SnakeTail(allTails.get(allTails.size() - 1).getTailXPosition(),
              allTails.get(allTails.size() - 1).getTailYPosition()));
    }
  }

  /**
   * Moves the snake's head and all of its tails.
   */
  public static void move() {
    logger.info("moves the snake in given direction");
    //move all tails
    if (allTails.size() >= 2) {
      for (int i = allTails.size() - 1; i >= 1; i--) {
        if (allTails.get(i).isWait()) {
          allTails.get(i).setWait(false);
        } else {
          allTails.get(i).setTailXPosition(allTails.get(i - 1).getTailXPosition());
          allTails.get(i).setTailYPosition(allTails.get(i - 1).getTailYPosition());
        }
      }
    }

    // move first tail on headpos
    if (allTails.size() >= 1) {
      if (allTails.get(0).isWait()) {
        allTails.get(0).setWait(false);
      } else {
        allTails.get(0).setTailXPosition(snakeHead.getHeadXPosition());
        allTails.get(0).setTailYPosition(snakeHead.getHeadYPosition());
      }
    }
    //move head
    switch (snakeHead.getHeadDirection()) {
      case UP:
        snakeHead.setHeadYPosition(snakeHead.getHeadYPosition() - 1);
        break;
      case DOWN:
        snakeHead.setHeadYPosition(snakeHead.getHeadYPosition() + 1);
        break;
      case LEFT:
        snakeHead.setHeadXPosition(snakeHead.getHeadXPosition() - 1);
        break;
      case RIGHT:
        snakeHead.setHeadXPosition(snakeHead.getHeadXPosition() + 1);
        break;
    }
  }
}
