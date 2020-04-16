package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.provider.Cell;
import java.util.ArrayList;
import java.util.List;

/** Representation of an object which holds information about pathfinding algorithms. */
public class PathfindingInformation {

  /** List of positions specific to algorithms. */
  private List<Cell> specificPositions = new ArrayList<>();

  /** List of positions a pathfinding algorithm did visit. */
  private List<Cell> visitedPositions = new ArrayList<>();

  /** List of positions of the final and shortest path. */
  private List<Cell> finalPathPositions = new ArrayList<>();

  public List<Cell> getSpecificPositions() {
    return specificPositions;
  }

  public void setSpecificPositions(List<Cell> specificPositions) {
    this.specificPositions = specificPositions;
  }

  public List<Cell> getVisitedPositions() {
    return visitedPositions;
  }

  public void setVisitedPositions(List<Cell> visitedPositions) {
    this.visitedPositions = visitedPositions;
  }

  public List<Cell> getFinalPathPositions() {
    return finalPathPositions;
  }

  public void setFinalPathPositions(List<Cell> finalPathPositions) {
    this.finalPathPositions = finalPathPositions;
  }

  public void addVisitedPosition(Cell visitedPosition) {
    this.visitedPositions.add(visitedPosition);
  }

  public void addSpecificPosition(Cell specificPosition) {
    this.specificPositions.add(specificPosition);
  }

  public void reset() {
    specificPositions.clear();
    visitedPositions.clear();
    finalPathPositions.clear();
  }
}
