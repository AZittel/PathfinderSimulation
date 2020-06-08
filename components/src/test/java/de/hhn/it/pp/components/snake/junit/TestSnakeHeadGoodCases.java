package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.Direction;
import de.hhn.it.pp.components.snake.provider.logic.SnakeHead;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the snakehead class with good cases")
public class TestSnakeHeadGoodCases {
    private int testXCoordinate = 20;
    private int testYCoordinate = 20;
    private SnakeHead testHead;

    @BeforeEach
    void setup(){
        testHead = new SnakeHead(testXCoordinate, testYCoordinate);
    }

    @Test
    @DisplayName("get the direction")
    void testGetHeadDirection() {
        testHead = new SnakeHead(testXCoordinate, testYCoordinate);
        assertEquals(Direction.UP, testHead.getHeadDirection(), "Head's direction should be UP");
    }

    @Test
    @DisplayName("get the x-coordinate")
    void testGetHeadXPosition() {
        testHead = new SnakeHead(testXCoordinate, testYCoordinate);
        assertEquals(20, testHead.getHeadXPosition(), "x-coordinate should be 20");
    }

    @Test
    @DisplayName("get the y-coordinate")
    void testGetHeadYPosition() {
        testHead = new SnakeHead(testXCoordinate, testYCoordinate);
        assertEquals(20, testHead.getHeadYPosition(), "y-coordinate should be 20");
    }
}
