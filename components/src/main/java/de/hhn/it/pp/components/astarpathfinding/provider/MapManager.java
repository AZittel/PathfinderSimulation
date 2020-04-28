package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;


public class MapManager {
  private static final int MAX_WIDTH = 50;
  private static final int MAX_HEIGHT = 50;
  private static final int MIN_WIDTH = 2;
  private static final int MIN_HEIGHT = 2;



  private Terrain[][] map;

  public MapManager() {
  }

  /**
   * Creates the map with the given width and height.
   *
   * @param width  the width of the map, must higher then 1
   * @param height the height of the map, must higher then 1
   * @throws IllegalParameterException if either the width or the height is invalid
   */
  public void createMap(int width, int height) throws IllegalParameterException {
    // Check minimum boundaries of the map
    if (width < MIN_WIDTH || height < MIN_HEIGHT) {
      throw new IllegalParameterException("Width or height cannot be lower than 2!");
    }

    // Check maximum boundaries of the map
    if (width > MAX_WIDTH || height > MAX_HEIGHT) {
      throw new IllegalParameterException(
        String.format(
          "Width or height exceeded max value! Maximum width is %d. Maximum height is %d.",
          MAX_WIDTH, MAX_HEIGHT));
    }

    // Create new map with grass terrain
    map = new Terrain[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < height; col++) {
        map[row][col] = new Terrain(row, col, TerrainType.GRASS);
      }
    }
  }

  public Terrain getTerrainAt(int row, int col) {
    return map[row][col];
  }

  public Terrain[][] getMap() {
    return map;
  }
}
