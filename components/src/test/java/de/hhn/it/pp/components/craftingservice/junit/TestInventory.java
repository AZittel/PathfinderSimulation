package de.hhn.it.pp.components.craftingservice.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import de.hhn.it.pp.components.craftingservice.Inventory;
import de.hhn.it.pp.components.craftingservice.Item;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.exceptions.OperationNotSupportedException;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * A jUnit test class which tests the Inventory.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-15
 */
@DisplayName("Test the inventory.")
public class TestInventory {
  Inventory testInventory;

  @BeforeEach
  void setup() throws IllegalParameterException {
    // initialize Inventory
    testInventory = new Inventory(new ArrayList<>());
    // add some resources into the inventory
    testInventory.add(new Item("Fiery Sword"));
  }

  @Test
  @DisplayName("add null referenced item into the inventory")
  void testExceptionWhenGettingNullReferencedPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class, () -> testInventory.add(null));
  }

  @Test
  @DisplayName("remove null referenced item")
  void testExceptionWhenGettingNonExistingPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class, () -> testInventory.remove(null));
  }

  @Test
  @DisplayName("remove from empty inventory")
  void testExceptionWhenAddingNullReferencedPattern() throws IllegalParameterException,
      OperationNotSupportedException {
    // remove last item to empty the inventory
    testInventory.remove(new Item("Fiery Sword"));

    OperationNotSupportedException operationNotSupportedException = assertThrows(
        OperationNotSupportedException.class,
        () -> testInventory.remove(new Item("Non Existing Item")));
  }

  @Test
  @DisplayName("remove non existing item")
  void testExceptionWhenRemovingNullReferencedPattern() {
    IllegalParameterException illegalParameterException = assertThrows(
        IllegalParameterException.class,
        () -> testInventory.remove(new Item("Non Existing Item")));
  }
}
