//package de.hhn.it.pp.components.craftingservice.junit;
//
//import de.hhn.it.pp.components.craftingservice.CraftingService;
//import de.hhn.it.pp.components.craftingservice.exceptions.CraftingNotPossibleException;
//import de.hhn.it.pp.components.craftingservice.provider.CraftingImplementation;
//import de.hhn.it.pp.components.craftingservice.provider.CraftingPattern;
//import de.hhn.it.pp.components.craftingservice.provider.Inventory;
//import de.hhn.it.pp.components.craftingservice.provider.Item;
//import de.hhn.it.pp.components.exceptions.IllegalParameterException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * A jUnit test class which tests the bad cases of the CraftingService
// * @author Oliver Koch, Philipp Alessandrini
// * @version 2020-05-01
// */
//@DisplayName("Test the CraftingService with bad cases.")
//public class TestCraftingServiceBadCases {
//    CraftingService craftingService;
//    Inventory testInventory;
//    CraftingPattern craftedTestCookie;
//
//    @BeforeEach
//    void setup() throws IllegalParameterException {
//        // --- initialize Crafting Service and Inventory ---
//        craftingService = new CraftingImplementation();
//        testInventory = new Inventory(new ArrayList<Item>());
//
//        // add some resources into the inventory
//        craftingService.add(testInventory, new Item("Test Recipe"));
//
//        // --- initialize a sample Crafting Pattern ---
//        // define name
//        String name = "TestPattern: Crafted Test Cookie";
//        // define crafting time
//        int craftingTime = 1000;
//        // define needed items
//        ArrayList<Item> neededItems = new ArrayList<>();
//        neededItems.add(new Item("Test Recipe"));
//        neededItems.add(new Item("Test Flour"));
//        // define provided items
//        ArrayList<Item> providedItems = new ArrayList<>();
//        providedItems.add(new Item("Crafted Test Cookie"));
//        // create the crafting pattern
//        craftedTestCookie = new CraftingPattern(name, craftingTime, neededItems, providedItems);
//    }
//
//    @Test
//    @DisplayName("add null referenced item into the inventory")
//    void testExceptionWhenAddingNullReference() throws IllegalParameterException {
//        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException
//                .class, () -> craftingService.add(testInventory, null));
//    }
//
//    @Test
//    @DisplayName("remove null referenced item from inventory")
//    void testExceptionWhenRemovingNullReference() throws IllegalParameterException {
//        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException
//                .class, () -> craftingService.remove(testInventory, null));
//    }
//
//    @Test
//    @DisplayName("remove item from empty inventory")
//    void testExceptionWhenRemovingInEmptyInventory() throws IllegalParameterException {
//        // remove last remaining item to make the inventory empty
//        craftingService.remove(testInventory, new Item("Test Recipe"));
//
//        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException
//                .class, () -> craftingService.remove(testInventory, new Item("Test Recipe")));
//    }
//
//    @Test
//    @DisplayName("remove item which doesn't exist in the inventory")
//    void testExceptionWhenRemovingNoExistingItem() throws IllegalParameterException {
//        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException
//                .class, () -> craftingService.remove(testInventory, new Item("Test Cookie")));
//    }
//
//    @Test
//    @DisplayName("craft null referenced crafting pattern")
//    void testExceptionWhenCraftingNullReference() throws CraftingNotPossibleException {
//        CraftingNotPossibleException craftingNotPossibleException = assertThrows(CraftingNotPossibleException
//                .class, () -> craftingService.craft(testInventory, null));
//    }
//
//    @Test
//    @DisplayName("try to craft a pattern which doesn't imply the inventory")
//    void testExceptionWhenItemsDontMatchPattern() throws CraftingNotPossibleException {
//        CraftingNotPossibleException craftingNotPossibleException = assertThrows(CraftingNotPossibleException
//                .class, () -> craftingService.craft(testInventory, craftedTestCookie));
//    }
//
//    @Test
//    @DisplayName("try to craft a pattern while another crafting process is ongoing")
//    void testExceptionWhenAnotherCraftingProcessOngoing() throws IllegalParameterException,
//            CraftingNotPossibleException {
//        // add enough resources into the inventory so that both (same) patterns are theoretically craftable
//        craftingService.add(testInventory, new Item("Test Recipe"));
//        craftingService.add(testInventory, new Item("Test Flour"));
//        craftingService.add(testInventory, new Item("Test Flour"));
//
//        // craft the first pattern
//        craftingService.craft(testInventory, craftedTestCookie);
//        // immediately try to craft the next pattern while the first one is still crafting
//        CraftingNotPossibleException craftingNotPossibleException = assertThrows(CraftingNotPossibleException
//                .class, () -> craftingService.craft(testInventory, craftedTestCookie));
//    }
//
//    @Test
//    @DisplayName("try to initialize a CraftingStartedNotification with less than six letters")
//    void testExceptionWhenCraftingStartedNotificationMessageIsTooShort() throws IllegalParameterException {
//        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException
//                .class, () -> craftingService.craftingStartedNotification("start"));
//    }
//
//    @Test
//    @DisplayName("try to initialize a CraftingEndedNotification with less than six letters")
//    void testExceptionWhenCraftingEndedNotificationMessageIsTooShort() throws IllegalParameterException {
//        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException
//                .class, () -> craftingService.craftingEndedNotification("end"));
//    }
//}
