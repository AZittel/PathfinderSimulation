package de.hhn.it.pp.components.craftingservice.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hhn.it.pp.components.craftingservice.CraftingListener;
import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.exceptions.NoActiveListenerException;
import de.hhn.it.pp.components.craftingservice.provider.Callback;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.craftingservice.provider.CraftingPatternManager;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * A jUnit test class which tests the crafting listener.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-27
 */
@DisplayName("Test the crafting listener.")
public class TestCraftingListener {
  CraftingListener callbackMechanism;
  CraftingService craftingService;
  Inventory testInventory;
  // create the manager class for the specific patterns
  CraftingPatternManager patternManager = new CraftingPatternManager();
  CraftingPattern testPattern;
  
  @BeforeEach
  void setup() throws IllegalParameterException {
    // initialization
    callbackMechanism = new Callback();
    craftingService = new CraftingImplementation();
    testInventory = new Inventory(new ArrayList<>());
    patternManager = new CraftingPatternManager();
    
    // add some resources into the inventory
    testInventory.add(new Item("Test Item 1"));
    testInventory.add(new Item("Test Item 1"));
    testInventory.add(new Item("Test Item 2"));
    
    // get a sample crafting pattern from the UsageDemo
    testPattern = patternManager.createTestPattern(new ArrayList<>(), new ArrayList<>());
    
    // add the sample pattern to the crafting service
    craftingService.addCraftingPattern(testPattern);
  }
  
  @Test
  @DisplayName("'craftingStartedNotification' with null referenced crafting pattern")
  void testExceptionWhenNullReferencedStartingNotification() {
    assertThrows(IllegalParameterException.class,
        () -> callbackMechanism.craftingStartedNotification(null));
  }
  
  @Test
  @DisplayName("'craftingEndedNotification' with null referenced crafting pattern")
  void testExceptionWhenNullReferencedEndingNotification() {
    assertThrows(IllegalParameterException.class,
        () -> callbackMechanism.craftingEndedNotification(null));
  }
  
  @Test
  @DisplayName("test the callback notification mechanism during a crafting process")
  void testCallbackNotificationDuringCrafting() throws CraftingNotPossibleException,
                                                           InterruptedException,
                                                           NoActiveListenerException {
    // there should be no listener at the beginning
    assertThrows(NoActiveListenerException.class, CraftingImplementation::getListener);
    
    // craft the sample pattern
    craftingService.craft(testInventory, testPattern);
    
    // now there should be an active listener for this crafting process
    assertEquals(CraftingImplementation.getCallbackNotificator(),
        CraftingImplementation.getListener(),
        "There should be a callback listener currently'");
    
    // wait until crafting is done
    CraftingImplementation.getCurrentThread().join();
    
    // there should be no listener again
    assertThrows(NoActiveListenerException.class, CraftingImplementation::getListener);
  }
}