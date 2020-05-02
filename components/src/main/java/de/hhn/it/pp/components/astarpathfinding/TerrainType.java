package de.hhn.it.pp.components.astarpathfinding;

/**
 * Enumeration for terrain types with a default obstacle factor.
 */
public enum TerrainType {
  DIRT(0),
  GRASS(0.1),
  SWAMP(0.4),
  WATER(0.5),
  LAVA(1);

  public static final double MIN_VALUE = 0;
  public static final double MAX_VALUE = 1;

  /**
   * The default obstacle factor.
   */
  private final double defaultModifier;
  private double modifier;

  TerrainType(double defaultModifier) {
    this.defaultModifier = defaultModifier;
    this.modifier = defaultModifier;
  }

  /**
   * Restores the default values for the terrain types.
   */
  public static void resetModifers() {
    for (TerrainType type : TerrainType.values()) {
      type.setModifier(type.getDefaultModifier());
    }
  }

  public double getDefaultModifier() {
    return defaultModifier;
  }

  public double getModifier() {
    return modifier;
  }

  public void setModifier(double modifier) {
    this.modifier = modifier;
  }
}
