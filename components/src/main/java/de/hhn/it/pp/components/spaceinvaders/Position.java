package de.hhn.it.pp.components.spaceinvaders;

public class Position {
  private static final org.slf4j.Logger logger =
          org.slf4j.LoggerFactory.getLogger(Position.class);

  private int x;
  private int y;

  public Position(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(final int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(final int y) {
    this.y = y;
  }
}
