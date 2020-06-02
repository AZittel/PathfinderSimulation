package de.hhn.it.pp.components.craftingservice.junit;

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
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * A jUnit test class which tests the bad cases of the CraftingService.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-10
 */
@DisplayName("Test the CraftingService with bad cases.")
public class TestCraftingServiceBadCases {
  CraftingService craftingService;
  Inventory testInventory;
  CraftingPattern tastyChocolateCookie;

  @BeforeEach
  void setup() throws IllegalParameterException {
    // initialize Crafting Service and Inventory
    craftingService = new CraftingImplementation();
    testInventory = new Inventory(new ArrayList<>());

    // add some resources into the inventory
    testInventory.add(new Item("Milk Chocolate"));
    testInventory.add(new Item("Flour"));

    // get a sample crafting pattern from the UsageDemo
    tastyChocolateCookie = CraftingServiceUsageDemo.tastyChocolateCookie();

    // add the sample pattern to the crafting service
    craftingService.addCraftingPattern(tastyChocolateCookie);
  }

  @Test
  @DisplayName("get null referenced crafting pattern ")
  void testExceptionWhenGettingNullReferencedPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class, () -> craftingService.getPattern(null));
  }

  @Test
  @DisplayName("get non existing crafting pattern ")
  void testExceptionWhenGettingNonExistingPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.getPattern("Non Existing Pattern"));
  }

  @Test
  @DisplayName("add null referenced pattern to the crafting service")
  void testExceptionWhenAddingNullReferencedPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.addCraftingPattern(null));
  }

  @Test
  @DisplayName("remove null referenced pattern from the crafting service")
  void testExceptionWhenRemovingNullReferencedPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.removeCraftingPattern(null));
  }

  @Test
  @DisplayName("remove non existing pattern from the crafting service")
  void testExceptionWhenRemovingNonExistingPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.removeCraftingPattern("Non Existing Pattern"));
  }

  @Test
  @DisplayName("remove pattern from empty crafting service list")
  void testExceptionWhenRemovingPatternFromEmptyList() throws IllegalParameterException,
      OperationNotSupportedException {
    // remove last remaining pattern - list should be empty now
    craftingService.removeCraftingPattern("Pattern: Tasty Chocolate Cookie");

    OperationNotSupportedException operationNotSupportedException = assertThrows(
        OperationNotSupportedException.class,
        () -> craftingService.removeCraftingPattern("Any Pattern"));
  }

  @Test
  @DisplayName("craft null referenced crafting pattern")
  void testExceptionWhenCraftingNullReference() {
    CraftingNotPossibleException craftingNotPossibleException = assertThrows(
        CraftingNotPossibleException.class,
        () -> craftingService.craft(testInventory, null));
  }

  @Test
  @DisplayName("try to craft a pattern which doesn't imply the inventory")
  void testExceptionWhenItemsDontMatchPattern() {
    CraftingNotPossibleException craftingNotPossibleException = assertThrows(
        CraftingNotPossibleException.class,
        () -> craftingService.craft(testInventory, tastyChocolateCookie));
  }

  @Test
  @DisplayName("try to craft a pattern while another crafting process is ongoing")
  void testExceptionWhenAnotherCraftingProcessOngoing() throws IllegalParameterException,
      InterruptedException, CraftingNotPossibleException {
    // add enough resources into the inventory
    // so that both (same) patterns are theoretically craftable
    testInventory.add(new Item("Egg"));
    testInventory.add(new Item("Egg"));
    testInventory.add(new Item("Milk Chocolate"));
    testInventory.add(new Item("Flour"));

    // craft the first pattern
    craftingService.craft(testInventory, tastyChocolateCookie);

    // immediately try to craft the next pattern while the first one is still crafting
    CraftingNotPossibleException craftingNotPossibleException = assertThrows(
        CraftingNotPossibleException.class,
        () -> craftingService.craft(testInventory, tastyChocolateCookie));

    // wait until the first crafting thread has finished
    CraftingImplementation.getCurrentThread().join();
  }

  @Test
  @DisplayName("add a null referenced listener")
  void testExceptionWhenAddingNullReferencedListener() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.addListener(null));
  }

  @Test
  @DisplayName("remove null referenced listener")
  void testExceptionWhenRemovingNullReferencedListener() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.removeListener(null));
  }

  @Test
  @DisplayName("remove non existing listener")
  void testExceptionWhenRemovingNonExistingListener() throws IllegalParameterException {
    // add a listener for a crafting process
    craftingService.addListener(CraftingImplementation.getCallbackNotificator());

    // create another callback listener
    CraftingListener anotherListener = new Callback();

    // try to remove a listener from another crafting process which doesn't exist
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> craftingService.removeListener(anotherListener));
  }
}
