package de.hhn.it.pp.components.astarpathfinding.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds;
import de.hhn.it.pp.components.astarpathfinding.provider.MapManager;
import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapManagerTest {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(MapManagerTest.class);

  @Test
  @DisplayName("Create a new terrain map")
  public void createMap_newMap() throws IllegalParameterException, PositionOutOfBounds {
    MapManager testManager = new MapManager();
    testManager.createMap(12, 15);
    Terrain[][] map = testManager.getMap();
    assertAll(
        () -> assertEquals(15, map.length, "The map height should be 15."),
        () -> assertEquals(12, map[0].length, "The map height should be 12."));
    for (int i = 0; i < map.length - 1; i++) {
      for (int j = 0; j < map[0].length - 1; j++) {
        assertEquals(TerrainType.DIRT, map[i][j].getType(), "The terrain type should be dirt.");
      }
    }
  }
}
