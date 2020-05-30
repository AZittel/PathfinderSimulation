package de.hhn.it.pp.components.snake.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

//todo logger

/**
 * Creates a new level.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class OurSnakeLevel {

  private static final Logger logger =
          LoggerFactory.getLogger(OurSnakeLevel.class);



  /** Id of the level. */
  private int levelId;

  /** Highscore that is required for the next level. */
  private int neededHighscore;

  /** List of all levels. */
  private ArrayList<OurSnakeLevel> allLevels = new ArrayList<>();

  /**
   * Constructor of OurSnakeLevel.
   *
   * @param levelId level's id
   * @param neededHighscore highscore that is required for the next level
   */
  public OurSnakeLevel(int levelId, int neededHighscore) {
    logger.info("created level with id {} and needed highscore {}", levelId, neededHighscore);
    this.levelId = levelId;
    this.neededHighscore = neededHighscore;
    allLevels.add(this);
  }

  /**
   * Getter for level's id.
   *
   * @return level's id
   */
  public int getLevelId() {
    logger.info("level's id = {}", levelId);
    return levelId;
  }

  /**
   * Loads the level.
   *
   * @param id Id of the level that should load.
   */
  public void load(int id){
    //todo implement!
    //todo logger
  }

  /**
   * Getter for neededHighscore.
   *
   * @return Required highscore for the next level
   */
  public int getNeededHighscore() {
    logger.info("needed highscore of the level is {}", neededHighscore);
    return neededHighscore;
  }
}
