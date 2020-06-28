package de.hhn.it.pp.components.craftingservice.junit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import de.hhn.it.pp.components.craftingservice.CraftingPattern;
import de.hhn.it.pp.components.craftingservice.provider.CraftingPatternManager;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


/**
 * A jUnit test class which tests the CraftingPatternManager - Class.
 *
 * @author Oliver Koch, Philipp Alessandrini
 * @version 2020-06-27
 */
@DisplayName("Test the CraftingPatternManager.")
public class TestCraftingPatternManager {
    CraftingPatternManager patternManager;

    @BeforeEach
    void setup() {
        // initialize the CraftingPatternManager
        patternManager = new CraftingPatternManager();
    }

    @Test
    @DisplayName("create a 'Pattern: Large Iron Sword'")
    void testCreateLargeIronSword() {
        // create the pattern with the manager-class
        CraftingPattern largeIronSword = patternManager.createLargeIronSword(new ArrayList<>(),
                new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Large Iron Sword",
                largeIronSword.toString(),
                "Patterns name should be 'Pattern: Test Pattern'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Small Wood Plank", largeIronSword.getNeededItems().get(0).toString(),
                        "First needed item should be 'Small Wood Plank'"),
                () -> assertEquals(
                        "Medium Iron Bar", largeIronSword.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Medium Iron Bar'"),
                () -> assertEquals(
                        "Medium Iron Bar", largeIronSword.getNeededItems().get(2).toString(),
                        "Third needed item should be 'Medium Iron Bar'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Large Iron Sword", largeIronSword.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Large Iron Sword'"),
                () -> assertEquals(
                        "Hot Ash", largeIronSword.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Hot Ash'"),
                () -> assertEquals(
                        "Hot Ash", largeIronSword.getProvidedItems().get(2).toString(),
                        "Third provided item should be 'Hot Ash'")
        );

        // check if the crafting time has the expected value
        assertEquals(3000, largeIronSword.getCraftingTime(),
                "Crafting time of this pattern should be: 3000 msec");
    }

    @Test
    @DisplayName("create a 'Pattern: Small Magical Wand'")
    void testCreateSmallMagicalWand() {
        // create the pattern with the manager-class
        CraftingPattern smallMagicalWand = patternManager.createSmallMagicalWand(new ArrayList<>(),
                new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Small Magical Wand",
                smallMagicalWand.toString(),
                "Patterns name should be 'Pattern: Small Magical Wand'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Small Wood Plank", smallMagicalWand.getNeededItems().get(0).toString(),
                        "First needed item should be 'Small Wood Plank'"),
                () -> assertEquals(
                        "Magical Essence", smallMagicalWand.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Magical Essence'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Small Magical Wand", smallMagicalWand.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Small Magical Wand'"),
                () -> assertEquals(
                        "Consumed Essence", smallMagicalWand.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Consumed Essence'")
        );

        // check if the crafting time has the expected value
        assertEquals(2000, smallMagicalWand.getCraftingTime(),
                "Crafting time of this pattern should be: 2000 msec");
    }

    @Test
    @DisplayName("create a 'Pattern: Wooden Axe'")
    void testCreateWoodenAxe() {
        // create the pattern with the manager-class
        CraftingPattern woodenAxe = patternManager.createWoodenAxe(new ArrayList<>(),
                new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Wooden Axe",
                woodenAxe.toString(),
                "Patterns name should be 'Pattern: Wooden Axe'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Small Wood Plank", woodenAxe.getNeededItems().get(0).toString(),
                        "First needed item should be 'Small Wood Plank'"),
                () -> assertEquals(
                        "Small Wood Plank", woodenAxe.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Small Wood Plank'"),
                () -> assertEquals(
                        "Small Wood Plank", woodenAxe.getNeededItems().get(2).toString(),
                        "Third needed item should be 'Small Wood Plank'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Wooden Axe", woodenAxe.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Wooden Axe'"),
                () -> assertEquals(
                        "Hot Ash", woodenAxe.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Hot Ash'")
        );

        // check if the crafting time has the expected value
        assertEquals(2500, woodenAxe.getCraftingTime(),
                "Crafting time of this pattern should be: 2500 msec");
    }

    @Test
    @DisplayName("create a 'Pattern: Fiery Sword'")
    void testCreateFierySword() {
        // create the pattern with the manager-class
        CraftingPattern fierySword = patternManager.createFierySword(new ArrayList<>(),
                new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Fiery Sword",
                fierySword.toString(),
                "Patterns name should be 'Pattern: Fiery Sword'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Large Iron Sword", fierySword.getNeededItems().get(0).toString(),
                        "First needed item should be 'Large Iron Sword'"),
                () -> assertEquals(
                        "Fiery Essence", fierySword.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Fiery Essence'"),
                () -> assertEquals(
                        "Hot Ash", fierySword.getNeededItems().get(2).toString(),
                        "Third needed item should be 'Hot Ash'"),
                () -> assertEquals(
                        "Hot Ash", fierySword.getNeededItems().get(3).toString(),
                        "Fourth needed item should be 'Hot Ash'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Fiery Sword", fierySword.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Fiery Sword'"),
                () -> assertEquals(
                        "Consumed Essence", fierySword.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Consumed Essence'")
        );

        // check if the crafting time has the expected value
        assertEquals(4000, fierySword.getCraftingTime(),
                "Crafting time of this pattern should be: 4000 msec");
    }

    @Test
    @DisplayName("create a 'Pattern: Tasty Chocolate Cookie'")
    void testCreateTastyChocolateCookie() {
        // create the pattern with the manager-class
        CraftingPattern tastyChocolateCookie =
                patternManager.createTastyChocolateCookie(new ArrayList<>(), new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Tasty Chocolate Cookie",
                tastyChocolateCookie.toString(),
                "Patterns name should be 'Pattern: Tasty Chocolate Cookie'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Egg", tastyChocolateCookie.getNeededItems().get(0).toString(),
                        "First needed item should be 'Egg'"),
                () -> assertEquals(
                        "Flour", tastyChocolateCookie.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Flour'"),
                () -> assertEquals(
                        "Milk Chocolate", tastyChocolateCookie.getNeededItems().get(2).toString(),
                        "Third needed item should be 'Milk Chocolate'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Tasty Chocolate Cookie",
                        tastyChocolateCookie.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Tasty Chocolate Cookie'"),
                () -> assertEquals(
                        "Baking Powder", tastyChocolateCookie.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Baking Powder'")
        );

        // check if the crafting time has the expected value
        assertEquals(2000, tastyChocolateCookie.getCraftingTime(),
                "Crafting time of this pattern should be: 2000 msec");
    }

    @Test
    @DisplayName("create a 'Pattern: Endless Tasty Chocolate Cookies'")
    void testCreateEndlessTastyChocolateCookies() {
        // create the pattern with the manager-class
        CraftingPattern endlessTastyChocolateCookies =
                patternManager.createEndlessTastyChocolateCookies(new ArrayList<>(), new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Endless Tasty Chocolate Cookies",
                endlessTastyChocolateCookies.toString(),
                "Patterns name should be 'Pattern: Endless Tasty Chocolate Cookies'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Tasty Chocolate Cookie",
                        endlessTastyChocolateCookies.getNeededItems().get(0).toString(),
                        "First needed item should be 'Tasty Chocolate Cookie'"),
                () -> assertEquals(
                        "Baking Powder",
                        endlessTastyChocolateCookies.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Baking Powder'"),
                () -> assertEquals(
                        "Essence Of Endlessness",
                        endlessTastyChocolateCookies.getNeededItems().get(2).toString(),
                        "Third needed item should be 'Essence Of Endlessness'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Endless Tasty Chocolate Cookies",
                        endlessTastyChocolateCookies.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Endless Tasty Chocolate Cookies'"),
                () -> assertEquals(
                        "Consumed Essence",
                        endlessTastyChocolateCookies.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Consumed Essence'")
        );

        // check if the crafting time has the expected value
        assertEquals(5000, endlessTastyChocolateCookies.getCraftingTime(),
                "Crafting time of this pattern should be: 5000 msec");
    }

    @Test
    @DisplayName("create a 'Pattern: Test Pattern'")
    void testCreateTestPattern() {
        // create the pattern with the manager-class
        CraftingPattern testPattern = patternManager.createTestPattern(new ArrayList<>(),
                new ArrayList<>());

        // check if the pattern has the expected name
        assertEquals("Pattern: Test Pattern",
                testPattern.toString(),
                "Patterns name should be 'Pattern: Test Pattern'");

        // the pattern should contain these expected needed items
        assertAll(
                () -> assertEquals(
                        "Test Item 1", testPattern.getNeededItems().get(0).toString(),
                        "First needed item should be 'Test Item 1'"),
                () -> assertEquals(
                        "Test Item 1", testPattern.getNeededItems().get(1).toString(),
                        "Second needed item should be 'Test Item 1'"),
                () -> assertEquals(
                        "Test Item 2", testPattern.getNeededItems().get(2).toString(),
                        "Third needed item should be 'Test Item 2'")
        );
        // the pattern should contain these expected provided items
        assertAll(
                () -> assertEquals(
                        "Test Pattern", testPattern.getProvidedItems().get(0).toString(),
                        "First provided item should be 'Test Pattern'"),
                () -> assertEquals(
                        "Test Remains", testPattern.getProvidedItems().get(1).toString(),
                        "Second provided item should be 'Test Remains'")
        );

        // check if the crafting time has the expected value
        assertEquals(250, testPattern.getCraftingTime(),
                "Crafting time of this pattern should be: 250 msec");
    }
}