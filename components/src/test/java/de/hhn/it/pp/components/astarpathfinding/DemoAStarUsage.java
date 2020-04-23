package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.provider.Pathfinder;
import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import de.hhn.it.pp.components.astarpathfinding.provider.TerrainType;

public class DemoAStarUsage {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(DemoAStarUsage.class);




  public static void main(String[] args) throws Exception {
    // Create the service
    logger.info(">>> create service");
    Pathfinder service = new Pathfinder();
    logger.info("" + service);

    // Add start point
    logger.info(">>> add start point");
    Position start = new Position(0, 3);
    service.setStartPoint(start);
    logger.info("" + service);

    Thread.sleep(1500);

    // Add end point
    logger.info(">>> add end point");
    Position end = new Position(5, 3);
    service.setEndPoint(end);
    logger.info("" + service);

    Thread.sleep(1500);

    // Add Obstacles
    for (int y = 2; y <= 4; y++) {
      logger.info(">>> add obstacle at: " + 3 + "|" + y);
      Terrain terrain = new Terrain(3, y, TerrainType.WATER);
      service.placeTerrain(terrain);
    }
    logger.info("" + service);

    Thread.sleep(1500);

    // Start visualization
    logger.info(">>> visualization started");
    service.startPathfinding();
    logger.info("" + service);

    Thread.sleep(2500);

    // End visualization
    logger.info(">>> visualization stopped");
    service.stopPathfinding();
    logger.info("" + service);

    Thread.sleep(1500);

    // Reset
    logger.info(">>> reset");
    service.reset();
    logger.info("" + service);
  }
}
