package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests SnakePlayerProfile with bad cases")
public class TestSnakePlayerProfileBadCases {

    private static final Logger logger = LoggerFactory.getLogger(TestSnakePlayerProfileBadCases.class);
    private SnakePlayerProfile testProfile;
    private int playerId = 1;
    private int newPlayerId = 1;

    @BeforeEach
    void setup() throws IllegalParameterException {
        SnakePlayerProfile testProfile = new SnakePlayerProfile("walter456");
        testProfile.setPlayerId(playerId);
    }

    @Test
    @DisplayName("Tests setPlayerId with id that is already taken")
    void testSetPlayerIdBadCase() throws IllegalParameterException {
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> testProfile.setPlayerId(newPlayerId));
    }
}
