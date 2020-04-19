package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingListener;
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
  public void startPathfinding() throws InvalidStateException {

  }

  @Override
  public void stopPathfinding() throws InvalidStateException {

  }

  @Override
  public void reset() {}

  @Override
  public void addCallback(PathfindingListener listener) throws IllegalParameterException {

  }
}
