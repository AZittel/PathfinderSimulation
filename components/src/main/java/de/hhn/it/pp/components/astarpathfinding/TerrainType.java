package de.hhn.it.pp.components.astarpathfinding;

/** Enumeration for terrain types with a default obstacle factor. */
public enum TerrainType {
  GRASS(0),
  SWAMP(0.2),
  WATER(0.5),
  LAVA(1);

  /** The default obstacle factor. */
  private double modifier;

  TerrainType(double modifier) {
    this.modifier = modifier;
  }

  public void setModifier(double modifier) {
    this.modifier = modifier;
  }

  public double getModifier() {
    return modifier;
  }
}
