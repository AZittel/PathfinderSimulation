package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.Direction;
import de.hhn.it.pp.components.snake.provider.logic.Movement;
import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test the move class with good cases")
public class TestMovementGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestMovementGoodCases.class);
    private Direction direction = Direction.UP;
    private Direction newDirection = Direction.DOWN;
    private Movement move;

    @BeforeEach
    void setup(){
        move = new Movement(direction);
    }

    @Test
    @DisplayName("get current direction")
    void testGetCurrentDirection() {
        assertEquals(direction, move.getCurrentDirection(), "direction should be UP");
    }

    @Test
    @DisplayName("set current direction")
    void testSetCurrentDirection() {
        move.setCurrentDirection(newDirection);
        assertEquals(newDirection, move.getCurrentDirection(), "new direction should be DOWN");
    }
}
