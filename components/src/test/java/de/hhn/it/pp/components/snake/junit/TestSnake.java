package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.Direction;
import de.hhn.it.pp.components.snake.provider.logic.Snake;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the snake class")
public class TestSnake {

    @Test
    @DisplayName("add Tail to Snake")
    void testAddTail() {
        Snake.addTail();
        int size = Snake.allTails.size();
        assertEquals(size, Snake.allTails.size(), "should be 1");
    }

    @Test
    @DisplayName("moves snake")
    void testMoveSnake() {
        //Startdirection: UP
        //Start-Coordinates: 15,15
        //todo Frage: Wie auf 80% Coverage bringen?
        assertEquals(Direction.UP, Snake.snakeHead.getHeadDirection(), "should be UP");
        Snake.snakeHead.setHeadDirection(Direction.LEFT);
        Snake.move();
        assertEquals(Direction.LEFT, Snake.snakeHead.getHeadDirection(), "should be UP");
        assertEquals(15, Snake.snakeHead.getHeadYPosition(), "should be Y=14");
        assertEquals(14, Snake.snakeHead.getHeadXPosition(), "should be X=15");
    }
}
