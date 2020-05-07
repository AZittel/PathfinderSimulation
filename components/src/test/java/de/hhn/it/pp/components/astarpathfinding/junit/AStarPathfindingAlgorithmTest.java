package de.hhn.it.pp.components.astarpathfinding.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
    List<Terrain> expectedPath = new ArrayList<>();
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 3)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 4)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 5)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(1, 6)));
    expectedPath.add(testMapManager.getTerrainAt(new Position(2, 6)));

    assertFalse(finalPath.isEmpty());
    for (int i = 0; i < finalPath.size(); i++) {
      assertEquals(expectedPath.get(i), finalPath.get(i),
        "The expected path is not the same as the actual path");
    }

//    for (Terrain[] row : testMapManager.getMap()) {
//      for (Terrain col : row) {
//        System.out.print(col + " | ");
//      }
//      System.out.println();
//    }
//
//    System.out.println(finalPath);

  }


  @Test
  @DisplayName("Try doPathfinding with no result")
  public void doPathfinding_noFinalPath() {


  }


}
