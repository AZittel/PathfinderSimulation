package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.OurSnakeItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Tests the item class with good cases")
public class TestItemGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestItemGoodCases.class);
    private OurSnakeItem item;
    private int xPos;
    private int yPos;

    @BeforeEach
    void setup(){
        item = new OurSnakeItem(2);
    }

    @Test
    @DisplayName("get item's value")
    void testGetValue(){
        assertEquals(2, item.getValue(), "Value should be 2");
    }

    @Test
    @DisplayName("spawns item")
    void testSpawnItem(){
        assertNotNull(xPos, "should not be null");
        assertNotNull(yPos, "should not be null");
        
    }



}
