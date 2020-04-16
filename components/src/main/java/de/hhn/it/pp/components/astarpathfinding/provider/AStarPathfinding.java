package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.InvalidStateException;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AStarPathfinding implements PathfindingService {

  private final int MAX_ROWS_COUNT = 30;
  private final int MAX_COL_COUNT = 30;
  private final Cell[][] grid = new Cell[MAX_ROWS_COUNT][MAX_COL_COUNT];

  private final List<Cell> openList = new ArrayList<>();
  private final List<Cell> closedList = new ArrayList<>();

  private Point startCoordinates = new Point(15, 8);
  private Point destinationCoordinates = new Point(15, 18);

  public AStarPathfinding() {
    createDefaultInitialization();
  }

  /** Initializes the grid with the default cells. */
  private void createDefaultInitialization() {
    for (int row = 0; row < MAX_ROWS_COUNT; row++) {
      for (int col = 0; col < MAX_COL_COUNT; col++) {
        grid[row][col] = new Cell(row, col);
      }
    }
  }

  /**
   * Calculates the shortest path on the grid from the start point to the end point by using the A*
   * search algorithm.
   */
  private void findPath() {
    // Add the start cell to the open list
    openList.add(grid[startCoordinates.x][startCoordinates.y]);

    while (!openList.isEmpty()) {
      Cell currentCell = getCellWithLowestFCost();
      assert currentCell != null;

      openList.remove(currentCell);
      closedList.add(currentCell);

      // Check whether the algorithm reached the destination cell
      if (currentCell.equals(grid[destinationCoordinates.x][destinationCoordinates.y])) {
        tracePath(grid[startCoordinates.x][startCoordinates.y], currentCell);
        return;
      }

      // Add neighbours to possible path if they are accessible i.e. no obstacle.
      for (Cell neighbour : getNeighbours(currentCell)) {
        if (!neighbour.isAccessible() || closedList.contains(neighbour)) {
          continue;
        }

        // Update costs of the neighbour if a shorter path was found
        int newCostToNeighbour = currentCell.getGCost() + getMDistance(currentCell, neighbour);
        if (newCostToNeighbour < neighbour.getGCost() || !openList.contains(neighbour)) {
          neighbour.setGCost(newCostToNeighbour);
          neighbour.setHCost(
              getMDistance(neighbour, grid[destinationCoordinates.x][destinationCoordinates.y]));
          neighbour.setParent(currentCell);

          if (!openList.contains(neighbour)) {
            openList.add(neighbour);
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

  public static void main(String[] args) {
    AStarPathfinding impl = new AStarPathfinding();
    impl.findPath();
  }

  /**
   * Searches the list of open cells for the cell with the lowest f cost and returns it.
   *
   * @return cell with the lowest f cost.
   */
  private Cell getCellWithLowestFCost() {
    if (!openList.isEmpty()) {
      return openList.stream().min(Comparator.comparing(Cell::calculateFCost)).get();
    } else {
      return null;
    }
  }

  @Override
  public void setStartPoint(Position position)
      throws IllegalParameterException, InvalidStateException {

  }

  @Override
  public void setEndPoint(Position position)
      throws IllegalParameterException, InvalidStateException {

}

  @Override
  public void placeObstacle(Position position)
      throws IllegalParameterException, InvalidStateException {

  }

  @Override
  public boolean startPathfinding() throws InvalidStateException {

    return false;
  }

  @Override
  public boolean stopPathfinding() throws InvalidStateException {

    return false;
  }

  @Override
  public void reset() {}

  @Override
  public String toString() {
    // TODO
    return super.toString();
  }
}
