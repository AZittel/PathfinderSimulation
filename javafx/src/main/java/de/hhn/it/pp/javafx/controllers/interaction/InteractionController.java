package de.hhn.it.pp.javafx.controllers.interaction;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.ApiService;
import de.hhn.it.pp.components.api.src.main.java.api.Interaction;

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

public class InteractionController extends AnchorPane {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InteractionController.class);

    @FXML
    ListView<String> tableListView;
    ObservableList<String> tables;

    ArrayList<Inventory> inventories;
    ArrayList<Integer> inventoryIds = new ArrayList<Integer>();

    @FXML
    Label interactionLabel;
    private ApiService api;

    public InteractionController(Interaction interaction){
        logger.info("loading InteractionController");

        //needs to be build
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/interaction"
                + "/InteractionControl.fxml"));

        loader.setRoot(this);
        loader.setController(this);


        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        api = new ApiService();
        tables = FXCollections.observableArrayList();
        inventoryIds.add(1);
        inventoryIds.add(2);
        inventoryIds.add(3);
        inventoryIds.add(4);
        inventoryIds.add(5);
        inventoryIds.add(6);
        inventoryIds.add(7);
        inventoryIds.add(8);
        inventoryIds.add(9);
        //debug
        for(Integer inventory : inventoryIds){
            logger.info(inventory.toString());
        }
        inventories = new ArrayList<>();
        inventories.addAll(api.retrieveInventories(inventoryIds));

        //debug
        for(Inventory inventory : inventories){
            logger.info(inventory.getName());
        }


        for(Inventory i : inventories){
            tables.add(i.getName());
        }

        tableListView.setItems(tables);

        //debug
        for(String table : tables){
            logger.info(table);
        }
        tableListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new TableCell();
            }
        });

        interactionLabel.setText(interaction.toString());
    }

    private class TableCell extends ListCell<String> {
        @Override
        protected void updateItem(final String table, final boolean empty){
            super.updateItem(table, empty);
            Label label = new Label();
            if(table != null){
                label.setText(table);
            }
            setGraphic(label);
        }
    }
}
