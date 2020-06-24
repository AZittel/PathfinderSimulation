package de.hhn.it.pp.javafx.controllers.astarpathfinder;



import de.hhn.it.pp.components.astarpathfinding.provider.MapManager;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class CreateMapDialog extends Dialog<Pair<String, String>> {

  public CreateMapDialog() {
    setTitle("Create Map Dialog");
    setHeaderText("Choose the map size");

    ButtonType createButtonType = new ButtonType("Create", ButtonData.OK_DONE);
    getDialogPane().getButtonTypes().addAll(createButtonType, ButtonType.CANCEL);

    // Create the width and height labels and fields.
    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(20, 150, 10, 10));

    TextField widthField = new TextField();
    widthField.setPromptText("max " + MapManager.MAX_WIDTH);
    TextField heightField = new TextField();
    heightField.setPromptText("max " + MapManager.MAX_HEIGHT);

    grid.add(new Label("Width:"), 0, 0);
    grid.add(widthField, 1, 0);
    grid.add(new Label("Height:"), 0, 1);
    grid.add(heightField, 1, 1);

    // Enable/Disable login button depending on whether a username was entered.
    Node createButton = getDialogPane().lookupButton(createButtonType);
    createButton.setDisable(true);

    // Do some validation for width textField
    widthField.textProperty().addListener((observable, oldValue, newValue) -> {
      createButton.setDisable(checkTextFields(newValue, heightField.getText()));
    });

    // Do some validation for height textField
    heightField.textProperty().addListener((observable, oldValue, newValue) -> {
      createButton.setDisable(checkTextFields(newValue, widthField.getText()));
    });

    getDialogPane().setContent(grid);

    // Convert the result to a username-password-pair when the login button is clicked.
    setResultConverter(dialogButton -> {
      if (dialogButton == createButtonType) {
        return new Pair<>(widthField.getText(), heightField.getText());
      }
      return null;
    });
  }

  private boolean checkTextFields(String text1, String text2) {
    final String pattern = "^\\d+$";
    return !Pattern.matches(pattern, text1) || !Pattern.matches(pattern, text2);
  }
}
