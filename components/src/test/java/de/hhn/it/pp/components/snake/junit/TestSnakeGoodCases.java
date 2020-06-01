package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.provider.Snake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the Snakeclass with good cases")
public class TestSnakeGoodCases {

    private static final Logger logger = LoggerFactory.getLogger(TestSnakeGoodCases.class);
    private SnakePlayerProfile testProfile = new SnakePlayerProfile("detleft23");
    private int testIdCounter = 2;
    private Snake testSnake;

    @BeforeEach
    void setup() {
        Snake testSnake = new Snake(testProfile);
    }

    @Test
    @DisplayName("get IdCounter")
    void testGetIdCounter() {
        assertEquals(2, Snake.getIdCounter(), "should be 2");
    }

    @Test
    @DisplayName("get Snake's profile")
    void testGetSnakeProfil() {
        assertEquals(testProfile, testSnake.getProfile(), "Snake's profile is detlef23");
    }
}
