package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.SnakeTail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the snaketail class with good cases")
public class TestSnakeTailGoodCases {

    private SnakeTail testTail;

    @Test
    @DisplayName("get tail's x-coordinate")
    void testGetTailXCoordinate() {
        testTail = new SnakeTail(15, 20);
        assertEquals(15, testTail.getTailXPosition(), "x-coordinate should be 15");
    }

    @Test
    @DisplayName("set tail's coordinate")
    void testSetTailXCoordinate() {
        testTail = new SnakeTail(15, 20);
        testTail.setTailXPosition(20);
        assertEquals(20, testTail.getTailXPosition(), "x-coordinate should be 20");
    }
    @Test
    @DisplayName("get tail's y-coordinate")
    void testGetTailYCoordinate() {
        testTail = new SnakeTail(15, 20);
        assertEquals(20, testTail.getTailYPosition(), "x-coordinate should be 20");
    }

    @Test
    @DisplayName("set tail's coordinate")
    void testSetTailYCoordinate() {
        testTail = new SnakeTail(15, 20);
        testTail.setTailYPosition(15);
        assertEquals(15, testTail.getTailYPosition(), "x-coordinate should be 15");
    }
}
