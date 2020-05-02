package snake.junit;

import de.hhn.it.pp.components.example.coffeemakerservice.CoffeeMakerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.OurSnake;
import de.hhn.it.pp.components.snake.provider.OurSnakePlayerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test the admin interface with good cases.")
public class TestAdminInterfaceGoodCases {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(TestAdminInterfaceGoodCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;
    List<SnakePlayerDescriptor> descriptor;

    @BeforeEach
    void setup (List<SnakePlayerDescriptor> descriptor) {
        OurSnake.setIdCounter(0);
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
        this.descriptor = descriptor;
    }

    @Test
    @DisplayName("A new instance has no player.")
    public void aNewInstanceHasNoPlayers() {
        List<SnakePlayerDescriptor>
                players = snakePlayerService.getSnakePlayers();
        assertNotNull(players);
        assertEquals(0, players.size(), "The list should be empty.");
    }

    @Test
    @DisplayName("Adding one player to the service results in one entry.")
    public void addOnePlayer() throws IllegalParameterException {
        SnakePlayerDescriptor descriptor = new SnakePlayerDescriptor("LongDongSilver");
        adminSnakePlayerService.addSnakePlayer(descriptor);
        List<SnakePlayerDescriptor> players = snakePlayerService.getSnakePlayers();
        SnakePlayerDescriptor descriptor1 = players.get(0);
        assertAll(
                () -> assertEquals(1, players.size(), "There should be exactly one player in the list."),
                () -> assertEquals(0, descriptor1.getId(), "Id of players should start with 0")
        );
    }

    @Test
    @DisplayName("adds and remove one player and check the result")
    public void removePlayer() throws IllegalParameterException {
        SnakePlayerDescriptor descriptor = new SnakePlayerDescriptor("LongDongSilver");
        adminSnakePlayerService.addSnakePlayer(descriptor);
        List<SnakePlayerDescriptor> players = snakePlayerService.getSnakePlayers();
        SnakePlayerDescriptor descriptor1 = players.get(0);
        adminSnakePlayerService.removeSnakePlayer(players.get(0).getId());
        players = snakePlayerService.getSnakePlayers();
        assertEquals(0, players.size());
        }
}
