package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingService;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;

public final class Pathfinder implements PathfindingService {
  AbstractPathfindingAlgorithm algorithm = new AStarPathfindingAlgorithm();

  @Override
  public void setStartPoint(Position position)
      throws IllegalParameterException, InvalidStateException {}

  @Override
  public void setEndPoint(Position position)
      throws IllegalParameterException, InvalidStateException {}

  @Override
  public void placeObstacle(Position position)
      throws IllegalParameterException, InvalidStateException {}

  @Override
  public boolean startPathfinding() throws InvalidStateException {
    return false;
  }

  @Override
  public boolean stopPathfinding() throws InvalidStateException {
    return false;
  }

  @Override
  public void reset() {}
}
