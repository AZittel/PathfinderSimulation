package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AStarPathfindingAlgorithm {

  private ArrayList<PathfindingInformation> result = new ArrayList<>();

  private Position startCoordinates;
  private Position destinationCoordinates;
  private Terrain[][] map;

  /**
   * Constructor.
   *
   * @param startCoordinates the
   * @param destinationCoordinates the
   * @param map the
   */
  public AStarPathfindingAlgorithm(
      Position startCoordinates, Position destinationCoordinates, Terrain[][] map) {
    this.startCoordinates = startCoordinates;
    this.destinationCoordinates = destinationCoordinates;
    this.map = map;
  }

  public ArrayList<PathfindingInformation> findPath() {
    PathfindingInformation information = new PathfindingInformation();
    // Add the start cell to the open list
    information.addSpecificPosition(map[startCoordinates.getX()][startCoordinates.getY()]);

    while (!information.getSpecificPositions().isEmpty()) {
      Terrain currentTerrain = getCellWithLowestFCost(information);
      assert currentTerrain != null;

      information.getSpecificPositions().remove(currentTerrain);
      information.getVisitedPositions().add(currentTerrain);

      // Check whether the algorithm reached the destination cell
      if (currentTerrain.equals(
          map[destinationCoordinates.getX()][destinationCoordinates.getY()])) {
        information.setFinalPathPositions(
            tracePath(map[startCoordinates.getX()][startCoordinates.getY()], currentTerrain));
        result.add(information);
        return result;
      }

      // Add neighbours to possible path if they are accessible i.e. no obstacle.
      for (Terrain neighbour : getNeighbours(currentTerrain)) {
        if (neighbour.getObstacleFactor() >= 1
            || information.getVisitedPositions().contains(neighbour)) {
          continue;
        }

        // Update costs of the neighbour if a shorter path was found
        int newCostToNeighbour =
            currentTerrain.getGCost()
                + (int)
                    ((getMDistance(currentTerrain, neighbour))
                        * (1 + currentTerrain.getObstacleFactor()));
        if (newCostToNeighbour < neighbour.getGCost()
            || !information.getSpecificPositions().contains(neighbour)) {
          neighbour.setGCost(newCostToNeighbour);
          neighbour.setHCost(
              getMDistance(
                  neighbour, map[destinationCoordinates.getX()][destinationCoordinates.getY()]));
          neighbour.setParent(currentTerrain);

          if (!information.getSpecificPositions().contains(neighbour)) {
            information.getSpecificPositions().add(neighbour);
          }
        }
      }

      try {
        result.add(information.clone());
      } catch (CloneNotSupportedException e) {
        e.printStackTrace();
      }
    }

    // TODO handle no valid path found
    return new ArrayList<>();
  }

  /**
   * Backtrack the shortest path from the destination cell to the first cell after the start cell.
   *
   * @param startTerrain start point in the grid
   * @param endTerrain destination in the grid
   * @return the final path.
   */
  private List<Terrain> tracePath(Terrain startTerrain, Terrain endTerrain) {
    List<Terrain> path = new ArrayList<>();
    Terrain currentTerrain = endTerrain;

    while (currentTerrain != startTerrain) {
      path.add(currentTerrain);
      currentTerrain = currentTerrain.getParent();
    }

    Collections.reverse(path);
    System.out.println(path);
    return path;
  }

  /**
   * Calculates the approximation heuristics (Manhattan Distance).
   *
   * @param terrainA from
   * @param terrainB to
   * @return approximation distance between two cells
   */
  private int getMDistance(Terrain terrainA, Terrain terrainB) {
    return Math.abs(terrainA.getPosition().getX() - terrainB.getPosition().getX())
        + Math.abs(terrainA.getPosition().getY() - terrainB.getPosition().getY());
  }

  /**
   * Looks for all available horizontal and vertical neighbours of the given cell in the grid and
   * returns them as an array of cells.
   *
   * @param terrain the cell from which the neighbours are to be determined
   * @return an array of cells which are neighbours of the given cell
   */
  private Terrain[] getNeighbours(Terrain terrain) {
    // We currently have a maximum of 4 neighbours, possibly even less.
    Terrain[] neighbours = new Terrain[4];

    // Left neighbour
    if (terrain.getPosition().getX() - 1 >= 0) {
      neighbours[0] = map[terrain.getPosition().getX() - 1][terrain.getPosition().getY()];
    }

    // Right neighbour
    if (terrain.getPosition().getX() + 1 <= map.length) {
      neighbours[1] = map[terrain.getPosition().getX() + 1][terrain.getPosition().getY()];
    }

    // Top neighbour
    if (terrain.getPosition().getY() - 1 >= 0) {
      neighbours[2] = map[terrain.getPosition().getX()][terrain.getPosition().getY() - 1];
    }

    // Bottom neighbour
    if (terrain.getPosition().getY() + 1 <= map[terrain.getPosition().getX()].length) {
      neighbours[3] = map[terrain.getPosition().getX()][terrain.getPosition().getY() + 1];
    }

    return neighbours;
  }

  /**
   * Searches the list of open cells for the cell with the lowest f cost and returns it.
   *
   * @return cell with the lowest f cost.
   */
  private Terrain getCellWithLowestFCost(PathfindingInformation information) {
    if (!information.getSpecificPositions().isEmpty()) {
      return information.getSpecificPositions().stream()
          .min(Comparator.comparing(Terrain::calculateFCost))
          .get();
    } else {
      return null;
    }
  }

  @Override
  public String toString() {
    // TODO
    return super.toString();
  }
}
