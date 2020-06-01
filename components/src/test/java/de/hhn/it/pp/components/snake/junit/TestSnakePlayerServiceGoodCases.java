package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.Movement;
import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.OurSnakeLevel;
import de.hhn.it.pp.components.snake.provider.OurSnakePlayerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test the SnakeService with good cases.")
public class TestSnakePlayerServiceGoodCases {
    private static final Logger logger =
            LoggerFactory.getLogger(TestSnakePlayerServiceGoodCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;
    SnakePlayerProfile snakePlayerProfile;
    OurSnakeLevel ourSnakeLevel;
    OurSnakePlayerService ourSnakePlayerService;
    Movement movement;

    @BeforeEach
    void setup(List<SnakePlayerProfile> profiles) throws IllegalParameterException {
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;

        for (SnakePlayerProfile profile : profiles) {
            adminSnakePlayerService.addSnakePlayerProfile(profile);
        }
    }

    @Test
    @DisplayName("checks single and the whole list of snake profiles.")
    void ChecksSingleAndAllSnakeProfiles() throws IllegalParameterException {
        SnakePlayerProfile profile1 = new SnakePlayerProfile("Detlef23");
        adminSnakePlayerService.addSnakePlayerProfile(profile1);
        SnakePlayerProfile profile2 = new SnakePlayerProfile("LongDong");
        adminSnakePlayerService.addSnakePlayerProfile(profile2);
        snakePlayerService.getSnakePlayerProfile(0);
        snakePlayerService.getAllSnakePlayerProfiles();

        assertAll(
                () -> assertEquals(1, snakePlayerService.getSnakePlayerProfile(0), "Player profile should be Detlef23"),
                () -> assertEquals(0, snakePlayerService.getAllSnakePlayerProfiles(), "There should be exactly two player in the list")
        );
    }

    @Test
    @DisplayName("Creates an player profile starts an game, switch the Level and checks results")
    void startGameSwitchesAndEnd() throws IllegalParameterException {
        SnakePlayerProfile profile1 = new SnakePlayerProfile("Detlef23");
        adminSnakePlayerService.addSnakePlayerProfile(profile1);
        snakePlayerService.startGame(0,250, 250);

        assertAll(
                () -> assertEquals(2, ourSnakePlayerService.getWindowHeight(), "WindowHeight should be 250" ),
                () -> assertEquals(1, ourSnakePlayerService.getWindowWidth(), "Window width should be 250"),
                () -> assertEquals(0, snakePlayerProfile.getPlayerId(), "Id should be 0")
        );

        snakePlayerService.switchLevel(2, 5000);

        assertAll(
                () -> assertEquals(1, ourSnakeLevel.getLevelId(), "Id should be 2"),
                () -> assertEquals(0, snakePlayerProfile.getPlayerHighscore(), "Highscore should be 5000")
        );
    }

    @Test
    @DisplayName("Moves up and checks result")
    void movesTheSnake() throws IllegalParameterException{
        SnakePlayerProfile profile1 = new SnakePlayerProfile("Detlef23");
        adminSnakePlayerService.addSnakePlayerProfile(profile1);
        snakePlayerService.moveSnake(0, Direction.UP);

        assertEquals(0, movement.getCurrentDirection(), "Current direction should be UP");
    }
}
