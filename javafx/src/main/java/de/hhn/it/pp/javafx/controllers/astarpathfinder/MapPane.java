package de.hhn.it.pp.javafx.controllers.astarpathfinder;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.Position;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import java.util.List;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;

public class MapPane extends FlowPane {

  private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MapPane.class);
  private static CellLabel selectedCell;

  private CellLabel[][] map;

  private AStarPathfinderController controller;

  private boolean obstaclePlaceMode;

  public MapPane(int width, int height, AStarPathfinderController controller) {
    this.controller = controller;
    createMap(width, height);
  }

  public void reset() {
    createMap(map[0].length, map.length);
  }

  public void showPath(List<PathfindingInformation> result) {
  }

  public void createMap(int width, int height) {
    // Clear cells and set new size
    getChildren().clear();
    setPrefHeight(height * (CellLabel.CELL_SIZE) + 2);
    setPrefWidth(width * (CellLabel.CELL_SIZE) + 2);

    map = new CellLabel[height][width];
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        Position pos = new Position(row, col);
        CellLabel cell = new CellLabel(pos, TerrainType.DIRT);
        map[row][col] = cell;
        if (pos.equals(new Position((int) Math.ceil(height / 2f) - 1, 0))) {
          cell.setStartPoint(true);
        } else if (pos.equals(new Position((int) Math.ceil(height / 2f) - 1, width - 1))) {
          cell.setDestinationPoint(true);
        }

        addEventHandler(cell);
        getChildren().add(cell);
      }
    }
    logger.info("createMap: map successfully created");
  }

  private void addEventHandler(CellLabel cell) {
    cell.setOnDragDetected(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        // drag was detected, start a drag-and-drop gesture allow any transfer mode
        if (cell.isStartPoint() || cell.isDestinationPoint()) {
          Dragboard db = cell.startDragAndDrop(TransferMode.ANY);
          selectedCell = cell;
          // Put a string on a dragboard
          ClipboardContent content = new ClipboardContent();
          content.putString(cell.getText());
          db.setContent(content);
        }
        event.consume();
      }
    });

    cell.setOnDragOver(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent event) {
        CellLabel source = (CellLabel) event.getGestureSource();
        // data is dragged over the target
        if (source != cell &&
          event.getDragboard().hasString()) {
          if ((source.isStartPoint() && !cell.isDestinationPoint()) ||
            (source.isDestinationPoint() && !cell.isStartPoint())) {
            //  allow for moving
            event.acceptTransferModes(TransferMode.ANY);
          }
        }
        event.consume();
      }
    });

    cell.setOnDragDropped(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent event) {
        CellLabel source = (CellLabel) event.getGestureSource();
        // data dropped
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
          if (source != null && !cell.equals(source)) {
            // Start and destination
            if (source.isStartPoint()) {
              controller.setStartPoint(source, cell);
            } else if (source.isDestinationPoint()) {
              controller.setDestinationPoint(source, cell);
            }
          }
          success = true;
        }
        event.setDropCompleted(success);
        event.consume();
      }
    });

    cell.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        if (obstaclePlaceMode) {
          setTerrain((CellLabel) mouseEvent.getSource());
        }
      }
    });

    cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        if (!cell.isStartPoint() && !cell.isDestinationPoint()) {
          obstaclePlaceMode = !obstaclePlaceMode;
          controller.setTerrain((CellLabel) mouseEvent.getSource());
        }
      }
    });
  }

  public void setObstaclePlaceMode(boolean obstaclePlaceMode) {
    this.obstaclePlaceMode = obstaclePlaceMode;
  }

  public boolean isObstaclePlaceMode() {
    return obstaclePlaceMode;
  }

  public void setTerrain(CellLabel source) {
    controller.setTerrain(source);
  }
}
