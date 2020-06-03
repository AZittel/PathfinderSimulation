package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;
import de.hhn.it.pp.components.snake.provider.logic.State;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests the SnakePlayerProfile class with good cases")
public class TestPlayerProfileGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestPlayerProfileGoodCases.class);
    private String newNickname = "detlef2";
    private PlayerProfile testProfile;
    private State testState;

    @BeforeEach
    void setup() throws IllegalParameterException {
        PlayerProfile testProfile = new PlayerProfile("walter45");
    }

    @Test
    @DisplayName("get the player's nickname")
    void testGetPlayerNickname() throws IllegalParameterException {
        PlayerProfile testProfile  = new PlayerProfile("walter45");
        assertEquals("walter45", testProfile.getPlayerNickname(), "Nickname should be walter45");
    }

    @Test
    @DisplayName("set new nickname")
    void testSetPlayerNickname() throws IllegalParameterException {
        PlayerProfile testProfile  = new PlayerProfile("walter45");
        testProfile.setPlayerNickname(newNickname);
        assertEquals("detlef2", testProfile.getPlayerNickname(), "nickname is set to detlef2");
    }

    @Test
    @DisplayName("get the player's highscore")
    void testGetPlayerHighscore() throws IllegalParameterException {
        PlayerProfile testProfile  = new PlayerProfile("walter45");
        testProfile.setPlayerHighscore(46);
        assertEquals(46, testProfile.getPlayerHighscore(), "highscore should be 46");
    }

    @Test
    @DisplayName("get current level")
    void testGetCurrentLevel() throws IllegalParameterException {
        PlayerProfile testProfile  = new PlayerProfile("walter45");
        testProfile.setCurrentLevel(1);
        assertEquals(1, testProfile.getCurrentLevel(), "current level is level 1");
    }

    @Test
    @DisplayName("get player id")
    void testGetPlayerId() throws IllegalParameterException {
        PlayerProfile testProfile  = new PlayerProfile("walter45");
        assertEquals(testProfile.getPlayerId(), testProfile.getPlayerId(), "player's id is 1");
    }

    @Test
    @DisplayName("get current state")
    void testGetCurrentState() throws IllegalParameterException {
        PlayerProfile testProfile = new PlayerProfile("keks23");
        testProfile.setCurrentState(testState);
        assertEquals(testState, testProfile.getCurrentState(), "current state should be our teststate");
    }
}

