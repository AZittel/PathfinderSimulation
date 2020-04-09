package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.provider.AStarPathfinding;
import java.awt.Point;

public class DemoAStarUsage {
  private static final org.slf4j.Logger logger =
    org.slf4j.LoggerFactory.getLogger(DemoAStarUsage.class);

  public static void main(String[] args) throws Exception {
    // Create the service
    logger.info(">>> create service");
    AStarService service = new AStarPathfinding();
    logger.info("" + service);

    // Add start point
    logger.info(">>> add start point");
    Point start = new Point(0, 3);
    service.setStartPoint(start);
    logger.info("" + service);

    Thread.sleep(1500);

    // Add end point
    logger.info(">>> add end point");
    Point end = new Point(5, 3);
    service.setEndPoint(end);
    logger.info("" + service);

    Thread.sleep(1500);

    // Add Obstacles
    for (int y = 2; y <= 4; y++) {
      logger.info(">>> add obstacle");
      Point obstacle = new Point(3, y);
      service.placeObstacle(obstacle);
    }
    logger.info("" + service);

    Thread.sleep(1500);

    // Start visualization
    logger.info(">>> visualization started");
    service.startVisualization();
    logger.info("" + service);

    Thread.sleep(2500);

    // End visualization
    logger.info(">>> visualization stopped");
    service.stopVisualization();
    logger.info("" + service);

    Thread.sleep(1500);

    // Reset
    logger.info(">>> reset");
    service.reset();
    logger.info("" + service);



  }


}
