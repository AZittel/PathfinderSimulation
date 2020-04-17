package de.hhn.it.pp.javafx.controllers.apiviews;

import de.hhn.it.pp.components.api.src.main.java.api.ApiService;
import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class ItemView extends AnchorPane {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InventoryView.class);

    @FXML
    Label viewLabel;
    private ApiService api;

    public ItemView() {
        logger.info("loading ItemView");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/apiviews"
                + "/ItemView.fxml"));

        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        api = new ApiService();
        this.viewLabel = new Label("Items");
    }
}