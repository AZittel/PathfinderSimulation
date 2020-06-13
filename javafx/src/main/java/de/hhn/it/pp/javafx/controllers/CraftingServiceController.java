package de.hhn.it.pp.javafx.controllers;

import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.craftingservice.provider.CraftingPatternManager;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

/**
 * Controller class of the UI-Elements.
 *
 * @author Olver Koch, Philipp Alessandrini
 * @version 2020-06-13
 */
public class CraftingServiceController extends Controller implements Initializable {
  private static final org.slf4j.Logger logger =
      org.slf4j.LoggerFactory.getLogger(CraftingServiceController.class);
  @FXML
  TableView<Item> itemTableView;
  @FXML
  TableColumn<Item, String> nameCol;
  @FXML
  Button addBtn;
  @FXML
  Button removeBtn;
  @FXML
  Button craftBtn;
  @FXML
  ComboBox<Item> itemComboBox;
  @FXML
  ComboBox<CraftingPattern> patternComboBox;
  @FXML
  ListView<Item> neededItemsListView;
  @FXML
  ListView<Item> providedItemsListView;
  @FXML
  Label isCraftingExecutableLbl;
  @FXML
  Label craftingTimeLbl;
  @FXML
  ProgressBar progressBar;

  private CraftingService craftingService;
  private Inventory inventory;

  /**
   * Constructor which implements all UI-Elements.
   */
  public CraftingServiceController() {
    itemTableView = new TableView<>();
    addBtn = new Button();
    removeBtn = new Button();
    craftBtn = new Button();
    itemComboBox = new ComboBox<>();
    patternComboBox = new ComboBox<>();
    neededItemsListView = new ListView<>();
    providedItemsListView = new ListView<>();
    isCraftingExecutableLbl = new Label();
    craftingTimeLbl = new Label();
    progressBar = new ProgressBar();

    craftingService = new CraftingImplementation();
    inventory = new Inventory(FXCollections.observableArrayList());
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    initComboBoxItems();
    initComboBoxPatterns();
  }

  /**
   * Defines actions when pressing the add - button.
   * @param event the mouse click
   */
  public void onAdd(ActionEvent event) {
    // add the focused item from the 'itemComboBox' in the inventory
    try {
      inventory.add(itemComboBox.getValue());
    } catch (IllegalParameterException e) {
      e.getMessage();
    }
    nameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().toString()));
    itemTableView.setItems((ObservableList<Item>) inventory.getItems());

    // check if chosen pattern can be crafted
    checkCraftable();
  }

  /**
   * Defines actions when pressing the remove - button.
   * @param event the mouse click
   */
  public void onRemove(ActionEvent event) {
    // remove the selected row
    try {
      inventory.remove(itemTableView.getSelectionModel().getSelectedItem());
    } catch (IllegalParameterException | OperationNotSupportedException e) {
      e.getMessage();
    }
    itemTableView.setItems((ObservableList<Item>) inventory.getItems());

    // check if chosen pattern can be crafted
    checkCraftable();
  }

  /**
   * Defines actions when pressing the craft - button.
   * @param event the mouse click
   */
  public void onCraft(ActionEvent event) {
    // show the user that there is an ongoing crafting process
    craftBtn.setOpacity(0.4);
    craftBtn.setDisable(true);
    isCraftingExecutableLbl.setTextFill(Color.BLUE);
    isCraftingExecutableLbl.setText("Crafting is ongoing");
    // a task-thread that observes the crafting process
    Task<Void> task = new Task<>() {
      @Override
      public Void call() throws Exception {
        try {
          // start crafting
          craftingService.craft(inventory, patternComboBox.getValue());
          // update progress bar according to the crafting time
          for (int i = 0; i < (patternComboBox.getValue().getCraftingTime() / 100); i++) {
            Thread.sleep(100);
            updateProgress(i + 1,
                patternComboBox.getValue().getCraftingTime() / 100);
          }
          CraftingImplementation.getCurrentThread().join();
        } catch (CraftingNotPossibleException e) {
          e.getMessage();
        }
        return null;
      }
    };
    // after the crafting process is complete
    task.setOnSucceeded(e -> {
      itemTableView.setItems((ObservableList<Item>) inventory.getItems());
      checkCraftable();
      // inform the user that the crafting process has finished
      craftingEndedInfo(patternComboBox.getValue());
      // reset the progress bar
      progressBar.progressProperty().unbind();
      progressBar.setProgress(0);
    });
    progressBar.progressProperty().bind(task.progressProperty());
    new Thread(task).start();
  }

  /**
   * Defines actions when choosing a pattern from the 'patternComboBox'.
   * @param event the mouse click
   */
  public void onChoosePattern(ActionEvent event) {
    // update needed and provided items for the chosen pattern
    neededItemsListView.setItems((ObservableList<Item>)
                                     patternComboBox.getValue().getNeededItems());
    providedItemsListView.setItems((ObservableList<Item>)
                                     patternComboBox.getValue().getProvidedItems());

    // get crafting time of the chosen pattern
    DecimalFormat df = new DecimalFormat("#.00");
    craftingTimeLbl.setText("Crafting time: "
                                + df.format(
                                    (float) patternComboBox.getValue().getCraftingTime()
                                        / 1000)
                                + " seconds");
    // check if chosen pattern can be crafted
    checkCraftable();
  }

  private void checkCraftable() {
    // check if chosen pattern can be crafted
    try {
      if (patternComboBox.getValue().isCraftable(inventory)) {
        craftBtn.setOpacity(1.0);
        craftBtn.setDisable(false);
        isCraftingExecutableLbl.setTextFill(Color.GREEN);
        isCraftingExecutableLbl.setText("Crafting is executable");
      } else {
        craftBtn.setOpacity(0.4);
        craftBtn.setDisable(true);
        isCraftingExecutableLbl.setTextFill(Color.RED);
        isCraftingExecutableLbl.setText("Crafting is not executable");
      }
    } catch (NullPointerException e) {
      // ignore exception
    }
  }

  private void initComboBoxItems() {
    // add items to the ComboBox
    itemComboBox.setItems(FXCollections.observableArrayList(
        new Item("Small Wood Plank"),
        new Item("Medium Iron Bar"),
        new Item("Fiery Essence"),
        new Item("Magical Essence"),
        new Item("Essence Of Endlessness"),
        new Item("Egg"),
        new Item("Flour"),
        new Item("Milk Chocolate")
    ));
  }

  private void initComboBoxPatterns() {
    // initialize crafting patterns
    CraftingPatternManager patternManager = new CraftingPatternManager();
    try {
      craftingService.addCraftingPattern(patternManager.createWoodenAxe(
          FXCollections.observableArrayList(), FXCollections.observableArrayList()));
      craftingService.addCraftingPattern(patternManager.createLargeIronSword(
          FXCollections.observableArrayList(), FXCollections.observableArrayList()));
      craftingService.addCraftingPattern(patternManager.createSmallMagicalWand(
          FXCollections.observableArrayList(), FXCollections.observableArrayList()));
      craftingService.addCraftingPattern(patternManager.createFierySword(
          FXCollections.observableArrayList(), FXCollections.observableArrayList()));
      craftingService.addCraftingPattern(patternManager.createTastyChocolateCookie(
          FXCollections.observableArrayList(), FXCollections.observableArrayList()));
      craftingService.addCraftingPattern(patternManager.createEndlessTastyChocolateCookies(
          FXCollections.observableArrayList(), FXCollections.observableArrayList()));
    } catch (IllegalParameterException e) {
      e.getMessage();
    }
    // add patterns to the ComboBox
    try {
      patternComboBox.setItems(FXCollections.observableArrayList(
          craftingService.getPattern("Pattern: Wooden Axe"),
          craftingService.getPattern("Pattern: Large Iron Sword"),
          craftingService.getPattern("Pattern: Small Magical Wand"),
          craftingService.getPattern("Pattern: Fiery Sword"),
          craftingService.getPattern("Pattern: Tasty Chocolate Cookie"),
          craftingService.getPattern("Pattern: Endless Tasty Chocolate Cookies")
      ));
    } catch (IllegalParameterException e) {
      e.getMessage();
    }
  }

  private void craftingEndedInfo(CraftingPattern craftedPattern) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Crafting has ended");
    alert.setHeaderText(null);
    alert.setContentText("'" + craftedPattern.toString() + "' successfully crafted!");
    alert.showAndWait();
  }
}