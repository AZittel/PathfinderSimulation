package de.hhn.it.pp.components.astarpathfinding.junit;

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
    testManager.createMap(5, 5);
    Terrain[][] map = testManager.getMap();

  }
}
