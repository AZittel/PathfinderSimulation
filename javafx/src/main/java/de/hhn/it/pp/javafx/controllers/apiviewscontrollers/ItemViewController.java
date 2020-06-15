package de.hhn.it.pp.javafx.controllers.apiviewscontrollers;

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
import javafx.util.Callback;

import java.net.URL;

import java.util.ArrayList;
import java.util.ResourceBundle;

import de.hhn.it.pp.components.api.src.main.java.api.Api;
import de.hhn.it.pp.components.api.src.main.java.api.models.Item;

/**
 * This class is is handles all user interaction via the ItemView UI
 *
 * @author Dennis Schies
 * @version 1.0
 */
public class ItemViewController extends Controller implements Initializable {

    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(InventoryViewController.class);

    final String[] COLUMNNAMES = {"id", "name", "weight", "volume", "value", "inventoryId"};
    @FXML
    ListView<Item> itemListView;
    ObservableList<Item> itemObservableList;
    ArrayList<Item> currentItems;
    Boolean defaultListView;
    ArrayList<Integer> currentItemIds;
    @FXML
    TableView<Item> itemTable;
    ArrayList<TableColumn<Item, String>> columns;
    Item selectedItem;
    @FXML
    TextField idSearch;
    @FXML
    TextField newName;
    @FXML
    TextField newWeight;
    @FXML
    TextField newVolume;
    @FXML
    TextField newValue;
    @FXML
    TextField newInventoryId;
    @FXML
    TextField inventoryIdInput;

    private static Api api;

    public ItemViewController() {

        itemObservableList = FXCollections.observableArrayList();
        currentItems = new ArrayList<>();
        currentItemIds = new ArrayList<>();
        itemTable = new TableView<>();
        columns = new ArrayList<>();
        idSearch = new TextField();
        newName = new TextField();
        newWeight = new TextField();
        newVolume = new TextField();
        newValue = new TextField();
        newInventoryId = new TextField();
        inventoryIdInput = new TextField();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("initializing ItemView");

        //initializing the listView with default status true
        defaultListView = true;
        updateItemListView();

        //building the inventoryTable and initializing the inventoryTableView
        itemTable.setEditable(false);
        itemTable.addEventFilter(ScrollEvent.ANY, Event::consume);
        for (String name : COLUMNNAMES) {
            TableColumn<Item, String> column = new TableColumn<>(name);
            column.setResizable(false);
            column.setSortable(false);
            //edit for better fitting
            column.setPrefWidth(94.0);
            columns.add(column);
        }
        for (TableColumn<Item, String> column : columns) {
            itemTable.getColumns().add(column);
        }
        updateItemTable();
    }

    @FXML
    public void moveItem(ActionEvent event) {
        logger.info("clicked on move item");

        if (!inventoryIdInput.getText().isEmpty()) {
            try {
                int inventoryId = Integer.parseInt(inventoryIdInput.getText());
                inventoryIdInput.clear();
                api.moveItem(selectedItem, inventoryId);
                updateItemListView();
                updateItemTable();
            } catch (NumberFormatException exception) {
                logger.error("wrong input for inventory id enter int value");
                updateItemListView();
                updateItemTable();
            }
        }
    }

    @FXML
    public void search(ActionEvent event) {
        logger.info("clicked on search");

        if (!idSearch.getText().isEmpty()) {
            try {
                currentItemIds.clear();
                currentItemIds.add(Integer.parseInt(idSearch.getText()));
                defaultListView = false;
                updateItemListView();
            } catch (NumberFormatException exception) {
                logger.error("wrong input for id search enter int value");
            }
        } else {
            defaultListView = true;
            updateItemListView();
        }
    }

    @FXML
    public void selectItem(MouseEvent event) {
        if (itemListView.getSelectionModel().getSelectedItem() == null) {
            logger.info("no inventory selected");
            return;
        }
        logger.info("clicked on " + itemListView.getSelectionModel().getSelectedItem().toString());
        selectedItem = itemListView.getSelectionModel().getSelectedItem();
        updateItemTable();
    }

    @FXML
    public void addNewItem() {
        logger.info("clicked on add new item");

        if (newName.getText().isEmpty() || newWeight.getText().isEmpty() || newVolume.getText().isEmpty()
                || newValue.getText().isEmpty()) {
            logger.error("insufficient data");
            return;
        }

        String name;
        int weight;
        int volume;
        int value;
        int inventoryId;
        try {
            name = newName.getText();
            newName.clear();
            weight = Integer.parseInt(newWeight.getText());
            newWeight.clear();
            volume = Integer.parseInt(newVolume.getText());
            newVolume.clear();
            value = Integer.parseInt(newValue.getText());
            newValue.clear();
            if (!newInventoryId.getText().isEmpty()) {
                inventoryId = Integer.parseInt(newInventoryId.getText());
                newInventoryId.clear();
                logger.info("try to add inventory to the database");
                api.addItem(name, weight, volume, value, inventoryId);
            } else {
                api.addItem(name, weight, volume, value);
                logger.info("added inventory to the database");
            }
        } catch (NumberFormatException exception) {
            logger.error("wrong input types");
        }

        //update list- and tableView
        updateItemListView();
        updateItemTable();
    }

    @FXML
    public void editItem() {
        logger.info("clicked on edit item");

        if (newName.getText().isEmpty() && newWeight.getText().isEmpty() && newVolume.getText().isEmpty()
                && newValue.getText().isEmpty()) {
            logger.info("no fields to edit");
            return;
        } else if (selectedItem == null) {
            logger.error("no item found");
            return;
        }

        Item editedItem = selectedItem;
        if (!newName.getText().isEmpty()) {
            editedItem.setName(newName.getText());
            newName.clear();
        }
        if (!newWeight.getText().isEmpty()) {
            try {
                editedItem.setWeight(Integer.parseInt(newWeight.getText()));
                newWeight.clear();
            } catch (NumberFormatException exception) {
                logger.error("wrong input types for new weight");
            }
        }
        if (!newVolume.getText().isEmpty()) {
            try {
                editedItem.setVolume(Integer.parseInt(newVolume.getText()));
                newVolume.clear();
            } catch (NumberFormatException exception) {
                logger.error("wrong input types for new volume");
            }
        }
        if (!newValue.getText().isEmpty()) {
            try {
                editedItem.setValue(Integer.parseInt(newValue.getText()));
                newValue.clear();
            } catch (NumberFormatException exception) {
                logger.error("wrong input types for new value");
            }
        }
        //edit the entry in the database
        api.editItem(editedItem);

        //update list- and tableVie
        updateItemListView();
        updateItemTable();
    }

    @FXML
    public void removeItem() {
        logger.info("clicked on remove item");

        if (selectedItem == null) {
            logger.error("no item found");
            return;
        }

        int id = selectedItem.getId();
        api.removeItem(id);
        selectedItem = null;
        logger.info("removed item with id: " + id);

        //update list- and tableVie
        updateItemListView();
        updateItemTable();
    }

    /**
     * Updates the itemListView so that it shows the correspondent items depending on
     * if a defaultListView is set it shall retrieve all items or
     * if not as above choosing items corresponding to the currentItemIds
     */
    public void updateItemListView() {
        currentItems.clear();
        itemObservableList.clear();

        if (defaultListView) {
            currentItems.addAll(api.retrieveAllItems());
            if (currentItems.size() == 0) {
                logger.info("there are no inventories yet");
            }
        } else {
            currentItems.addAll(api.retrieveItems(currentItemIds));
        }

        itemObservableList.addAll(currentItems);

        itemListView.setItems(itemObservableList);
        itemListView.setCellFactory(new Callback<ListView<Item>, ListCell<Item>>() {
            @Override
            public ListCell<Item> call(ListView<Item> param) {
                return new ItemViewController.ItemCell();
            }
        });
    }

    /**
     * Updates the itemTableView so that it shows the correspondent item depending on
     * if there is no selected item try to get the first one from my currentItems list
     * if no entry in currentItems is found it shall clear the table
     * if there is a selectedItem it shall update its values by retrieving one from the api and use that
     */
    public void updateItemTable() {
        if (selectedItem == null) {
            try {
                selectedItem = currentItems.get(0);
            } catch (IndexOutOfBoundsException exception) {
                logger.info("no item loaded for selection");
                itemTable.getItems().clear();
                itemTable.refresh();
                return;
            }
        } else {
            selectedItem = api.retrieveItem(selectedItem.getId());
        }

        for (TableColumn<Item, String> column : columns) {
            column.setCellValueFactory(
                    new PropertyValueFactory<Item, String>(column.getText())
            );
        }
        itemTable.getItems().clear();
        itemTable.getItems().add(selectedItem);
    }

    public static void setApi(Api api) {
        ItemViewController.api = api;
    }

    private static class ItemCell extends ListCell<Item> {
        @Override
        protected void updateItem(final Item item, final boolean empty) {
            super.updateItem(item, empty);
            Label label = new Label();
            if (item != null) {
                label.setText(item.toString());
            }
            setGraphic(label);
        }
    }
}