package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;
import java.util.ArrayList;
import java.util.List;

/** Representation of an object which holds information about pathfinding algorithms. */
public class PathfindingInformation implements Cloneable {

  /** List of positions specific to algorithms. */
  private List<Terrain> specificPositions = new ArrayList<>();

  /** List of positions a pathfinding algorithm did visit. */
  private List<Terrain> visitedPositions = new ArrayList<>();

  /** List of positions of the final and shortest path. */
  private List<Terrain> finalPathPositions = new ArrayList<>();

  public PathfindingInformation() {}

  public List<Terrain> getSpecificPositions() {
    return specificPositions;
  }

  public void setSpecificPositions(List<Terrain> specificPositions) {
    this.specificPositions = specificPositions;
  }

  public List<Terrain> getVisitedPositions() {
    return visitedPositions;
  }

  public void setVisitedPositions(List<Terrain> visitedPositions) {
    this.visitedPositions = visitedPositions;
  }

  public List<Terrain> getFinalPathPositions() {
    return finalPathPositions;
  }

  public void setFinalPathPositions(List<Terrain> finalPathPositions) {
    this.finalPathPositions = finalPathPositions;
  }

  public void addVisitedPosition(Terrain visitedPosition) {
    this.visitedPositions.add(visitedPosition);
  }

  public void addSpecificPosition(Terrain specificPosition) {
    this.specificPositions.add(specificPosition);
  }

  public void reset() {
    specificPositions.clear();
    visitedPositions.clear();
    finalPathPositions.clear();
  }

  private List<Terrain> cloneList(List<Terrain> list) {
    List<Terrain> newList = new ArrayList<>();
    for (Terrain t : list) {
      try {
        newList.add((Terrain) t.clone());
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }
    return newList;
  }

  @Override
  public PathfindingInformation clone() throws CloneNotSupportedException {
    PathfindingInformation cloned = (PathfindingInformation) super.clone();
    cloned.setSpecificPositions(this.cloneList(this.specificPositions));
    cloned.setVisitedPositions(this.cloneList(this.visitedPositions));
    cloned.setFinalPathPositions(this.cloneList(this.finalPathPositions));
    return cloned;
  }
}
