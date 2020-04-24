package de.hhn.it.pp.javafx.controllers.apiviewscontrollers;

import de.hhn.it.pp.components.api.src.main.java.api.Api;
import de.hhn.it.pp.components.api.src.main.java.api.ApiService;

import de.hhn.it.pp.components.api.src.main.java.api.models.Inventory;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;
import de.hhn.it.pp.javafx.controllers.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.StageStyle;
import javafx.util.Callback;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class InventoryViewController extends Controller implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InventoryViewController.class);

    @FXML
    ListView<Inventory> inventoryListView;
    ObservableList<Inventory> inventoryObservableList;
    ArrayList<Inventory> currentInventories;
    Boolean defaultListView;
    ArrayList<Integer> currentInventoryIds;
    @FXML
    TableView<Inventory> inventoryTable;
    ArrayList<TableColumn<Inventory, String>> columns;
    final String[] COLUMNNAMES = {"id", "name", "maxWeight", "maxVolume", "currentValue"};
    Inventory selectedInventory;
    @FXML
    TextField idSearch;
    @FXML
    TextField newName;
    @FXML
    TextField newMaxWeight;
    @FXML
    TextField newMaxVolume;

    private static Api api;

    public InventoryViewController() {

        inventoryObservableList = FXCollections.observableArrayList();
        currentInventories = new ArrayList<>();
        currentInventoryIds = new ArrayList<>();
        inventoryTable = new TableView<>();
        columns = new ArrayList<>();
        idSearch = new TextField();
        newName = new TextField();
        newMaxWeight = new TextField();
        newMaxVolume = new TextField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("initializing InventoryView");

        //initializing the listView with default status true
        defaultListView = true;
        updateInventoryListView();

        //building the inventoryTable and initializing the inventoryTableView
        inventoryTable.setEditable(false);
        inventoryTable.addEventFilter(ScrollEvent.ANY, Event::consume);
        for (String name : COLUMNNAMES) {
            TableColumn<Inventory, String> column = new TableColumn<>(name);
            column.setResizable(false);
            column.setSortable(false);
            column.setPrefWidth(112.0);
            columns.add(column);
        }
        for (TableColumn<Inventory, String> column : columns) {
            inventoryTable.getColumns().add(column);
        }
        updateInventoryTable();
    }

    @FXML
    public void search() {
        logger.info("clicked on search");

        if (!idSearch.getText().isEmpty()) {
            try {
                currentInventoryIds.clear();
                currentInventoryIds.add(Integer.parseInt(idSearch.getText()));
                defaultListView = false;
                updateInventoryListView();
            } catch (NumberFormatException exception) {
                logger.error("wrong input for id search enter in value");
            }
        } else {
            defaultListView = true;
            updateInventoryListView();
        }
    }

    @FXML
    public void selectInventory(MouseEvent event) {
        if (inventoryListView.getSelectionModel().getSelectedItem() == null) {
            logger.info("no inventory selected");
            return;
        }
        logger.info("clicked on " + inventoryListView.getSelectionModel().getSelectedItem().toString());
        selectedInventory = inventoryListView.getSelectionModel().getSelectedItem();
        updateInventoryTable();
    }

    @FXML
    public void addNewInventory() {
        logger.info("clicked on add new inventory");

        if (newName.getText().isEmpty() || newMaxWeight.getText().isEmpty() || newMaxVolume.getText().isEmpty()) {
            logger.error("insufficient data");
            return;
        }

        String name;
        int maxWeight;
        int maxVolume;
        try {
            name = newName.getText();
            newName.clear();
            maxWeight = Integer.parseInt(newMaxWeight.getText());
            newMaxWeight.clear();
            maxVolume = Integer.parseInt(newMaxVolume.getText());
            newMaxVolume.clear();
            api.addInventory(name, maxWeight, maxVolume);
            logger.info("added inventory to the database");
        } catch (NumberFormatException exception) {
            logger.error("wrong input types");
        }
        //update list- and tableView
        updateInventoryListView();
        updateInventoryTable();
    }

    @FXML
    public void editInventory() {
        logger.info("clicked on edit inventory");

        if (newName.getText().isEmpty() && newMaxWeight.getText().isEmpty() && newMaxVolume.getText().isEmpty()) {
            logger.info("no fields to edit");
            return;
        } else if (selectedInventory == null) {
            logger.error("no inventory found");
            return;
        }

        Inventory editedInventory = selectedInventory;
        if (!newName.getText().isEmpty()) {
            editedInventory.setName(newName.getText());
            newName.clear();
        }
        if (!newMaxWeight.getText().isEmpty()) {
            try {
                editedInventory.setMaxWeight(Integer.parseInt(newMaxWeight.getText()));
                newMaxWeight.clear();
            } catch (NumberFormatException exception) {
                logger.error("wrong input types for new maxWeight");
            }
        }
        if (!newMaxVolume.getText().isEmpty()) {
            try {
                editedInventory.setMaxVolume(Integer.parseInt(newMaxVolume.getText()));
                newMaxVolume.clear();
            } catch (NumberFormatException exception) {
                logger.error("wrong input types for new maxVolume");
            }
        }
        //edit the entry in the database
        api.editInventory(editedInventory);

        //update list- and tableVie
        updateInventoryListView();
        updateInventoryTable();
    }

    @FXML
    public void removeInventory() {
        logger.info("clicked on remove inventory");

        if (selectedInventory == null) {
            logger.error("no inventory found");
            return;
        }

        int id = selectedInventory.getId();
        api.removeInventory(id);
        selectedInventory = null;
        logger.info("removed inventory with id: " + id);

        //update list- and tableVie
        updateInventoryListView();
        updateInventoryTable();
    }

    @FXML
    public void solveKnapSack() {
        if (selectedInventory == null) {
            logger.error("no inventory selected");
            return;
        }

        String output = "";
        int weight = 0;
        int volume = 0;
        int value = 0;
        ArrayList<Item> possibleItems = (ArrayList<Item>) api.knapSack(selectedInventory.getId());
        for (Item item : possibleItems) {
            output = output.concat("item: " + item.toString() + ", weight: " + item.getWeight() +
                    ", volume: " + item.getVolume() + ", value: " + item.getValue() + "\n");
            weight += item.getWeight();
            volume += item.getVolume();
            value += item.getValue();
        }
        output = output.concat("possible weight: " + weight + ", volume: " + volume + ", value: " + value);
        logger.debug(output);
        Alert popup = new Alert(Alert.AlertType.INFORMATION);
        popup.setTitle("KnapSack result");
        popup.setHeaderText(null);
        //popup.initStyle(StageStyle.UTILITY);
        popup.setContentText(output);

        popup.showAndWait();
        logger.info("solved knapsack for id: " + selectedInventory.getId());
    }

    public void updateInventoryListView() {
        currentInventories.clear();
        inventoryObservableList.clear();

        if (defaultListView) {
            currentInventories.addAll(api.retrieveAllInventories());
            if (currentInventories.size() == 0) {
                logger.info("there are no inventories yet");
            }
        } else {
            currentInventories.addAll(api.retrieveInventories(currentInventoryIds));
        }

        inventoryObservableList.addAll(currentInventories);

        inventoryListView.setItems(inventoryObservableList);
        inventoryListView.setCellFactory(new Callback<ListView<Inventory>, ListCell<Inventory>>() {
            @Override
            public ListCell<Inventory> call(ListView<Inventory> param) {
                return new InventoryCell();
            }
        });
    }

    public void updateInventoryTable() {
        if (selectedInventory == null) {
            try {
                selectedInventory = currentInventories.get(0);
            } catch (IndexOutOfBoundsException exception) {
                logger.info("no inventory loaded for selection");
                inventoryTable.getItems().clear();
                inventoryTable.refresh();
                return;
            }
        } else {
            selectedInventory = api.retrieveInventory(selectedInventory.getId());
        }

        for (TableColumn<Inventory, String> column : columns) {
            column.setCellValueFactory(
                    new PropertyValueFactory<Inventory, String>(column.getText())
            );
        }
        inventoryTable.getItems().clear();
        inventoryTable.getItems().add(selectedInventory);
    }

    public static void setApi(Api api) {
        InventoryViewController.api = api;
    }

    private static class InventoryCell extends ListCell<Inventory> {
        @Override
        protected void updateItem(final Inventory inventory, final boolean empty) {
            super.updateItem(inventory, empty);
            Label label = new Label();
            if (inventory != null) {
                label.setText(inventory.toString());
            }
            setGraphic(label);
        }
    }
}
