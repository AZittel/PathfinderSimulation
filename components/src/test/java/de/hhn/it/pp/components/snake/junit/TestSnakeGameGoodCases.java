package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.PlayerProfile;
import de.hhn.it.pp.components.snake.provider.SnakeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the Snakeclass with good cases")
public class TestSnakeGameGoodCases {

    private static final Logger logger = LoggerFactory.getLogger(TestSnakeGameGoodCases.class);
    private PlayerProfile testProfile = new PlayerProfile("detleft23");
    private int testIdCounter = 2;
    private SnakeGame testSnakeGame;

    @BeforeEach
    void setup() {
        SnakeGame testSnakeGame = new SnakeGame(testProfile);
        SnakeGame.setIdCounter(2);
    }

    @Test
    @DisplayName("get IdCounter")
    void testGetIdCounter() {
        assertEquals(2, SnakeGame.getIdCounter(), "should be 2");
    }

    @Test
    @DisplayName("get Snake's profile")
    void testGetSnakeProfil() {
        SnakeGame testSnakeGame = new SnakeGame(testProfile);
        assertEquals(testProfile, testSnakeGame.getProfile(), "Snake's profile is detlef23");
    }
}
