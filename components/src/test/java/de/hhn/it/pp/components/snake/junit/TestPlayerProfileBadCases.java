package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.PlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests SnakePlayerProfile with bad cases")
public class TestPlayerProfileBadCases {

    private static final Logger logger = LoggerFactory.getLogger(TestPlayerProfileBadCases.class);
    private PlayerProfile testProfile;
    private int playerId = 1;

    @BeforeEach
    void setup() throws IllegalParameterException {
        PlayerProfile testProfile = new PlayerProfile("walter456");
        testProfile.setPlayerId(playerId);
    }

    //todo Frage: Wieso failed der Test?
    /**@Test
    @DisplayName("Tests setPlayerId with id that is already taken")
    void testSetPlayerIdBadCase() {
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> testProfile.setPlayerId(playerId), "setPlayerId should throw an exception but didn't");
            assertTrue(exception.getMessage().contains("playerId is already chosen, chose another one"), "should be true");
    }*/
}
