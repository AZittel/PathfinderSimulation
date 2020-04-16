package de.hhn.it.pp.components.astarpathfinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of an object which holds information about pathfinding algorithms.
 */
public class PathfindingInformation {

  /**
   * List of positions specific to algorithms.
   */
  private List<Position> specificPositions = new ArrayList<>();

  /**
   * List of positions a pathfinding algorithm did visit.
   */
  private List<Position> visitedPositions = new ArrayList<>();

  /**
   * List of positions of the final and shortest path
   */
  private List<Position> finalPathPositions = new ArrayList<>();


}
