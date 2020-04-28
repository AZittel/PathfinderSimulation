package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.astarpathfinding.provider.TerrainType;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import java.util.List;

/**
 * This Service is an interface for a pathfinding simulator that provides all the functionality to
 * interact with the simulator.
 */
public interface PathfindingService {

  /**
   * Creates the map with the given length and height.
   *
   * @param width  the width of the map, must higher then 0
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
   * Places a terrain of the given type on the given position.
   *
   * @param type     the type defining the terrain
   * @param position the position on the map
   * @throws IllegalParameterException if the position is invalid
   */
  void placeTerrain(TerrainType type, Position position) throws IllegalParameterException;

  /**
   * Starts the visualization of the pathfinding algorithm.
   *
   * @return the list of all pathfinding algorithm calculations
   */
  List<PathfindingInformation> doPathfinding();

  /**
   * Stops the visualization if it is running and resets the start and end point and removes the
   * obstacles on the grid.
   */
  void reset();
}
