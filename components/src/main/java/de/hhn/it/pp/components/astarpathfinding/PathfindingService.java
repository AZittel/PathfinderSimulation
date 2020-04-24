package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;
import java.util.ArrayList;

/**
 * This Service is an interface for a pathfinding simulator that provides all the functionality to
 * interact with the simulator.
 */
public interface PathfindingService {

  /**
   * Creates the map with the given length and height.
   *
   * @param width the width of the map, must higher then 0
   * @param height the height of the map, must higher then 0
   * @throws IllegalParameterException if either the width or the height is invalid
   */
  void createMap(int width, int height) throws IllegalParameterException;

  /**
   * Sets the start point for the pathfinding algorithm.
   *
   * @param position position on the grid
   * @throws IllegalParameterException if the position is invalid
   * @throws OccupiedPositionException thrown when start point is equal to the end point
   */
  void setStartPoint(Position position) throws IllegalParameterException, OccupiedPositionException;

  /**
   * Sets the end point for the pathfinding algorithm.
   *
   * @param position position on the grid
   * @throws IllegalParameterException if the position is invalid
   * @throws OccupiedPositionException thrown when end point is equal to the start point
   */
  void setEndPoint(Position position) throws IllegalParameterException, OccupiedPositionException;

  /**
   * Sets an terrain tile at its set position on the map.
   *
   * @param tile terrain object placed at its position
   * @throws IllegalParameterException if the position is invalid
   */
  void placeTerrain(Terrain tile) throws IllegalParameterException;

  /**
   * Starts the visualization of the pathfinding algorithm.
   *
   * @return the list of all pathfinding algorithm calculations
   */
  ArrayList<PathfindingInformation> startPathfinding();

  /**
   * Stops the visualization of the pathfinding algorithm.
   *
   * @throws InvalidStateException when trying to stop the visualization while the simulation is not
   *     running
   */
  void stopPathfinding() throws InvalidStateException; // TODO check if the method is necessary

  /**
   * Stops the visualization if it is running and resets the start and end point and removes the
   * obstacles on the grid.
   */
  void reset();
}
