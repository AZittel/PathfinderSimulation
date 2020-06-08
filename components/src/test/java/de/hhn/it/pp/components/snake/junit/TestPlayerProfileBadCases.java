package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// todo nice to have no right now!!!

@DisplayName("Tests PlayerProfile with bad cases")
public class TestPlayerProfileBadCases {

    private static final Logger logger = LoggerFactory.getLogger(TestPlayerProfileBadCases.class);
    private PlayerProfile testProfile;

    @BeforeEach
    void setup() throws IllegalParameterException {
        PlayerProfile testProfile = new PlayerProfile("walter456");
        PlayerProfile testProfile2 = new PlayerProfile("koko");
    }

    @Test
    @DisplayName("Tests setPlayerId with id that is already taken")
    void testSetPlayerIdBadCase() {
        testProfile = new PlayerProfile("walter456");
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> testProfile.setPlayerId(), "setPlayerId should throw an exception but didn't");
            assertTrue(exception.getMessage().contains("playerId is already chosen, chose another one"), "should be true");
    }
}
