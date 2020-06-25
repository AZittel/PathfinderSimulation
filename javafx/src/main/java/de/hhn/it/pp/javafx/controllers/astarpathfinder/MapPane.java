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

        cell.setOnDragDetected(new EventHandler<MouseEvent>() {
          public void handle(MouseEvent event) {
            // drag was detected, start a drag-and-drop gesture allow any transfer mode
            Dragboard db = cell.startDragAndDrop(TransferMode.ANY);
            if (cell.isStartPoint() || cell.isDestinationPoint()) {
              selectedCell = cell;
            }
            // Put a string on a dragboard
            ClipboardContent content = new ClipboardContent();
            content.putString(cell.getText());
            db.setContent(content);

            event.consume();
          }
        });

        cell.setOnDragOver(new EventHandler<DragEvent>() {
          public void handle(DragEvent event) {
            CellLabel source = (CellLabel) event.getGestureSource();
            // data is dragged over the target
            // accept it only if it is not dragged from the same node
            // and if it has a string data
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
          public void handle(DragEvent event) {
            System.out.println("Drag Dropped");
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
            // let the source know whether the string was successfully
            // transferred and used
            event.setDropCompleted(success);

            event.consume();
          }
        });

    /*    cell.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {

          }
        });*/
/*
        cell.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            if (cell.isStartPoint() || cell.isDestinationPoint()) {
              selectedCell = cell;
              System.out.println("Cell selected");
            }
          }
        });
        cell.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent mouseEvent) {
            if (selectedCell != null && !cell.equals(selectedCell)) {
              //Start and destionation
              if (selectedCell.isStartPoint()) {
                controller.setStartPoint(selectedCell, cell);
                cell.setStartPoint(true);
              } else if(selectedCell.isDestinationPoint()){
                controller.setDestinationPoint(selectedCell, cell);
                cell.setDestinationPoint(true);
              }
            }
          }
        });*/

        getChildren().add(cell);

      }
    }
    logger.info("createMap: map successfully created");
  }
}
