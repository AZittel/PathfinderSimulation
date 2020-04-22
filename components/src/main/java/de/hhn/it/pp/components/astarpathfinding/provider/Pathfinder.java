package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.PathfindingService;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;
import java.util.ArrayList;


public final class Pathfinder implements PathfindingService {
  static MapManager manager = new MapManager();

  public static void main(String[] args) {
    manager.createMap(20, 20);
    AStarPathfindingAlgorithm algorithm = new AStarPathfindingAlgorithm(new Position(5, 5), new Position(7, 10), manager.getMap());
    algorithm.findPath();

    System.out.println(algorithm.getResult().size());

  }

  @Override
  public void createMap(int width, int height) throws IllegalParameterException, InvalidStateException {

  }

  @Override
  public void setStartPoint(Position position)
    throws IllegalParameterException, InvalidStateException {
  }

  @Override
  public void setEndPoint(Position position)
    throws IllegalParameterException, InvalidStateException {
  }

  @Override
  public void placeObstacle(Position position)
    throws IllegalParameterException, InvalidStateException {
  }

  @Override
  public ArrayList<PathfindingInformation> startPathfinding() throws InvalidStateException {
    return null;
  }

  @Override
  public void stopPathfinding() throws InvalidStateException {

  }

  @Override
  public void reset() {
  }


}
