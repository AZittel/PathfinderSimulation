package de.hhn.it.pp.javafx.controllers.astarpathfinder;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import java.util.List;
import javafx.scene.layout.FlowPane;

public class MapPane extends FlowPane {
  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MapPane.class);

  CellLabel[][] map;

  public MapPane(int width, int height) {
    createMap(width, height);
    //    setBorder(new Border(new BorderStroke(Color.BLACK,
    //        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
  }

  public void reset() {
    createMap(map[0].length, map.length);
  }

  public void showPath(List<PathfindingInformation> result) {}

  public void createMap(int width, int height) {
    // Clear cells and set new size
    getChildren().clear();
    setPrefHeight(height * (CellLabel.CELL_SIZE) + 2);
    setPrefWidth(width * (CellLabel.CELL_SIZE) + 2);

    map = new CellLabel[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        CellLabel cell = new CellLabel(new Position(row, col), TerrainType.DIRT);
        map[row][col] = cell;
        getChildren().add(cell);
      }
    }
    logger.info("createMap: map successfully created");
  }
}
