package de.hhn.it.pp.javafx.controllers;

import de.hhn.it.pp.javafx.controllers.apiviews.InventoryView;
import de.hhn.it.pp.javafx.controllers.apiviews.ItemView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ApiController extends Controller implements Initializable {

    @FXML
    ListView<String> functionListView;
    @FXML
    AnchorPane controlAnchorPane;
    Node actualControlAnchorPaneNode;
    ObservableList<String> selectableFunctions;
    Label chooseLabel;
    Node currentView;

    private final String INVENTORIES = "Inventories";
    private final String ITEMS = "Items";

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ApiController.class);

    public ApiController() {

        chooseLabel = new Label("choose a function");
        selectableFunctions = FXCollections.observableArrayList();
        selectableFunctions.add(INVENTORIES);
        selectableFunctions.add(ITEMS);
    }

    @Override
    public void initialize(final URL location, final ResourceBundle resources) {
        functionListView.setItems(selectableFunctions);
        functionListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new FunctionCell();
            }
        });
    }

    private class FunctionCell extends ListCell<String> {
        @Override
        protected void updateItem(final String function, final boolean empty) {
            super.updateItem(function, empty);
            Label label = new Label();
            if (function != null) {
                label.setText(function);
            }
            setGraphic(label);
        }
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) {
        logger.debug("clicked on " + functionListView.getSelectionModel().getSelectedItem());

        if (functionListView.getSelectionModel().getSelectedItem().equals(INVENTORIES)) {
            currentView = new InventoryView();
        } else if (functionListView.getSelectionModel().getSelectedItem().equals(ITEMS)) {
            currentView = new ItemView();
        }

        if (currentView == null) {
            logger.info("No function selected");
            actualControlAnchorPaneNode = chooseLabel;
            controlAnchorPane.getChildren().add(chooseLabel);
            return;
        }

        // remove current node from the controlAnchorPane
        if (actualControlAnchorPaneNode != null) {
            controlAnchorPane.getChildren().remove(actualControlAnchorPaneNode);
        }

        actualControlAnchorPaneNode = currentView;
        controlAnchorPane.getChildren().add(currentView);

    }
}
