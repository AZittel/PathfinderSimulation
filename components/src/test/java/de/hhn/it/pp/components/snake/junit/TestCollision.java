package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.Collision;
import de.hhn.it.pp.components.snake.provider.logic.Snake;
import de.hhn.it.pp.components.snake.provider.logic.SnakeTail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCollision {

    @Test
    @DisplayName("test collide with snake")
    void testCollideWithSnake() {
        SnakeTail testTail = new SnakeTail(15,15);
        testTail.setWait(false);
        Snake.allTails.add(testTail);
        assertEquals(true, Collision.collideWithSnake(), "should be true");
    }

    @Test
    @DisplayName("test collide with item")
    void testCollideWithItem() {
        Snake.collectibleItem.setXPosition(15);
        Snake.collectibleItem.setYPosition(15);
        Collision.collideWithItem();
        assertEquals(1, Snake.getScore(), "should be 1");
    }
}
