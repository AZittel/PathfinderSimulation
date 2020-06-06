package de.hhn.it.pp.components.spaceinvaders;

import java.util.ArrayList;

public class HighScoreEntry {
  private static final org.slf4j.Logger logger =
          org.slf4j.LoggerFactory.getLogger(HighScoreEntry.class);

  private String name;
  private int value;
  public static ArrayList<HighScoreEntry> highScoreEntries = new ArrayList<>();

  public HighScoreEntry(final String name, final int value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }
}
