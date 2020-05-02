package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerProfile;
import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.OurSnakePlayerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test the SnakeService with good cases.")
public class TestSnakeServiceGoodCases {
    private static final Logger logger =
            LoggerFactory.getLogger(TestSnakeServiceGoodCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;

    @BeforeEach
    void setup(List<SnakePlayerProfile> descriptors) throws IllegalParameterException {
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
    }

@Test
    @DisplayName("add and remove callbacks to a known player.")
    void testAddAndRemoveCallbacksToAKnownPlayer() throws IllegalParameterException {
        List<SnakePlayerProfile> players = snakePlayerService.getAllSnakePlayerProfiles();
        SnakePlayerProfile player = players.get(0);
        SnakePlayerListener listener = new DummyCallback();
        snakePlayerService.addCallback(player.getId(), listener);
        snakePlayerService.removeCallback(player.getId(), listener);

        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> snakePlayerService.removeCallback(player.getId(), listener));
    }
}
