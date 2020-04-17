package de.hhn.it.pp.components.astarpathfinding.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AStarPathfindingAlgorithm extends AbstractPathfindingAlgorithm {

  @Override
  protected void findPath() {
    // Add the start cell to the open list
    information.addSpecificPosition(grid[startCoordinates.getX()][startCoordinates.getY()]);

    while (!information.getSpecificPositions().isEmpty()) {
      Cell currentCell = getCellWithLowestFCost();
      assert currentCell != null;

      information.getSpecificPositions().remove(currentCell);
      information.getVisitedPositions().add(currentCell);

      // Check whether the algorithm reached the destination cell
      if (currentCell.equals(grid[destinationCoordinates.getX()][destinationCoordinates.getY()])) {
        tracePath(grid[startCoordinates.getX()][startCoordinates.getY()], currentCell);
        return;
      }

      // Add neighbours to possible path if they are accessible i.e. no obstacle.
      for (Cell neighbour : getNeighbours(currentCell)) {
        if (!neighbour.isAccessible() || information.getVisitedPositions().contains(neighbour)) {
          continue;
        }

        // Update costs of the neighbour if a shorter path was found
        int newCostToNeighbour = currentCell.getGCost() + getMDistance(currentCell, neighbour);
        if (newCostToNeighbour < neighbour.getGCost()
            || !information.getSpecificPositions().contains(neighbour)) {
          neighbour.setGCost(newCostToNeighbour);
          neighbour.setHCost(
              getMDistance(
                  neighbour, grid[destinationCoordinates.getX()][destinationCoordinates.getY()]));
          neighbour.setParent(currentCell);

          if (!information.getSpecificPositions().contains(neighbour)) {
            information.getSpecificPositions().add(neighbour);
          }
        }
      }
    }
  }

  /**
   * Backtrack the shortest path from the destination cell to the first cell after the start cell.
   *
   * @param startCell start point in the grid
   * @param endCell destination in the grid
   */
  private void tracePath(Cell startCell, Cell endCell) {
    List<Cell> path = new ArrayList<>();
    Cell currentCell = endCell;

    while (currentCell != startCell) {
      path.add(currentCell);
      currentCell = currentCell.getParent();
    }

    Collections.reverse(path);
    System.out.println(path);
  }

  /**
   * Calculates the approximation heuristics (Manhattan Distance).
   *
   * @param cellA from
   * @param cellB to
   * @return approximation distance between two cells
   */
  private int getMDistance(Cell cellA, Cell cellB) {
    return Math.abs(cellA.getGridRow() - cellB.getGridRow())
        + Math.abs(cellA.getGridCol() - cellB.getGridCol());
  }

  /**
   * Looks for all available horizontal and vertical neighbours of the given cell in the grid and
   * returns them as an array of cells.
   *
   * @param cell the cell from which the neighbours are to be determined
   * @return an array of cells which are neighbours of the given cell
   */
  private Cell[] getNeighbours(Cell cell) {
    // We currently have a maximum of 4 neighbours, possibly even less.
    Cell[] neighbours = new Cell[4];

    // Left neighbour
    if (cell.getGridRow() - 1 >= 0) {
      neighbours[0] = grid[cell.getGridRow() - 1][cell.getGridCol()];
    }

    // Right neighbour
    if (cell.getGridRow() + 1 <= grid.length) {
      neighbours[1] = grid[cell.getGridRow() + 1][cell.getGridCol()];
    }

    // Top neighbour
    if (cell.getGridCol() - 1 >= 0) {
      neighbours[2] = grid[cell.getGridRow()][cell.getGridCol() - 1];
    }

    // Bottom neighbour
    if (cell.getGridCol() + 1 <= grid[cell.getGridRow()].length) {
      neighbours[3] = grid[cell.getGridRow()][cell.getGridCol() + 1];
    }

    return neighbours;
  }

  /**
   * Searches the list of open cells for the cell with the lowest f cost and returns it.
   *
   * @return cell with the lowest f cost.
   */
  private Cell getCellWithLowestFCost() {
    if (!information.getSpecificPositions().isEmpty()) {
      return information.getSpecificPositions().stream()
          .min(Comparator.comparing(Cell::calculateFCost))
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
