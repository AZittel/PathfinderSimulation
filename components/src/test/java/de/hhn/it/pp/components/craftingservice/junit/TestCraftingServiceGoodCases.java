package de.hhn.it.pp.components.craftingservice.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.CraftingServiceUsageDemo;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A jUnit test class which tests the good cases of the CraftingService.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-10
 */
@DisplayName("Test the CraftingService with good cases.")
public class TestCraftingServiceGoodCases {
  CraftingService craftingService;
  Inventory testInventory;
  CraftingPattern tastyChocolateCookie;
  ArrayList<Item> expectedItemsBeforeTestingOperations;
  ArrayList<String> expectedPatternNamesBeforeTestingOperations;

  @BeforeEach
  void setup() throws IllegalParameterException {
    // initialize Crafting Service and Inventory
    craftingService = new CraftingImplementation();
    testInventory = new Inventory(new ArrayList<>());
    expectedItemsBeforeTestingOperations = new ArrayList<>();
    expectedPatternNamesBeforeTestingOperations = new ArrayList<>();

    // add some resources into the inventory
    testInventory.add(new Item("Egg"));
    testInventory.add(new Item("Milk Chocolate"));
    testInventory.add(new Item("Flour"));

    // make sure that the inventory contains exactly this expected items after added the resources
    expectedItemsBeforeTestingOperations.add(new Item("Egg"));
    expectedItemsBeforeTestingOperations.add(new Item("Milk Chocolate"));
    expectedItemsBeforeTestingOperations.add(new Item("Flour"));

    // get a sample crafting pattern from the UsageDemo
    tastyChocolateCookie = CraftingServiceUsageDemo.tastyChocolateCookie();

    // add the sample pattern to the crafting service
    craftingService.addCraftingPattern(tastyChocolateCookie);

    // make sure that the crafting service contains exactly this expected patterns
    // after initialized the sample pattern
    expectedPatternNamesBeforeTestingOperations.add("Pattern: Tasty Chocolate Cookie");
  }

  @Test
  @DisplayName("get list of pattern-names")
  void testSuccessfulGettingPatternNames() {
    // compare pattern names
    assertEquals(expectedPatternNamesBeforeTestingOperations.get(0),
        craftingService.getPatternNames().get(0),
        "The only pattern should be 'Pattern: Tasty Chocolate Cookie'");
  }

  @Test
  @DisplayName("get a specific pattern")
  void testSuccessfulGettingPattern() throws IllegalParameterException {
    // compare patterns
    assertEquals(tastyChocolateCookie,
        craftingService.getPattern("Pattern: Tasty Chocolate Cookie"),
        "Pattern should be 'Pattern: Tasty Chocolate Cookie'");
  }

  @Test
  @DisplayName("add a new crafting pattern to the crafting service")
  void testSuccessfulAddingPattern() throws IllegalParameterException {
    // compare pattern before adding
    assertEquals(expectedPatternNamesBeforeTestingOperations.get(0),
        craftingService.getPatternNames().get(0),
        "Pattern should be 'Pattern: Tasty Chocolate Cookie'");

    // get another sample crafting pattern from the UsageDemo
    CraftingPattern largeIronSword = CraftingServiceUsageDemo.largeIronSword();

    // add this pattern to the crafting service
    craftingService.addCraftingPattern(largeIronSword);

    // compare patterns after adding
    ArrayList<String> expectedPatternNamesAfterAdding = new ArrayList<>();
    expectedPatternNamesAfterAdding.add("Pattern: Large Iron Sword");
    expectedPatternNamesAfterAdding.add("Pattern: Tasty Chocolate Cookie");

    // patterns in each list should be identical
    assertAll(
        () -> assertEquals(expectedPatternNamesAfterAdding.get(0),
            craftingService.getPatternNames().get(0),
            "First pattern should be 'Pattern: Large Iron Sword'"),
        () -> assertEquals(expectedPatternNamesAfterAdding.get(1),
            craftingService.getPatternNames().get(1),
            "Second pattern should be 'Pattern: Tasty Chocolate Cookie'")
    );
  }

  @Test
  @DisplayName("remove an existing pattern from the crafting service")
  void testSuccessfulRemovingPattern() throws IllegalParameterException,
      OperationNotSupportedException {
    // compare pattern before removing
    assertEquals(expectedPatternNamesBeforeTestingOperations.get(0),
        craftingService.getPatternNames().get(0),
        "First pattern should be 'Pattern: Tasty Chocolate Cookie'");

    // remove an existing pattern from the crafting service
    craftingService.removeCraftingPattern("Pattern: Tasty Chocolate Cookie");

    // compare lists after removing (they should be empty now)
    ArrayList<String> expectedPatternNamesAfterRemoving = new ArrayList<>();

    // compare lists - they should be empty now
    assertEquals(expectedPatternNamesAfterRemoving,
        craftingService.getPatternNames(),
        "There should be no items'");
  }

  @Test
  @DisplayName("craft a pattern which implies the inventory")
  void testSuccessfulCraftingProcess() throws CraftingNotPossibleException, InterruptedException {
    // compare items before crafting
    // items in each list should be identical
    assertAll(
        () -> assertEquals(expectedItemsBeforeTestingOperations.get(0).getName(),
            testInventory.getItems().get(0).getName(),
            "First item should be 'Egg'"),
        () -> assertEquals(expectedItemsBeforeTestingOperations.get(1).getName(),
            testInventory.getItems().get(1).getName(),
            "Second item should be 'Milk Chocolate'"),
        () -> assertEquals(expectedItemsBeforeTestingOperations.get(2).getName(),
            testInventory.getItems().get(2).getName(),
            "Third item should be 'Flour'")
    );

    // craft the sample pattern
    craftingService.craft(testInventory, tastyChocolateCookie);

    // wait until item is crafted before continuing
    CraftingImplementation.getCurrentThread().join();

    // compare items after crafting
    ArrayList<Item> expectedItemsAfterCrafting = new ArrayList<>();
    expectedItemsAfterCrafting.add(new Item("Tasty Chocolate Cookie"));
    expectedItemsAfterCrafting.add(new Item("Baking Powder"));

    // items in each list should be identical
    assertAll(
        () -> assertEquals(expectedItemsAfterCrafting.get(0).getName(),
            testInventory.getItems().get(0).getName(),
            "First item should be 'Tasty Chocolate Cookie'"),
        () -> assertEquals(expectedItemsAfterCrafting.get(1).getName(),
            testInventory.getItems().get(1).getName(),
            "Second item should be 'Baking Powder'")
    );
  }

  @Test
  @DisplayName("add a new listener")
  void testSuccessfulAddingListener() throws IllegalParameterException {
    // listener should be null at the beginning
    assertNull(CraftingImplementation.getListener(),
        "Listener should not be initialized yet");

    // add a listener
    craftingService.addListener(CraftingImplementation.getCallbackNotificator());

    // compare listeners
    assertEquals(CraftingImplementation.getCallbackNotificator(),
        CraftingImplementation.getListener(),
        "There should be the callback notificator now");
  }

  @Test
  @DisplayName("remove a current listener")
  void testSuccessfulRemovingListener() throws IllegalParameterException {
    // add a listener
    craftingService.addListener(CraftingImplementation.getCallbackNotificator());

    // compare listener after adding
    assertEquals(CraftingImplementation.getCallbackNotificator(),
        CraftingImplementation.getListener(),
        "There should be a callback listener currently'");

    // remove the listener
    craftingService.removeListener(CraftingImplementation.getCallbackNotificator());

    // compare listeners after removing
    assertNull(CraftingImplementation.getListener(),
        "There should be no initialized listener now'");
  }
}
