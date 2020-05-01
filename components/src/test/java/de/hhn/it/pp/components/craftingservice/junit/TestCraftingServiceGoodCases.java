package de.hhn.it.pp.components.craftingservice.junit;

import de.hhn.it.pp.components.craftingservice.CraftingService;
import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
import de.hhn.it.pp.components.craftingservice.provider.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.provider.Inventory;
import de.hhn.it.pp.components.craftingservice.provider.Item;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A jUnit test class which tests the good cases of the CraftingService
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-05-01
 */
@DisplayName("Test the CraftingService with good cases.")
public class TestCraftingServiceGoodCases {
    CraftingService craftingService;
    Inventory testInventory;
    CraftingPattern craftedTestItem;
    ArrayList<Item> expectedItemsBeforeTestingOperations;

    @BeforeEach
    void setup() throws IllegalParameterException {
        // --- initialize Crafting Service and Inventory ---
        craftingService = new CraftingImplementation();
        testInventory = new Inventory(new ArrayList<Item>());
        expectedItemsBeforeTestingOperations = new ArrayList<>();

        // add some resources into the inventory
        craftingService.add(testInventory, new Item("Small Wood Plank"));
        craftingService.add(testInventory, new Item("Test Bar"));

        // make sure that the inventory contains exactly this expected items after added the resources
        expectedItemsBeforeTestingOperations.add(new Item("Small Wood Plank"));
        expectedItemsBeforeTestingOperations.add(new Item("Test Bar"));

        // --- initialize a sample Crafting Pattern ---
        // define name
        String name = "TestPattern: Crafted Test Item";
        // define crafting time
        int craftingTime = 500;
        // define needed items
        ArrayList<Item> neededItems = new ArrayList<>();
        neededItems.add(new Item("Test Bar"));
        // define provided items
        ArrayList<Item> providedItems = new ArrayList<>();
        providedItems.add(new Item("Crafted Test Item"));
        providedItems.add(new Item("Residue"));
        // create the crafting pattern
        craftedTestItem = new CraftingPattern(name, craftingTime, neededItems, providedItems);
    }

    @Test
    @DisplayName("add a new item into the inventory")
    void testSuccessfulAdding() throws IllegalParameterException {
        // test items before adding
        assertAll( // items in each list should be identical
                () -> assertEquals(expectedItemsBeforeTestingOperations.get(0).getName(),
                        testInventory.getItems().get(0).getName(),
                        "First item should be 'Small Wood Plank'"),
                () -> assertEquals(expectedItemsBeforeTestingOperations.get(1).getName(),
                        testInventory.getItems().get(1).getName(),
                        "Second item should be 'Test Bar'")
        );

        // add a new item into the inventory
        craftingService.add(testInventory, new Item("Tasty Chocolate Cookie"));

        // test items after adding
        ArrayList<Item> expectedItemsAfterAdding = new ArrayList<>();
        expectedItemsAfterAdding.add(new Item("Small Wood Plank"));
        expectedItemsAfterAdding.add(new Item("Test Bar"));
        expectedItemsAfterAdding.add(new Item("Tasty Chocolate Cookie"));

        assertAll( // items in each list should be identical
                () -> assertEquals(expectedItemsAfterAdding.get(0).getName(),
                        testInventory.getItems().get(0).getName(),
                        "First item should be 'Small Wood Plank'"),
                () -> assertEquals(expectedItemsAfterAdding.get(1).getName(),
                        testInventory.getItems().get(1).getName(),
                        "Second item should be 'Test Bar'"),
                () -> assertEquals(expectedItemsAfterAdding.get(2).getName(),
                        testInventory.getItems().get(2).getName(),
                        "Third item should be 'Tasty Chocolate Cookie'")
        );
    }

    @Test
    @DisplayName("remove an existing item from the inventory")
    void testSuccessfulRemoving() throws IllegalParameterException {
        // test items before removing
        assertAll( // items in each list should be identical
                () -> assertEquals(expectedItemsBeforeTestingOperations.get(0).getName(),
                        testInventory.getItems().get(0).getName(),
                        "First item should be 'Small Wood Plank'"),
                () -> assertEquals(expectedItemsBeforeTestingOperations.get(1).getName(),
                        testInventory.getItems().get(1).getName(),
                        "Second item should be 'Test Bar'")
        );

        // remove an existing item from the inventory
        craftingService.remove(testInventory, new Item("Small Wood Plank"));

        // test item after removing
        ArrayList<Item> expectedItemsAfterRemoving = new ArrayList<>();
        expectedItemsAfterRemoving.add(new Item("Test Bar"));

        // items in each list should be identical
        assertEquals(expectedItemsAfterRemoving.get(0).getName(), testInventory.getItems().get(0).getName(),
                "The item should be 'Test Bar'");
    }

    @Test
    @DisplayName("craft a pattern which implies the inventory")
    void testSuccessfulCraftingProcess() throws CraftingNotPossibleException, InterruptedException {
        // test items before crafting
        assertAll( // items in each list should be identical
                () -> assertEquals(expectedItemsBeforeTestingOperations.get(0).getName(),
                        testInventory.getItems().get(0).getName(),
                        "First item should be 'Small Wood Plank'"),
                () -> assertEquals(expectedItemsBeforeTestingOperations.get(1).getName(),
                        testInventory.getItems().get(1).getName(),
                        "Second item should be 'Test Bar'")
        );

        // craft the sample pattern
        craftingService.craft(testInventory, craftedTestItem);

        // wait until item is crafted before continuing
        CraftingImplementation.getCurrentThread().join();

        // test items after crafting
        ArrayList<Item> expectedItemsAfterCrafting = new ArrayList<>();
        expectedItemsAfterCrafting.add(new Item("Small Wood Plank"));
        expectedItemsAfterCrafting.add(new Item("Crafted Test Item"));
        expectedItemsAfterCrafting.add(new Item("Residue"));

        assertAll( // items in each list should be identical
                () -> assertEquals(expectedItemsAfterCrafting.get(0).getName(),
                        testInventory.getItems().get(0).getName(),
                        "First item should be 'Small Wood Plank'"),
                () -> assertEquals(expectedItemsAfterCrafting.get(1).getName(),
                        testInventory.getItems().get(1).getName(),
                        "Second item should be 'Crafted Test Item'"),
                () -> assertEquals(expectedItemsAfterCrafting.get(2).getName(),
                        testInventory.getItems().get(2).getName(),
                        "Third item should be 'Residue'")
        );
    }
}
