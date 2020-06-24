package de.hhn.it.pp.javafx.controllers.astarpathfinder;

import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class CellLabel extends Label {
  private static final org.slf4j.Logger logger =
    org.slf4j.LoggerFactory.getLogger(CellLabel.class);

  public static final int CELL_SIZE = 30;

  public static final Color DIRT_COLOR = Color.rgb(150, 80, 40);
  public static final Color GRASS_COLOR = Color.rgb(90, 150, 40);
  public static final Color SWAMP_COLOR = Color.rgb(40, 150, 110);
  public static final Color WATER_COLOR = Color.rgb(40, 120, 150);
  public static final Color LAVA_COLOR = Color.rgb(235, 95, 30);

  public final static Insets INSETS = new Insets(2);

  private Position position;
  private TerrainType type;
  private boolean isStartPoint;
  private boolean isDestinationPoint;


  public CellLabel(Position position, TerrainType type) {
    super();
    this.position = position;
    this.setPrefSize(CELL_SIZE, CELL_SIZE);
    setType(type);

  }

  public TerrainType getType() {
    return type;
  }

  public void setType(TerrainType type) {
    this.type = type;
    Color color = AStarPathfinderController.TERRAIN_COLOR.get(type);
    if(color != null){
      setBackground(new Background(new BackgroundFill(color,
        CornerRadii.EMPTY, INSETS)));
    } else {
       // TODO: Meldung an den Nutzer
    }
  }

  public boolean isStartPoint() {
    return isStartPoint;
  }

  public void setStartPoint(boolean startPoint) {
    isStartPoint = startPoint;
  }

  public boolean isDestinationPoint() {
    return isDestinationPoint;
  }

  public void setDestinationPoint(boolean destinationPoint) {
    isDestinationPoint = destinationPoint;
  }
}
