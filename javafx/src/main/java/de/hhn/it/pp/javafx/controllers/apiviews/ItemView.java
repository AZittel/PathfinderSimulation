package de.hhn.it.pp.javafx.controllers.apiviews;

import de.hhn.it.pp.components.api.src.main.java.api.ApiService;
import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.javafx.controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ItemView extends Controller implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InventoryView.class);

    @FXML
    Label viewLabel;
    private ApiService api;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        logger.info("initializing ItemView");

        api = new ApiService();
        this.viewLabel = new Label("Items");
    }
}