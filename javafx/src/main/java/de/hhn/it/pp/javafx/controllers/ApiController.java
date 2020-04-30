package de.hhn.it.pp.javafx.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

import de.hhn.it.pp.components.api.src.main.java.api.Api;
import de.hhn.it.pp.components.api.src.main.java.api.ApiService;

import de.hhn.it.pp.javafx.controllers.apiviewscontrollers.InventoryViewController;
import de.hhn.it.pp.javafx.controllers.apiviewscontrollers.ItemViewController;

/**
 * This class is is handles all user interaction via the ApiView UI
 *
 * @author Dennis Schies
 * @version 1.0
 */
public class ApiController extends Controller implements Initializable {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(ApiController.class);

    FXMLLoader loader;
    @FXML
    ListView<String> functionListView;
    ObservableList<String> selectableFunctions;
    @FXML
    AnchorPane functionAnchorPane;

    //the shown functionalities in the listView
    private final String INVENTORIES = "Inventories";
    private final String ITEMS = "Items";

    private Api api;

    public ApiController() {

        selectableFunctions = FXCollections.observableArrayList();
        selectableFunctions.add(INVENTORIES);
        selectableFunctions.add(ITEMS);
        this.api = new ApiService();

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

    @FXML
    public void handleMouseClick(MouseEvent arg0) {
        logger.info("clicked on " + functionListView.getSelectionModel().getSelectedItem());

        if (functionListView.getSelectionModel().getSelectedItem() == null) {
            logger.info("No function selected");
            return;
        }

        try {
            if (functionListView.getSelectionModel().getSelectedItem().equals(INVENTORIES)) {
                logger.info("loading InventoryView");
                URL url = getClass().getResource("/fxml/apiviews/InventoryView.fxml");
                loader = new FXMLLoader(url);
                InventoryViewController.setApi(api);
                functionAnchorPane.getChildren().clear();
                functionAnchorPane.getChildren().add(FXMLLoader.load(url));
            } else if (functionListView.getSelectionModel().getSelectedItem().equals(ITEMS)) {
                logger.info("loading ItemView");
                URL url = getClass().getResource("/fxml/apiviews/ItemView.fxml");
                loader = new FXMLLoader(url);
                ItemViewController.setApi(api);
                functionAnchorPane.getChildren().clear();
                functionAnchorPane.getChildren().add(FXMLLoader.load(url));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
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
}
