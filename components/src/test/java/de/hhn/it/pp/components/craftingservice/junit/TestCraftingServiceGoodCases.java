package de.hhn.it.pp.components.craftingservice.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.exceptions.NoActiveListenerException;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.craftingservice.provider.CraftingPatternManager;
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
 * @version 2020-06-27
 */
@DisplayName("Test the CraftingService with good cases.")
public class TestCraftingServiceGoodCases {
  CraftingService craftingService;
  Inventory testInventory;
  CraftingPatternManager patternManager;
  CraftingPattern testPattern;
  ArrayList<String> expectedPatternNamesBeforeTestingOperations;
  
  @BeforeEach
  void setup() throws IllegalParameterException {
    // initialize Crafting Service and Inventory
    craftingService = new CraftingImplementation();
    testInventory = new Inventory(new ArrayList<>());
    patternManager = new CraftingPatternManager();
    expectedPatternNamesBeforeTestingOperations = new ArrayList<>();
    
    // add some resources into the inventory
    testInventory.add(new Item("Test Item 1"));
    testInventory.add(new Item("Test Item 1"));
    testInventory.add(new Item("Test Item 2"));
    
    // get a sample crafting pattern
    testPattern = patternManager.createTestPattern(new ArrayList<>(), new ArrayList<>());
    
    // add the sample pattern to the crafting service
    craftingService.addCraftingPattern(testPattern);
    
    // make sure that the crafting service contains exactly this expected patterns
    // after initialized the sample pattern
    expectedPatternNamesBeforeTestingOperations.add("Pattern: Test Pattern");
  }
  
  @Test
  @DisplayName("get list of pattern-names")
  void testSuccessfulGettingPatternNames() {
    // compare pattern names
    assertEquals(expectedPatternNamesBeforeTestingOperations.get(0),
        craftingService.getPatternNames().get(0),
        "The only pattern should be 'Pattern: Test Pattern'");
  }
  
  @Test
  @DisplayName("get a specific pattern")
  void testSuccessfulGettingPattern() throws IllegalParameterException {
    // compare patterns
    assertEquals(testPattern,
        craftingService.getPattern("Pattern: Test Pattern"),
        "Pattern should be 'Pattern: Test Pattern'");
  }
  
  @Test
  @DisplayName("add a new crafting pattern to the crafting service")
  void testSuccessfulAddingPattern() throws IllegalParameterException {
    // compare pattern before adding
    assertEquals(expectedPatternNamesBeforeTestingOperations.get(0),
        craftingService.getPatternNames().get(0),
        "Pattern should be 'Pattern: Test Pattern'");
    
    // get another sample crafting pattern from the UsageDemo
    CraftingPattern largeIronSword = patternManager.createLargeIronSword(new ArrayList<>(),
        new ArrayList<>());
    
    // add this pattern to the crafting service
    craftingService.addCraftingPattern(largeIronSword);
    
    // compare patterns after adding
    ArrayList<String> expectedPatternNamesAfterAdding = new ArrayList<>();
    expectedPatternNamesAfterAdding.add("Pattern: Large Iron Sword");
    expectedPatternNamesAfterAdding.add("Pattern: Test Pattern");
    
    // patterns in each list should be identical
    assertAll(
        () -> assertEquals(expectedPatternNamesAfterAdding.get(0),
            craftingService.getPatternNames().get(0),
            "First pattern should be 'Pattern: Large Iron Sword'"),
        () -> assertEquals(expectedPatternNamesAfterAdding.get(1),
            craftingService.getPatternNames().get(1),
            "Second pattern should be 'Pattern: Test Pattern'")
    );
  }
  
  @Test
  @DisplayName("remove an existing pattern from the crafting service")
  void testSuccessfulRemovingPattern() throws IllegalParameterException,
                                                  OperationNotSupportedException {
    // compare pattern before removing
    assertEquals(expectedPatternNamesBeforeTestingOperations.get(0),
        craftingService.getPatternNames().get(0),
        "First pattern should be 'Pattern: Test Pattern'");
    
    // remove an existing pattern from the crafting service
    craftingService.removeCraftingPattern("Pattern: Test Pattern");
    
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
    // craft the sample pattern
    craftingService.craft(testInventory, testPattern);
    
    // wait until item is crafted before continuing
    CraftingImplementation.getCurrentThread().join();
    
    // compare items after crafting
    ArrayList<Item> expectedItemsAfterCrafting = new ArrayList<>();
    expectedItemsAfterCrafting.add(new Item("Test Pattern"));
    expectedItemsAfterCrafting.add(new Item("Test Remains"));
    
    // items in each list should be identical
    assertAll(
        () -> assertEquals(expectedItemsAfterCrafting.get(0).toString(),
            testInventory.getItems().get(0).toString(),
            "First item should be 'Test Pattern'"),
        () -> assertEquals(expectedItemsAfterCrafting.get(1).toString(),
            testInventory.getItems().get(1).toString(),
            "Second item should be 'Test Remains'")
    );
  }
  
  @Test
  @DisplayName("add a new listener")
  void testSuccessfulAddingListener() throws IllegalParameterException, NoActiveListenerException {
    // there should be no listener at the beginning
    assertThrows(NoActiveListenerException.class, CraftingImplementation::getListener);
    
    // add a listener
    craftingService.addListener(CraftingImplementation.getCallbackNotificator());
    
    // compare listeners
    assertEquals(CraftingImplementation.getCallbackNotificator(),
        CraftingImplementation.getListener(),
        "There should be the callback notificator now");
  }
  
  @Test
  @DisplayName("remove a current listener")
  void testSuccessfulRemovingListener() throws IllegalParameterException,
                                                   NoActiveListenerException {
    // add a listener
    craftingService.addListener(CraftingImplementation.getCallbackNotificator());
    
    // compare listener after adding
    assertEquals(CraftingImplementation.getCallbackNotificator(),
        CraftingImplementation.getListener(),
        "There should be a callback listener currently'");
    
    // remove the listener
    craftingService.removeListener(CraftingImplementation.getCallbackNotificator());
    
    // there should be no listener after the deletion
    assertThrows(NoActiveListenerException.class, CraftingImplementation::getListener);
  }
}