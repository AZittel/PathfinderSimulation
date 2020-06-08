package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.OurSnakeGame;
import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

// todo not sure if needed

@DisplayName("Tests the Snakegameclass with good cases")
public class TestSnakeGameGoodCases {

    private static final Logger logger = LoggerFactory.getLogger(TestSnakeGameGoodCases.class);
    private PlayerProfile testProfile;
    private PlayerProfile testProfile2;
    private int testIdCounter = 2;
    private OurSnakeGame testSnakeGame;

    public TestSnakeGameGoodCases() throws IllegalParameterException {
    }

    @BeforeEach
    void setup() throws IllegalParameterException {
        testProfile = new PlayerProfile("detlef23");
        testProfile2 = new PlayerProfile("keksi");
        OurSnakeGame testSnakeGame = new OurSnakeGame(testProfile2);
    }


    //todo testen wenn OurSnakeGame fertig ist
    /**@Test
    @DisplayName("get Snake's profile")
    void testGetSnakeProfil() throws IllegalParameterException {
        PlayerProfile testProfile = new PlayerProfile("detlef23");
        OurSnakeGame testSnakeGame = new OurSnakeGame(testProfile);
        assertEquals(testProfile, testSnakeGame.getProfile(), "Snake's profile is detlef23");
    }*/
}
