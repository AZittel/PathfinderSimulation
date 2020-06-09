package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the item class with good cases")
public class TestItemGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestItemGoodCases.class);
    private Item item;
    private int xPos = 12;
    private int yPos = 13;

    @BeforeEach
    void setup(){
        item = new Item(2);
        item.setxPosition(xPos);
        item.setyPosition(yPos);
    }

    @Test
    @DisplayName("get item's value")
    void testGetValue(){
        assertEquals(2, item.getValue(), "Value should be 2");
    }

    @Test
    @DisplayName("spawns item")
    void testSpawnItem(){
        assertEquals(12, item.getxPosition(), "item's xPosition is 12");
        assertEquals(13, item.getyPosition(), "item's yPosition is 13");
    }
}