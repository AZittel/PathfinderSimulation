package de.hhn.it.pp.components.snake.provider;

import java.util.ArrayList;

public class OurSnakeLevel {

  private int levelId;

  private int neededHighscore;

  private ArrayList<OurSnakeLevel> allLevels = new ArrayList<>();

  public OurSnakeLevel(int levelId, int neededHighscore) {
    this.levelId = levelId;
    this.neededHighscore = neededHighscore;
    allLevels.add(this);
  }

  public int getLevelId() {
    return levelId;
  }

  public void load(int id){

  }

  public int getNeededHighscore() {
    return neededHighscore;
  }
}
