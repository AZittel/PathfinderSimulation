package snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerListener;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.OurSnakePlayerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test the SnakeService with good cases.")
public class TestSnakeServiceGoodCases {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(TestSnakeServiceGoodCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;

    @BeforeEach
    void setup(List<SnakePlayerDescriptor> descriptors) throws IllegalParameterException {
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
    }

@Test
    @DisplayName("add and remove callbacks to a known player.")
    void AddAndRemoveCallbacksToAKnownPlayer() throws IllegalParameterException {
        List<SnakePlayerDescriptor> players = snakePlayerService.getSnakePlayers();
        SnakePlayerDescriptor player = players.get(0);
        SnakePlayerListener listener = new DummyCallback();
        snakePlayerService.addCallback(player.getId(), listener);
        snakePlayerService.removeCallback(player.getId(), listener);

        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> snakePlayerService.removeCallback(player.getId(), listener));
    }
}
