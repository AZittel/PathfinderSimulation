package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.PathfindingService;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;
import java.util.ArrayList;

public final class Pathfinder implements PathfindingService {
  private MapManager manager = new MapManager();

  @Override
  public void createMap(int width, int height) throws IllegalParameterException {
    manager.createMap(width, height);
  }

  @Override
  public void setStartPoint(Position position)
      throws IllegalParameterException, OccupiedPositionException {}

  @Override
  public void setEndPoint(Position position)
      throws IllegalParameterException, OccupiedPositionException {}

  @Override
  public void placeTerrain(Terrain tile) throws IllegalParameterException {}

  @Override
  public ArrayList<PathfindingInformation> startPathfinding() {
    return null;
  }

  @Override
  public void stopPathfinding() throws InvalidStateException {}

  @Override
  public void reset() {}
}
