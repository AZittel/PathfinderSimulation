package de.hhn.it.pp.javafx.controllers.apiviewscontrollers;

import de.hhn.it.pp.components.api.src.main.java.api.ApiService;
import de.hhn.it.pp.javafx.controllers.Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemViewController extends Controller implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InventoryViewController.class);

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