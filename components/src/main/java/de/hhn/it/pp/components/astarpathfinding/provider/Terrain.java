package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.IHeapItem;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;

public class Terrain implements Cloneable, IHeapItem<Terrain> {
  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Terrain.class);

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

  private int heapIndex;

  private Terrain() {
  }

  public Terrain(Position position, TerrainType type) {
    super();
    this.position = position;
    this.type = type;
    logger.debug("Terrain created: {}", this.toString());
  }

  /**
   * Calculates the sum of g and h.
   *
   * @return the sum of g and h.
   */
  public int calculateFCost() {
    return g + h;
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

  public TerrainType getType() {
    return type;
  }

  public void setType(TerrainType type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return type + " " + position;
  }

  /**
   * TODO java doc
   */
  @Override
  public Object clone() throws CloneNotSupportedException {

    Terrain cloned = (Terrain) super.clone();
    if (parent != null) {
      cloned.setParent((Terrain) cloned.getParent().clone());
    }
    Position clonedPosition = cloned.getPosition();
    cloned.setPosition(new Position(clonedPosition.getRow(), clonedPosition.getCol()));

    return cloned;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Terrain ter = (Terrain) obj;
    return position.equals(ter.position) && h == ter.h && g == ter.g &&
      type == ter.type;
  }

  @Override
  public int getHeapIndex() {
    return heapIndex;
  }

  @Override
  public void setHeapIndex(int heapIndex) {
    this.heapIndex = heapIndex;
  }

  @Override
  public int compareTo(Object o) {
    Terrain terrainToCompare = (Terrain) o;
    int comparison = calculateFCost() - terrainToCompare.calculateFCost();
    if (comparison == 0) {
      comparison = h - terrainToCompare.h;
    }
    // In this case we want to return >0 if the cost is lower so reverse the comparison
    return -comparison;
  }
}
