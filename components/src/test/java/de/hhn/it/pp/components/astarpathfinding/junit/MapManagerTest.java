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
  @DisplayName("Successfully create a new MapManager with default values")
  public void constructor_newMapManager() {
    Terrain[][] map = testMapManager.getMap();
    assertAll(
      () ->
        assertEquals(
          MapManager.DEFAULT_START_POSITION,
          testMapManager.getStartCoordinates(),
          "The start position should be equal to the default start position"),
      () ->
        assertEquals(
          MapManager.DEFAULT_DESTINATION_POSITION,
          testMapManager.getDestinationCoordinates(),
          "The destination position should be equal to the default destination position"),
      () ->
        assertEquals(
          MapManager.DEFAULT_HEIGHT,
          map.length,
          "The map height should be the default height."),
      () ->
        assertEquals(
          MapManager.DEFAULT_WIDTH,
          map[0].length,
          "The map width should be the default width."));
    for (int i = 0; i < map.length - 1; i++) {
      for (int j = 0; j < map[0].length - 1; j++) {
        assertEquals(TerrainType.DIRT, map[i][j].getType(), "The terrain type should be dirt.");
      }
    }
  }

  @Test
  @DisplayName("Successfully create a new terrain map")
  public void createMap_newMap() throws IllegalParameterException, PositionOutOfBounds {
    testMapManager.createMap(12, 15);
    Terrain[][] map = testMapManager.getMap();
    assertAll(
      () -> assertEquals(15, map.length, "The map height should be 15."),
      () -> assertEquals(12, map[0].length, "The map width should be 12."));
    for (int i = 0; i < map.length - 1; i++) {
      for (int j = 0; j < map[0].length - 1; j++) {
        assertEquals(TerrainType.DIRT, map[i][j].getType(), "The terrain type should be dirt.");
      }
    }
  }

  @Test
  @DisplayName(
    "Unsuccessfully create a new terrain map with width and height being lower than the minimum " +
      "values")
  public void createMap_belowMinimumValues() throws IllegalParameterException, PositionOutOfBounds {
    IllegalParameterException exception =
      assertThrows(
        IllegalParameterException.class,
        () -> testMapManager.createMap(MapManager.MIN_WIDTH - 1, MapManager.MIN_HEIGHT - 1));
  }

  @Test
  @DisplayName(
    "Unsuccessfully create a new terrain map with width and height being higher than the maximum " +
      "values")
  public void createMap_aboveMaximumValues() throws IllegalParameterException, PositionOutOfBounds {
    IllegalParameterException exception =
      assertThrows(
        IllegalParameterException.class,
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

  @Test
  @DisplayName("Successfully reset the map")
  public void reset_successful()
    throws PositionOutOfBounds, IllegalParameterException, OccupiedPositionException {
    // Create a map with a new width and height
    int width = 20;
    int height = 20;
    testMapManager.createMap(width, height);
    // Set new terrain on the map
    testMapManager.createTerrain(TerrainType.LAVA, new Position(0, 0));
    testMapManager.createTerrain(
      TerrainType.LAVA,
      new Position(testMapManager.getWidth() - 1, testMapManager.getHeight() - 1));
    // Set start and destination position
    Position newStartPosition = new Position(5, 5);
    testMapManager.setStartCoordinates(newStartPosition);
    Position newDestinationPosition = new Position(15, 15);
    testMapManager.setDestinationCoordinates(newDestinationPosition);

    testMapManager.reset();
    Terrain[][] map = testMapManager.getMap();
    assertAll(
      () ->
        assertEquals(height, map.length, String.format("The map height should be %d.", height)),
      () ->
        assertEquals(width, map[0].length, String.format("The map width should be %d.", width)),
      () ->
        assertEquals(
          newStartPosition,
          testMapManager.getStartCoordinates(),
          String.format("The start point should be %s.", newStartPosition.toString())),
      () ->
        assertEquals(
          newDestinationPosition,
          testMapManager.getDestinationCoordinates(),
          String.format(
            "The destination point should be %s.", newDestinationPosition.toString())));
    for (int i = 0; i < map.length - 1; i++) {
      for (int j = 0; j < map[0].length - 1; j++) {
        assertEquals(TerrainType.DIRT, map[i][j].getType(), "The terrain type should be dirt.");
      }
    }
  }

  @Test
  @DisplayName("Tests all possible out of bounds directions for setStartCoordinates")
  public void setStartCoordinates_OutOfBounds() {
    assertAll(
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () -> testMapManager.setStartCoordinates(new Position(-1, 5)),
          "Start point should be out of bounds on the left side"),
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () ->
            testMapManager.setStartCoordinates(
              new Position(testMapManager.getWidth() + 1, 5)),
          "Start point should be out of bounds on the right side"),
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () -> testMapManager.setStartCoordinates(new Position(5, -1)),
          "Start point should be out of bounds on the top side"),
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () ->
            testMapManager.setStartCoordinates(
              new Position(5, testMapManager.getHeight() + 1)),
          "Start point should be out of bounds on the bottom side"));
  }

  @Test
  @DisplayName("Tries to set the start point onto the destination point")
  public void setStartCoordinates_occupiedPosition() {
    assertThrows(
      OccupiedPositionException.class,
      () -> testMapManager.setStartCoordinates(MapManager.DEFAULT_DESTINATION_POSITION),
      "Expected an exception when placing the start point");
  }

  @Test
  @DisplayName("Tests all possible out of bounds directions for setDestinationCoordinates")
  public void setDestinationCoordinates_OutOfBounds() {
    assertAll(
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () -> testMapManager.setDestinationCoordinates(new Position(-1, 5)),
          "Destination point should be out of bounds on the left side"),
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () ->
            testMapManager.setDestinationCoordinates(
              new Position(testMapManager.getWidth() + 1, 5)),
          "Destination point should be out of bounds on the right side"),
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () -> testMapManager.setDestinationCoordinates(new Position(5, -1)),
          "Destination point should be out of bounds on the top side"),
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () ->
            testMapManager.setDestinationCoordinates(
              new Position(5, testMapManager.getHeight() + 1)),
          "Destination point should be out of bounds on the bottom side"));
  }

  @Test
  @DisplayName("Tries to set the start point onto the destination point")
  public void setDestinationCoordinates_occupiedPosition() {
    assertThrows(
      OccupiedPositionException.class,
      () -> testMapManager.setDestinationCoordinates(MapManager.DEFAULT_START_POSITION),
      "Expected an exception when placing the destination point");
  }

  @Test
  @DisplayName("Pull the terrain at specific coordinates in bounds")
  public void getTerrainAt_inBounds() throws PositionOutOfBounds {
    int xPos = 5;
    int yPos = 5;
    assertEquals(TerrainType.DIRT, testMapManager.getTerrainAt(xPos, yPos).getType(),
      "The expected terrain Dirt was not found");
    testMapManager.createTerrain(TerrainType.SWAMP, new Position(xPos, yPos));
    assertEquals(TerrainType.SWAMP, testMapManager.getTerrainAt(xPos, yPos).getType(),
      "The expected terrain SWAMP was not found");
  }

  @Test
  @DisplayName("Tries to get terrain at a position out of bounds")
  public void getTerrainAt_outOfBounds() throws PositionOutOfBounds {
    int inBounds = 5;
    int negativOutOfBounds = -1;
    int positivOutOfBounds = 15;
    assertAll(
      () ->
        assertThrows(
          PositionOutOfBounds.class,
          () -> testMapManager.getTerrainAt(inBounds, negativOutOfBounds),
          "Expected an exception when looking for terrain with the x coordinate out of bounds to " +
            "the left"),
      () -> assertThrows(
        PositionOutOfBounds.class,
        () -> testMapManager.getTerrainAt(inBounds, positivOutOfBounds),
        "Expected an exception when looking for terrain with the x coordinate out of bounds to " +
          "the right"),
      () -> assertThrows(
        PositionOutOfBounds.class,
        () -> testMapManager.getTerrainAt(negativOutOfBounds, inBounds),
        "Expected an exception when looking for terrain with the y coordinate out of bounds to " +
          "the top"),
      () -> assertThrows(
        PositionOutOfBounds.class,
        () -> testMapManager.getTerrainAt(positivOutOfBounds, inBounds),
        "Expected an exception when looking for terrain with the y coordinate out of bounds to " +
          "the bottom")
    );
  }
}
