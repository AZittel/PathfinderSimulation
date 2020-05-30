package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.Movement;
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
    private Movement move;

    @BeforeEach
    void setup(){
        move = new Movement(direction);
    }

    @Test
    @DisplayName("get current direction")
    void testGetDirection() {
        assertEquals(direction, move.getCurrentDirection(), "direction should be UP");
    }
}
