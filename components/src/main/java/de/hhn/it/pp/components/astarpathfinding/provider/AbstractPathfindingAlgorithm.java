package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.Position;

public abstract class AbstractPathfindingAlgorithm {
  protected final int MAX_ROWS_COUNT = 30;
  protected final int MAX_COL_COUNT = 30;
  protected final Cell[][] grid = new Cell[MAX_ROWS_COUNT][MAX_COL_COUNT];
  protected final PathfindingInformation information = new PathfindingInformation();

  protected Position startCoordinates = new Position(15, 8);
  protected Position destinationCoordinates = new Position(15, 18);

  public AbstractPathfindingAlgorithm() {
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
  protected abstract void findPath();
}
