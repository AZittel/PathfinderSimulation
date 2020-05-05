package de.hhn.it.pp.components.astarpathfinding.provider;

import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds.PositionType;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

public class MapManager {
  public static final int MAX_WIDTH = 50;
  public static final int MAX_HEIGHT = 50;
  public static final int MIN_WIDTH = 2;
  public static final int MIN_HEIGHT = 2;

  public static final int DEFAULT_WIDTH = 10;
  public static final int DEFAULT_HEIGHT = 10;

  public static final Position DEFAULT_START_POSITION = new Position(0, 0);
  public static final Position DEFAULT_DESTINATION_POSITION = new Position(9, 9);

  private Position startCoordinates;
  private Position destinationCoordinates;

  private Terrain[][] map;

  public MapManager() {
    try {
      startCoordinates = DEFAULT_START_POSITION;
      destinationCoordinates = DEFAULT_DESTINATION_POSITION;
      createMap(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    } catch (IllegalParameterException | PositionOutOfBounds e) {
      // Do nothing, because this case should never happen
      e.printStackTrace();
    }
  }

  /**
   * Creates the map with the given width and height.
   *
   * @param width  the width of the map, must higher then 1
   * @param height the height of the map, must higher then 1
   * @throws IllegalParameterException if either the width or the height is invalid
   */
  public void createMap(int width, int height)
    throws IllegalParameterException, PositionOutOfBounds {
    // Check minimum boundaries of the map
    if (width < MIN_WIDTH || height < MIN_HEIGHT) {
      throw new IllegalParameterException("Width or height cannot be lower than 2!");
    }

    // Check maximum boundaries of the map
    if (width > MAX_WIDTH || height > MAX_HEIGHT) {
      throw new IllegalParameterException(String
        .format("Width or height exceeded max value! Maximum width is %d. Maximum height is %d.",
          MAX_WIDTH, MAX_HEIGHT));
    }

    // Check if start and destination positions are still on the map
    if (startCoordinates.getX() >= width || startCoordinates.getY() >= height) {
      startCoordinates = null;
      throw new PositionOutOfBounds("Start position out of new map boundaries", PositionType.START);
    } else if (destinationCoordinates.getX() >= width || destinationCoordinates.getY() >= height) {
      destinationCoordinates = null;
      throw new PositionOutOfBounds("Destination position out of new map boundaries",
        PositionType.DESTINATION);
    }

    // Create new map with grass terrain
    map = new Terrain[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        map[row][col] = new Terrain(new Position(col, row), TerrainType.DIRT);
      }
    }
  }

  /**
   * Creates and places a terrain from the given type on the given position.
   *
   * @param type     the terrain type
   * @param position the position on the map
   */
  public void createTerrain(TerrainType type, Position position) throws PositionOutOfBounds {
    // Check map boundaries
    checkPositionInBounds(position);
    map[position.getY()][position.getX()] = new Terrain(position, type);
  }

  /**
   * Evaluates if the position is in the current map's boundaries.
   *
   * @param position the x and y coordinates
   * @throws PositionOutOfBounds thrown when the position is not on the map
   */
  private void checkPositionInBounds(Position position) throws PositionOutOfBounds {
    if (position.getX() < 0) {
      throw new PositionOutOfBounds("X cannot be lower than 0!", PositionType.DEFAULT);
    } else if (position.getX() > getWidth() - 1) {
      throw new PositionOutOfBounds(String.format("X cannot be greater than %d!", getWidth() - 1),
        PositionType.DEFAULT);
    } else if (position.getY() < 0) {
      throw new PositionOutOfBounds("Y cannot be lower than 0!", PositionType.DEFAULT);
    } else if (position.getY() > getHeight() - 1) {
      throw new PositionOutOfBounds(String.format("Y cannot be greater than %d!", getHeight() - 1),
        PositionType.DEFAULT);
    }
  }

  /**
   * Overwrites the map with a new empty map of the same size.
   */
  public void reset() {
    try {
      createMap(map[0].length, map.length);
    } catch (IllegalParameterException | PositionOutOfBounds e) {
      // Do nothing, because this case should never happen
      e.printStackTrace();
    }
  }

  public Terrain getTerrainAt(Position position) throws PositionOutOfBounds{
    checkPositionInBounds(position);
    return map[position.getY()][position.getX()];
  }

  public Terrain[][] getMap() {
    return map;
  }

  public int getWidth() {
    return map[0].length;
  }

  public int getHeight() {
    return map.length;
  }

  public Position getStartCoordinates() {
    return startCoordinates;
  }

  public void setStartCoordinates(Position startCoordinates)
    throws OccupiedPositionException, PositionOutOfBounds {
    // Check map boundaries
    checkPositionInBounds(startCoordinates);

    // Check occupied position
    if (getDestinationCoordinates().equals(startCoordinates)) {
      throw new OccupiedPositionException(
        "The start point cannot be placed on the destination point");
    }
    this.startCoordinates = startCoordinates;
  }

  public Position getDestinationCoordinates() {
    return destinationCoordinates;
  }

  public void setDestinationCoordinates(Position destinationCoordinates)
    throws OccupiedPositionException, PositionOutOfBounds {
    // Check map boundaries
    checkPositionInBounds(destinationCoordinates);

    // Check occupied position
    if (getStartCoordinates().equals(destinationCoordinates)) {
      throw new OccupiedPositionException(
        "The destination point cannot be placed on the start point");
    }
    this.destinationCoordinates = destinationCoordinates;
  }


}
