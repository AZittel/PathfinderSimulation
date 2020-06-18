package de.hhn.it.pp.javafx.controllers.astarpathfinder;


import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;


public class MapPane extends FlowPane {
  private static final org.slf4j.Logger logger =
    org.slf4j.LoggerFactory.getLogger(MapPane.class);

  CellLabel[][] map;


  public MapPane(int width, int height) {
    setPrefHeight(height * CellLabel.CELL_SIZE);
    setPrefWidth(width * CellLabel.CELL_SIZE);
    createMap(width, height);
    setAlignment(Pos.CENTER);
  }


  public void reset() {
    createMap(map[0].length, map.length);
  }

  public void showPath(
    List<PathfindingInformation> result) {
  }

  public void createMap(int width, int height) {
    getChildren().clear();
    map = new CellLabel[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        CellLabel cell = new CellLabel(new Position(row, col), TerrainType.DIRT);
        map[row][col] = cell;
        getChildren().add(cell);
      }
    }

    logger.debug("createMap: map successfully created");
  }
}
