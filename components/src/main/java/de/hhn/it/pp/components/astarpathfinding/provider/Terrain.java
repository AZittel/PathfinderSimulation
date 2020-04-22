package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.Position;

public class Terrain {
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

  /**
   * Factor to influence the difficulty to pass the terrain
   */
  private double obstacleFactor;

  /**
   * Position on the map.
   */
  private Position position;

  /**
   * The terrain type.
   */
  private TerrainType type;


  /**
   * The neighbour with the lowest f value
   */
  private Terrain parent;

  private Terrain() {
  }

  public Terrain(int gridRow, int gridCol, TerrainType type) {
    super();
    this.position = new Position(gridRow, gridCol);
    this.type = type;
    this.obstacleFactor = type.getDefaultFactor();
  }

  /**
   * Calculates the sum of g and h.
   *
   * @return the sum of g and h.
   */
  public int calculateFCost() {
    return g + h;
  }

  public double getObstacleFactor() {
    return obstacleFactor;
  }

  public void setObstacleFactor(double obstacleFactor) {
    this.obstacleFactor = obstacleFactor;
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

  public Terrain getParent() {
    return parent;
  }

  public void setParent(Terrain parent) {
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
    return
      position +"";

  }
}
