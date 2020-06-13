package de.hhn.it.pp.javafx.controllers.astarpathfinder;

import de.hhn.it.pp.components.astarpathfinding.PathfindingInformation;
import de.hhn.it.pp.components.astarpathfinding.TerrainType;
import de.hhn.it.pp.components.astarpathfinding.provider.MapManager;
import de.hhn.it.pp.components.astarpathfinding.provider.Pathfinder;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.javafx.controllers.Controller;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class AStarPathfinderController extends Controller implements Initializable {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(AStarPathfinderController.class);

  @FXML public Button createNewMapButton;
  @FXML public ComboBox<TerrainType> obstacleComboBox;
  @FXML public Slider costSlider;
  @FXML public Label costLabel;

  private Pathfinder pathfinder;
  private MapPane mapPane;

  public AStarPathfinderController() {
    pathfinder = new Pathfinder();
    mapPane = new MapPane(MapManager.DEFAULT_WIDTH, MapManager.DEFAULT_HEIGHT);
  }

  /**
   * Called to initialize a controller after its root element has been completely processed.
   *
   * @param url The location used to resolve relative paths for the root object, or <tt>null</tt> if
   *     the location is not known.
   * @param resourceBundle The resources used to localize the root object, or <tt>null</tt> if
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    // Assign terrain types to obstacleComboBox
    obstacleComboBox.getItems().setAll(TerrainType.values());
    obstacleComboBox.setValue(TerrainType.DIRT);

    // Initialize cost label
    costLabel.setText(String.valueOf((int)TerrainType.DIRT.getModifier()));

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
    // TODO: Open popup dialog where the user can enter the new map size
  }

  public void onResetMap(ActionEvent actionEvent) {
    // TODO: Implement method
    pathfinder.reset();
    mapPane.reset();
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
      }
    }
  }
}
