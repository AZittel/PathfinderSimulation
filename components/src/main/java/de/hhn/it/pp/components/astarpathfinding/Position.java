package de.hhn.it.pp.components.astarpathfinding;

import de.hhn.it.pp.components.astarpathfinding.provider.Terrain;

/**
 * A class to represent a position with two values
 */
public class Position {
  private int x;
  private int y;

  /**
   * A representation of a coordinate
   *
   * @param x the x coordinate
   * @param y the y coordinate
   */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "x=" + x + ", y=" + y;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Position pos = (Position) obj;
    return getX() == pos.getX() && getY() == pos.getY();
  }
}
