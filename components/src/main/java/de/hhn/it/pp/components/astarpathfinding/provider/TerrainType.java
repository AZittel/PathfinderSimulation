package de.hhn.it.pp.components.astarpathfinding.provider;

/**
 * Enumeration for terrain types with a default obstacle factor.
 */
public enum TerrainType {
  GRASS(0),
  SWAMP(0.2),
  WATER(0.5),
  LAVA(1);

  /**
   * The default obstacle factor.
   */
  private final double defaultFactor;

  TerrainType(double defaultFactor) {
    this.defaultFactor = defaultFactor;
  }

  public double getDefaultFactor() {
    return defaultFactor;
  }
}
