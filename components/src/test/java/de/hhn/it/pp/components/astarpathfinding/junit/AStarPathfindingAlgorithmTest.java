package de.hhn.it.pp.components.astarpathfinding.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds;
import de.hhn.it.pp.components.astarpathfinding.provider.AStarPathfindingAlgorithm;
import de.hhn.it.pp.components.astarpathfinding.provider.MapManager;
import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AStarPathfindingAlgorithmTest {
  private static final org.slf4j.Logger logger =
    org.slf4j.LoggerFactory.getLogger(AStarPathfindingAlgorithmTest.class);

  private MapManager testMapManager;
  private AStarPathfindingAlgorithm algorithm;

  @BeforeEach
  void setup() {
    testMapManager = new MapManager();
    algorithm = new AStarPathfindingAlgorithm(testMapManager);
  }

  @Test
  @DisplayName("Find the final and fastest path")
  public void doPathfinding_goodResult()
    throws PositionOutOfBounds, OccupiedPositionException, IllegalParameterException {
    Position start = new Position(2, 2);
    testMapManager.setStartCoordinates(start);
    Position end = new Position(2, 6);
    testMapManager.setDestinationCoordinates(end);
    testMapManager.createMap(7, 7);
    Terrain terrain2 = testMapManager.createTerrain(TerrainType.SWAMP, new Position(1, 4));
    Terrain terrain1 = testMapManager.createTerrain(TerrainType.LAVA, new Position(2, 4));
    Terrain terrain3 = testMapManager.createTerrain(TerrainType.SWAMP, new Position(3, 4));
    ArrayList<PathfindingInformation> result = algorithm.findPath();
    List<Terrain> finalPath = result.get(result.size() - 1).getFinalPathPositions();
    printMapWithFinalPath(finalPath);

    List<Terrain> expectedPath = new ArrayList<>();

    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(0, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(0, 4)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(0, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 6)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 6)));

    assertFalse(finalPath.isEmpty());
    assertEquals(expectedPath, finalPath, "The expected path is not the same as the actual path");

    Terrain terrain4 = testMapManager.createTerrain(TerrainType.WATER, new Position(1, 3));
    Terrain terrain5 = testMapManager.createTerrain(TerrainType.WATER, new Position(1, 4));
    Terrain terrain6 = testMapManager.createTerrain(TerrainType.WATER, new Position(1, 5));
    Terrain terrain7 = testMapManager.createTerrain(TerrainType.WATER, new Position(1, 6));

    result = algorithm.findPath();
    finalPath = result.get(result.size() - 1).getFinalPathPositions();
    printMapWithFinalPath(finalPath);

    expectedPath.clear();
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(3, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(4, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(4, 4)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(4, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(3, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(3, 6)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 6)));
    assertEquals(expectedPath, finalPath, "The expected path is not the same as the actual path");
  }

  @Test
  @DisplayName("Influence pathfinding with changed modifiers")
  public void doPathfinding_changedTerrainTypeModifier_GoodResult()
    throws OccupiedPositionException, PositionOutOfBounds, IllegalParameterException {
    Position start = new Position(2, 2);
    testMapManager.setStartCoordinates(start);
    Position end = new Position(2, 6);
    testMapManager.setDestinationCoordinates(end);
    testMapManager.createMap(7, 7);
    Terrain terrain2 = testMapManager.createTerrain(TerrainType.SWAMP, new Position(1, 4));
    Terrain terrain1 = testMapManager.createTerrain(TerrainType.LAVA, new Position(2, 4));
    Terrain terrain3 = testMapManager.createTerrain(TerrainType.SWAMP, new Position(3, 4));

    ArrayList<PathfindingInformation> result = algorithm.findPath();
    List<Terrain> finalPath = result.get(result.size() - 1).getFinalPathPositions();

    List<Terrain> expectedPath = new ArrayList<>();
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(0, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(0, 4)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(0, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 6)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 6)));

    printMapWithFinalPath(finalPath);
    assertFalse(finalPath.isEmpty());
    assertEquals(expectedPath, finalPath, "The expected path is not the same as the actual path");

    TerrainType.SWAMP.setModifier(20.0);
    result = algorithm.findPath();
    finalPath = result.get(result.size() - 1).getFinalPathPositions();
    expectedPath.clear();
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 4)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 6)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 6)));
    printMapWithFinalPath(finalPath);

    assertFalse(finalPath.isEmpty());
    assertEquals(expectedPath, finalPath, "The expected path is not the same as the actual path");
  }

  private void printMapWithFinalPath(List<Terrain> finalPath) {
    String red = "\033[38;2;255;178;4m";
    for (Terrain[] row : testMapManager.getMap()) {
      for (Terrain col : row) {
        boolean found = false;
        for (Terrain pathTer : finalPath) {
          if (col.equals(pathTer)) {
            System.out.print(String.format("\u001b[38;2;125;125;4m%s\u001b[0m", col + " | "));
            found = true;
            break;
          }
        }
        if (!found)
          System.out.print(col + " | ");
      }
      System.out.println();
    }
    System.out.println();
  }

  @Test
  @DisplayName("Try doPathfinding with no result")
  public void doPathfinding_startAndEndPosition_surroundedWithObstacle()
    throws OccupiedPositionException, PositionOutOfBounds {
    Position start = new Position(2, 2);
    testMapManager.setStartCoordinates(start);
    Position end = new Position(2, 6);
    testMapManager.setDestinationCoordinates(end);
    //Start point surrounded
    Terrain terrain2 = testMapManager.createTerrain(TerrainType.LAVA, new Position(1, 2));
    Terrain terrain1 = testMapManager.createTerrain(TerrainType.LAVA, new Position(2, 1));
    Terrain terrain3 = testMapManager.createTerrain(TerrainType.LAVA, new Position(2, 3));
    Terrain terrain4 = testMapManager.createTerrain(TerrainType.LAVA, new Position(3, 2));
    ArrayList<PathfindingInformation> result = algorithm.findPath();
    assertTrue(result.isEmpty());

    //End point surrounded
    testMapManager.reset();
    terrain2 = testMapManager.createTerrain(TerrainType.LAVA, new Position(1, 6));
    terrain1 = testMapManager.createTerrain(TerrainType.LAVA, new Position(3, 6));
    terrain3 = testMapManager.createTerrain(TerrainType.LAVA, new Position(2, 7));
    terrain4 = testMapManager.createTerrain(TerrainType.LAVA, new Position(2, 5));
    result = algorithm.findPath();
    assertTrue(result.isEmpty());
  }
}
