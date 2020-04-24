package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;

public class MapManager {
  private static final int MAX_WIDTH = 50;
  private static final int MAX_HEIGHT = 50;

  private Terrain[][] map;

  public MapManager() {}

  /**
   * Creates the map with the given length and height.
   *
   * @param width the width of the map, must higher then 0
   * @param height the height of the map, must higher then 0
   * @throws IllegalParameterException if either the width or the height is invalid
   */
  public void createMap(int width, int height) throws IllegalParameterException {
    // Check minimum boundaries of the map
    if (width < 1 || height < 1) {
      throw new IllegalParameterException("Width or height cannot be lower than 1!");
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
