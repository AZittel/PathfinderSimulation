package de.hhn.it.pp.javafx.controllers.apiviews;

import de.hhn.it.pp.components.api.src.main.java.api.ApiService;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;


import java.io.IOException;


public class InventoryView extends AnchorPane {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InventoryView.class);

    @FXML
    Label viewLabel;
    private ApiService api;

    public InventoryView() {
        logger.info("loading InventoryView");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/apiviews"
                + "/InventoryView.fxml"));

        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        api = new ApiService();
        this.viewLabel = new Label("Inventories");
    }
}
