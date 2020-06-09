package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.PlayerProfile;
import de.hhn.it.pp.components.snake.SnakeService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.OurSnakeService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

//todo!!!
@DisplayName("Test the SnakePlayerService with bad cases.")
public class TestSnakeGamePlayerServiceBadCases {
    private static final Logger logger =
            LoggerFactory.getLogger(TestSnakeGamePlayerServiceBadCases.class);

    SnakeService snakeService;
    AdminSnakePlayerService adminSnakePlayerService;

    @BeforeEach
    void setup(List<PlayerProfile> descriptors) throws IllegalParameterException {
        OurSnakeService ourSnakePlayerService = new OurSnakeService();
        snakeService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
    }

    /**@Test
    @DisplayName("ask for a non existing Player")
    void testExceptionWhenRequestingNonExistentPlayer() {
        IllegalParameterException illegalParameterException = assertThrows(
                IllegalParameterException.class,
                () -> snakePlayerService.getSnakePlayerProfile(23));
    }*/


}