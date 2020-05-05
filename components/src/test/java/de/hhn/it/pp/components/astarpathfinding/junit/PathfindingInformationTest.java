package de.hhn.it.pp.components.astarpathfinding.junit;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PathfindingInformationTest {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(PathfindingInformationTest.class);

  @Test
  @DisplayName("Creates a deep copy of the PathfindingInformation object.")
  public void clone_newClonedInformation() throws CloneNotSupportedException {
    PathfindingInformation information = new PathfindingInformation();
    List<Terrain> specificPositions = new ArrayList<>();
    List<Terrain> visitedPositions = new ArrayList<>();
    List<Terrain> finalPathPositions = new ArrayList<>();

    specificPositions.add(new Terrain(1,1, TerrainType.WATER));
    specificPositions.add(new Terrain(2,1, TerrainType.WATER));
    specificPositions.add(new Terrain(3,1, TerrainType.WATER));

    visitedPositions.add(new Terrain(2,5, TerrainType.GRASS));
    visitedPositions.add(new Terrain(2,6, TerrainType.GRASS));
    visitedPositions.add(new Terrain(3,6, TerrainType.DIRT));
    visitedPositions.add(new Terrain(4,6, TerrainType.DIRT));

    finalPathPositions.add(new Terrain(2,6, TerrainType.GRASS));
    finalPathPositions.add(new Terrain(3,6, TerrainType.DIRT));
    finalPathPositions.add(new Terrain(4,6, TerrainType.DIRT));

    information.setSpecificPositions(specificPositions);
    information.setVisitedPositions(visitedPositions);
    information.setFinalPathPositions(finalPathPositions);

    PathfindingInformation clone = information.clone();
  }

}
