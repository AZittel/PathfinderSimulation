package de.hhn.it.pp.components.astarpathfinding.simulator;

import java.awt.Point;

/**
 * This Service is an interface for a pathfinding simulator that provides all the
 * functionality to interact with the simulator.
 */
public interface AStarService {

  /**
   * Sets the start point for the pathfinding algorithm
   *
   * @param position position on the grid
   * @throws IllegalArgumentException if the position is invalid
   */
  void setStartPoint(Point position) throws IllegalArgumentException;

  /**
   * Sets the end point for the pathfinding algorithm
   *
   * @param position position on the grid
   * @throws IllegalArgumentException if the position is invalid
   */
  void setEndPoint(Point position)throws IllegalArgumentException;

  /**
   * Sets an obstacle at the given position
   *
   * @param position position on the grid
   * @throws IllegalArgumentException if the position is invalid
   */
  void placeObstacle(Point position)throws IllegalArgumentException;

  /**
   * Starts the visualization of the pathfinding algorithm
   */
  void startVisualization();

  /**
   * Stops the visualization of the pathfinding algorithm
   */
  void stopVisualization();

  /**
   * Resets the start and end point and removes the obstacles on the grid
   */
  void reset();


}
