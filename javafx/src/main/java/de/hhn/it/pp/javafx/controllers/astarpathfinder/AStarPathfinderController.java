package de.hhn.it.pp.javafx.controllers.astarpathfinder;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.exceptions.OccupiedPositionException;
import de.hhn.it.pp.components.astarpathfinding.exceptions.PositionOutOfBounds;
import de.hhn.it.pp.components.astarpathfinding.provider.MapManager;
import de.hhn.it.pp.components.astarpathfinding.provider.Pathfinder;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.javafx.controllers.Controller;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class AStarPathfinderController extends Controller implements Initializable {
  private static final org.slf4j.Logger logger =
    org.slf4j.LoggerFactory.getLogger(AStarPathfinderController.class);

  @FXML
  public Button createNewMapButton;
  @FXML
  public ComboBox<TerrainType> obstacleComboBox;
  @FXML
  public Slider costSlider;
  @FXML
  public Label costLabel;
  @FXML
  public FlowPane mapContainer;
  @FXML
  public SplitPane splitPane;
  @FXML
  public Label obstacleColorLabel;

  private Pathfinder pathfinder;
  private final MapPane mapPane;


  public static final Map<TerrainType, Color> TERRAIN_COLOR;

  static {
    TERRAIN_COLOR =
      Map.of(
        TerrainType.DIRT, CellLabel.DIRT_COLOR,
        TerrainType.GRASS, CellLabel.GRASS_COLOR,
        TerrainType.SWAMP, CellLabel.SWAMP_COLOR,
        TerrainType.WATER, CellLabel.WATER_COLOR,
        TerrainType.LAVA, CellLabel.LAVA_COLOR);
  }

  public AStarPathfinderController() {
    pathfinder = new Pathfinder();
    mapPane = new MapPane(MapManager.DEFAULT_WIDTH, MapManager.DEFAULT_HEIGHT, this);
  }

  /**
   * Called to initialize a controller after its root element has been completely processed.
   *
   * @param url The location used to resolve relative paths for the root object, or <tt>null</tt> if
   * the location is not known.
   * @param resourceBundle The resources used to localize the root object, or <tt>null</tt> if
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    // Add Background color to mapContainer
    mapContainer.setBackground(
      new Background(
        new BackgroundFill(Color.rgb(150, 150, 150), CornerRadii.EMPTY, Insets.EMPTY)));

    // Assign mapPane to mapContainer
    mapContainer.getChildren().add(mapPane);

    // Assign terrain types to obstacleComboBox
    obstacleComboBox.getItems().setAll(TerrainType.values());
    obstacleComboBox.setValue(TerrainType.DIRT);

    // Add Dirt Color to coloLabel
    obstacleColorLabel.setBackground(
      new Background(new BackgroundFill(CellLabel.DIRT_COLOR, CornerRadii.EMPTY, Insets.EMPTY)));

    // Initialize cost label
    costLabel.setText(String.valueOf((int) TerrainType.DIRT.getModifier()));

    // Add listener to the cost slider
    costSlider.setValue(TerrainType.DIRT.getModifier());
    costSlider
      .valueProperty()
      .addListener(
        new ChangeListener<Number>() {
          public void changed(
            ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
            try {
              pathfinder.changeTerrainTypeModifier(
                obstacleComboBox.getSelectionModel().getSelectedItem(),
                newValue.doubleValue());
              costLabel.setText(String.valueOf(newValue.intValue()));
            } catch (IllegalParameterException e) {
              // TODO: Handle error
              e.printStackTrace();
            }
          }
        });
  }

  public void onCreateNewMap(ActionEvent actionEvent) {
    CreateMapDialog dialog = new CreateMapDialog(pathfinder, mapPane);
    dialog.showAndWait();
  }

  public void onResetMap(ActionEvent actionEvent) {
    pathfinder.reset();
    mapPane.reset();
    // Reset cost label and slider
    costLabel.setText(String.valueOf((int) obstacleComboBox.getSelectionModel().getSelectedItem().getModifier()));
    costSlider.setValue(obstacleComboBox.getSelectionModel().getSelectedItem().getModifier());
  }

  public void onStartVisualization(ActionEvent actionEvent) {
    try {
      List<PathfindingInformation> result = pathfinder.doPathfinding();
      mapPane.showPath(result);
    } catch (IllegalParameterException e) {
      // TODO: Handle error
      e.printStackTrace();
    }
  }

  public void onSelectObstacle(ActionEvent actionEvent) {
    if (actionEvent.getSource() instanceof ComboBox) {
      ComboBox<?> comboBox = (ComboBox<?>) actionEvent.getSource();
      if (comboBox.getSelectionModel().getSelectedItem() instanceof TerrainType) {
        TerrainType type = (TerrainType) comboBox.getSelectionModel().getSelectedItem();
        costSlider.setValue(type.getModifier());
        costLabel.setText(String.valueOf((int) type.getModifier()));
        Color color = AStarPathfinderController.TERRAIN_COLOR.get(type);
        if (color != null) {
          obstacleColorLabel.setBackground(
            new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
          // TODO: Meldung an den Nutzer
        }
      }
    }
  }

  public void setStartPoint(CellLabel oldPoint, CellLabel newPoint) {
    try {
      pathfinder.setStartPoint(newPoint.getPosition());
      newPoint.setStartPoint(true);
      oldPoint.setStartPoint(false);
    } catch (OccupiedPositionException e) {
        //TODO: Maybe do something
    } catch (PositionOutOfBounds positionOutOfBounds) {
        // should not happen
        positionOutOfBounds.printStackTrace();
    }
  }

  public void setDestinationPoint(CellLabel oldPoint, CellLabel newPoint) {
    try {
      pathfinder.setEndPoint(newPoint.getPosition());
      newPoint.setDestinationPoint(true);
      oldPoint.setDestinationPoint(false);
    } catch (OccupiedPositionException e) {
      //TODO: Maybe do something
    } catch (PositionOutOfBounds positionOutOfBounds) {
      // should not happen
      positionOutOfBounds.printStackTrace();
    }

  }

  public void setTerrain(CellLabel cell) {
    TerrainType selectedTerrainType = obstacleComboBox.getSelectionModel().getSelectedItem();
    if(!cell.getType().equals(selectedTerrainType)){
      try {
        pathfinder.placeTerrain(selectedTerrainType, cell.getPosition());
        cell.setType(selectedTerrainType);
      } catch (PositionOutOfBounds positionOutOfBounds) {
        //TODO: Error handling
        positionOutOfBounds.printStackTrace();
      }
    }
  }
}

