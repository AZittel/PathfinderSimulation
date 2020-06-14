package de.hhn.it.pp.components.snake.junit;

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

    }
}
