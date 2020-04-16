package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.Position;

public class Cell {
  /**
   * The movement cost to move from the starting point to a given square on the grid, following the
   * path generated to get there. (Distance from starting cell)
   */
  private int g;

  /**
   * The estimated movement cost to move from that given square on the grid to the final
   * destination. (Distance from the end cell)
   */
  private int h;

  /** Determines whether the cell is blocked for pathing */
  private boolean isAccessible;

  private Position position;
  private int gridRow;
  private int gridCol;

  /** The neighbour with the lowest f value */
  private Cell parent;

  private Cell() {}

  public Cell(int gridRow, int gridCol) {
    super();
    isAccessible = true;
    this.position = new Position(gridRow, gridCol);
    this.gridRow = gridRow;
    this.gridCol = gridCol;
  }

  /**
   * Calculates the sum of g and h.
   *
   * @return the sum of g and h.
   */
  public int calculateFCost() {
    return g + h;
  }

  public boolean isAccessible() {
    return isAccessible;
  }

  public void setAccessible(boolean accessible) {
    isAccessible = accessible;
  }

  public int getGCost() {
    return g;
  }

  public void setGCost(int g) {
    this.g = g;
  }

  public void setHCost(int h) {
    this.h = h;
  }

  public int getGridRow() {
    return gridRow;
  }

  public int getGridCol() {
    return gridCol;
  }

  public Cell getParent() {
    return parent;
  }

  public void setParent(Cell parent) {
    this.parent = parent;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Cell{" + "gridRow=" + gridRow + ", gridCol=" + gridCol + '}';
  }
}
