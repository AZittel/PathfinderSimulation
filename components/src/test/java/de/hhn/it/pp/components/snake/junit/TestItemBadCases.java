package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.OurSnakeItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests the item class with bad cases")
public class TestItemBadCases {
    private static final Logger logger = LoggerFactory.getLogger(TestItemBadCases.class);
    private OurSnakeItem testItem;
    private int xPos = 0;
    private int yPos = 0;


    @BeforeEach
    void setup() {
        testItem = new OurSnakeItem(2);
    }

    @Test
    @DisplayName("x- and y-Position are 0, item can't be spawned")
    void testSpawnItemBadCase() throws IllegalParameterException {
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> testItem.spawn(xPos, yPos));
    }
}
