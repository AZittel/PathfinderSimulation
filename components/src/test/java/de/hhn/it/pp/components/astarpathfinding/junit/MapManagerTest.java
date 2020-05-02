package de.hhn.it.pp.components.astarpathfinding.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds.PositionType;
import de.hhn.it.pp.components.astarpathfinding.provider.MapManager;
import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapManagerTest {
  private static final org.slf4j.Logger logger =
    org.slf4j.LoggerFactory.getLogger(MapManagerTest.class);

  private MapManager testMapManager;

  @BeforeEach
  void setup() {
    testMapManager = new MapManager();
  }


  @Test
  @DisplayName("Successfully create a new terrain map")
  public void createMap_newMap() throws IllegalParameterException, PositionOutOfBounds {
    testMapManager.createMap(12, 15);
    Terrain[][] map = testMapManager.getMap();
    assertAll(
      () -> assertEquals(15, map.length, "The map height should be 15."),
      () -> assertEquals(12, map[0].length, "The map height should be 12."));
    for (int i = 0; i < map.length - 1; i++) {
      for (int j = 0; j < map[0].length - 1; j++) {
        assertEquals(TerrainType.DIRT, map[i][j].getType(), "The terrain type should be dirt.");
      }
    }
  }

  @Test
  @DisplayName(
    "Unsuccessfully create a new terrain map with width and height being lower than the minimum values")
  public void createMap_belowMinimumValues() throws IllegalParameterException, PositionOutOfBounds {
    IllegalParameterException exception = assertThrows(IllegalParameterException.class,
      () -> testMapManager.createMap(MapManager.MIN_WIDTH - 1, MapManager.MIN_HEIGHT - 1));
  }

  @Test
  @DisplayName(
    "Unsuccessfully create a new terrain map with width and height being higher than the maximum values")
  public void createMap_aboveMaximumValues() throws IllegalParameterException, PositionOutOfBounds {
    IllegalParameterException exception = assertThrows(IllegalParameterException.class,
      () -> testMapManager.createMap(MapManager.MAX_WIDTH + 1, MapManager.MAX_HEIGHT + 1));
  }

  @Test
  @DisplayName(
    "Unsuccessfully create a new terrain map where the startPosition would be out of bounds")
  public void createMap_startPositionOutOfBounds()
    throws IllegalParameterException, PositionOutOfBounds, OccupiedPositionException {
    testMapManager.setStartCoordinates(new Position(9, 8));
    PositionOutOfBounds exception =
      assertThrows(PositionOutOfBounds.class, () -> testMapManager.createMap(5, 5));
    assertEquals(PositionType.START, exception.getPositionType());
  }

  @Test
  @DisplayName(
    "Unsuccessfully create a new terrain map where the destinationPosition would be out of bounds")
  public void createMap_destinationPositionOutOfBounds()
    throws IllegalParameterException, PositionOutOfBounds {
    PositionOutOfBounds exception =
      assertThrows(PositionOutOfBounds.class, () -> testMapManager.createMap(5, 5));
    assertEquals(PositionType.DESTINATION, exception.getPositionType());
  }

  @Test
  @DisplayName("Successfully create new terrain")
  public void createTerrain_Good() throws PositionOutOfBounds {
    TerrainType type = TerrainType.SWAMP;
    Position pos = new Position(5, 5);
    Terrain oldTerrain = testMapManager.getTerrainAt(pos.getX(), pos.getY());
    testMapManager.createTerrain(type, pos);
    Terrain newTerrain = testMapManager.getTerrainAt(pos.getY(), pos.getX());
    assertAll(
      () -> assertEquals(TerrainType.SWAMP, newTerrain.getType()),
      () -> assertNotSame(oldTerrain, newTerrain));
  }

  @Test
  @DisplayName("Create terrain out of bounds to the left")
  public void createTerrain_leftOutOfBounds() throws PositionOutOfBounds {
    TerrainType type = TerrainType.SWAMP;
    Position pos = new Position(-1, 5);
    PositionOutOfBounds exception =
      assertThrows(PositionOutOfBounds.class, () -> testMapManager.createTerrain(type, pos));
  }

  @Test
  @DisplayName("Create terrain out of bounds to the right")
  public void createTerrain_rightOutOfBounds() throws PositionOutOfBounds {
    TerrainType type = TerrainType.SWAMP;
    Position pos = new Position(testMapManager.getWidth() + 1, 5);
    PositionOutOfBounds exception =
      assertThrows(PositionOutOfBounds.class, () -> testMapManager.createTerrain(type, pos));
  }

  @Test
  @DisplayName("Create terrain out of bounds to the top")
  public void createTerrain_topOutOfBounds() throws PositionOutOfBounds {
    TerrainType type = TerrainType.SWAMP;
    Position pos = new Position(5, -1);
    PositionOutOfBounds exception =
      assertThrows(PositionOutOfBounds.class, () -> testMapManager.createTerrain(type, pos));
  }

  @Test
  @DisplayName("Create terrain out of bounds to the bottom")
  public void createTerrain_bottomOutOfBounds() throws PositionOutOfBounds {
    TerrainType type = TerrainType.SWAMP;
    Position pos = new Position(5, testMapManager.getHeight() + 1);
    PositionOutOfBounds exception =
      assertThrows(PositionOutOfBounds.class, () -> testMapManager.createTerrain(type, pos));
  }


}
