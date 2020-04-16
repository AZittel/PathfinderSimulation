package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;

/**
 * This Service is an interface for a pathfinding simulator that provides all the functionality to
 * interact with the simulator.
 */
public interface PathfindingService {

  /**
   * Sets the start point for the pathfinding algorithm.
   *
   * @param position position on the grid
   * @throws IllegalParameterException if the position is invalid
   * @throws InvalidStateException when trying to set the starting point during the visualization
   */
  void setStartPoint(Position position) throws IllegalParameterException, InvalidStateException;

  /**
   * Sets the end point for the pathfinding algorithm.
   *
   * @param position position on the grid
   * @throws IllegalParameterException if the position is invalid
   * @throws InvalidStateException when trying to set the end point during the visualization
   */
  void setEndPoint(Position position) throws IllegalParameterException, InvalidStateException;

  /**
   * Sets an obstacle at the given position.
   *
   * @param position position on the grid
   * @throws IllegalParameterException if the position is invalid
   * @throws InvalidStateException when trying to place an obstacle during the visualization
   */
  void placeObstacle(Position position) throws IllegalParameterException, InvalidStateException;

  /**
   * Starts the visualization of the pathfinding algorithm.
   *
   * @return whether starting the visualization was successful
   * @throws InvalidStateException when trying to start the visualization during the visualization
   */
  boolean startPathfinding() throws InvalidStateException;

  /**
   * Stops the visualization of the pathfinding algorithm.
   *
   * @return whether stopping the visualization was successful
   * @throws InvalidStateException when trying to stop the visualization while the simulation is not
   *     running
   */
  boolean stopPathfinding() throws InvalidStateException;

  /**
   * Stops the visualization if it is running and resets the start and end point and removes the
   * obstacles on the grid.
   */
  void reset();
}
