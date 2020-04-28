package de.hhn.it.pp.components.astarpathfinding;

/** A class to represent a position with two values */
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
    return "Position{" + "x=" + x + ", y=" + y + '}';
  }
}
