package de.hhn.it.pp.components.craftingservice.junit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hhn.it.pp.components.craftingservice.CraftingListener;
import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.CraftingServiceUsageDemo;
import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.provider.Callback;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * A jUnit test class which tests the crafting listener.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-10
 */
@DisplayName("Test the crafting listener.")
public class TestCraftingListener {
  CraftingListener callbackMechanism;
  CraftingService craftingService;
  Inventory testInventory;
  CraftingPattern tastyChocolateCookie;

  @BeforeEach
  void setup() throws IllegalParameterException {
    // initialization
    callbackMechanism = new Callback();
    craftingService = new CraftingImplementation();
    testInventory = new Inventory(new ArrayList<>());

    // add some resources into the inventory
    testInventory.add(new Item("Egg"));
    testInventory.add(new Item("Milk Chocolate"));
    testInventory.add(new Item("Flour"));

    // get a sample crafting pattern from the UsageDemo
    tastyChocolateCookie = CraftingServiceUsageDemo.tastyChocolateCookie();

    // add the sample pattern to the crafting service
    craftingService.addCraftingPattern(tastyChocolateCookie);
  }

  @Test
  @DisplayName("'craftingStartedNotification' with null referenced crafting pattern")
  void testExceptionWhenNullReferencedStartingNotification() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> callbackMechanism.craftingStartedNotification(null));
  }

  @Test
  @DisplayName("'craftingEndedNotification' with null referenced crafting pattern")
  void testExceptionWhenNullReferencedEndingNotification() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> callbackMechanism.craftingEndedNotification(null));
  }

  @Test
  @DisplayName("test the callback notification mechanism during a crafting process")
  void testCallbackNotificationDuringCrafting() throws CraftingNotPossibleException,
      InterruptedException {
    // listener should be null at the beginning
    assertNull(CraftingImplementation.getListener(),
        "Listener should not be initialized yet");

    // craft the sample pattern
    craftingService.craft(testInventory, tastyChocolateCookie);

    // now there should be an active listener for this crafting process
    assertNotNull(CraftingImplementation.getListener(),
        "Listener should be initialized now");

    // wait until crafting is done
    CraftingImplementation.getCurrentThread().join();

    // listener should be null again
    assertNull(CraftingImplementation.getListener(),
        "Listener should not be initialized again");
  }
}