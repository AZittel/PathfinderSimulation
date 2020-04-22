package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.Position;

public class MapManager {

  private Terrain[][] map;


  public MapManager() {

  }


  public void createMap(int width, int height) {
    map = new Terrain[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < height; col++) {
        map[row][col] = new Terrain(row, col, TerrainType.GRASS);
      }
    }
  }

  public Terrain getTerrainAt(int row, int col){
    return map[row][col];
  }

  public Terrain[][] getMap() {
    return map;
  }

}
