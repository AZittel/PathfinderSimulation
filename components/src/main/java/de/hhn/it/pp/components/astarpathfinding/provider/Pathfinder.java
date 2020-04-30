package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.PathfindingService;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import java.util.List;

public final class Pathfinder implements PathfindingService {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(Pathfinder.class);

  private MapManager manager = new MapManager();

  @Override
  public void createMap(int width, int height) throws IllegalParameterException {
    logger.info("createMap: width = {} height = {}", width, height);
    manager.createMap(width, height);
  }

  @Override
  public void setStartPoint(Position position)
      throws IllegalParameterException, OccupiedPositionException {
    logger.info("setStartPoint: position = {}", position.toString());
    // Check map boundaries
    manager.checkPositionInBounds(position);

    // Check occupied position
    if (manager.getDestinationCoordinates().equals(position)) {
      throw new OccupiedPositionException(
          "The start point cannot be placed on the destination point");
    }
    manager.setStartCoordinates(position);
  }

  @Override
  public void setEndPoint(Position position)
      throws IllegalParameterException, OccupiedPositionException {
    logger.info("setEndPoint: position = {}", position.toString());
    // Check map boundaries
    manager.checkPositionInBounds(position);

    // Check occupied position
    if (manager.getStartCoordinates().equals(position)) {
      throw new OccupiedPositionException(
          "The destination point cannot be placed on the start point");
    }
    manager.setDestinationCoordinates(position);
  }

  @Override
  public void placeTerrain(TerrainType type, Position position) throws IllegalParameterException {
    logger.info("placeTerrain: type = {}, position = {} ", type, position.toString());
    // Check map boundaries
    manager.checkPositionInBounds(position);
    manager.createTerrain(type, position);
  }

  @Override
  public List<PathfindingInformation> doPathfinding() {
    return null;
  }

  @Override
  public void reset() {}

  @Override
  public void changeTerrainTypeFactor(TerrainType type, double modifier)
      throws IllegalParameterException {
    logger.info("changeTerrainTypeFactor: type = {}, modifier = {} ", type, modifier);
    // Check the range of the modifier
    if (modifier < TerrainType.MIN_VALUE) {
      throw new IllegalParameterException(
          String.format(
              "Invalid modifier value! Modifier must not be lower than %f!",
              TerrainType.MIN_VALUE));
    } else if (modifier > TerrainType.MAX_VALUE) {
      throw new IllegalParameterException(
          String.format(
              "Invalid modifier value! Modifier must not be greater than %f!",
              TerrainType.MAX_VALUE));
    }
    type.setModifier(modifier);
  }

  @Override
  public String toString() {
    return "Pathfinder"; // TODO:
  }
}
