package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.AStarService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;
import java.awt.Point;

public class AStarPathfinding implements AStarService {

  @Override
  public boolean setStartPoint(Point position) throws IllegalParameterException, InvalidStateException {

    return false;
  }

  @Override
  public boolean setEndPoint(Point position) throws IllegalParameterException, InvalidStateException {

    return false;
  }

  @Override
  public boolean placeObstacle(Point position) throws IllegalParameterException, InvalidStateException {

    return false;
  }

  @Override
  public boolean startVisualization() throws InvalidStateException{

    return false;
  }

  @Override
  public boolean stopVisualization() throws InvalidStateException {

    return false;
  }

  @Override
  public void reset() {

  }

  @Override
  public String toString() {
    //TODO
    return super.toString();
  }
}
