package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.PlayerProfile;
import de.hhn.it.pp.components.snake.SnakeService;
import de.hhn.it.pp.components.snake.provider.AdminSnakeService;
import de.hhn.it.pp.components.snake.provider.SnakeGame;
import de.hhn.it.pp.components.snake.provider.OurSnakeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@DisplayName("Test the admin interface with good cases.")
public class TestAdminInterfaceGoodCases {
    private static final Logger logger =
            LoggerFactory.getLogger(TestAdminInterfaceGoodCases.class);

    SnakeService snakeService;
    AdminSnakeService adminSnakeService;
    List<PlayerProfile> profiles;

    @BeforeEach
    void setup (List<PlayerProfile> profiles) {
        SnakeGame.setIdCounter(0);
        OurSnakeService ourSnakePlayerService = new OurSnakeService();
        snakeService = ourSnakePlayerService;
        adminSnakeService = ourSnakePlayerService;
        this.profiles = profiles;
    }

    //todo Tests

    /**@Test
    @DisplayName("A new instance has no player.")
    public void testANewInstanceHasNoPlayers() {
        List<SnakePlayerProfile>
                players = snakePlayerService.getAllSnakePlayerProfiles();
        assertNotNull(players);
        assertEquals(0, players.size(), "The list should be empty.");
    /*}

   /** @Test
    @DisplayName("Adding one player to the service results in one entry.")
    public void testAddOnePlayer() throws IllegalParameterException {
        SnakePlayerProfile profile = new SnakePlayerProfile("LongDongSilver");
        adminSnakePlayerService.addSnakePlayerProfile(profile);
        List<SnakePlayerProfile> players = snakePlayerService.getAllSnakePlayerProfiles();
        SnakePlayerProfile profile1 = players.get(0);
        assertAll(
                () -> assertEquals(1, players.size(), "There should be exactly one player in the list."),
                () -> assertEquals(0, profile1.getPlayerId(), "Id of players should start with 0")
        );
    }

    @Test
    @DisplayName("adds and remove one player and check the result")
    public void testRemovePlayer() throws IllegalParameterException {
        SnakePlayerProfile profile = new SnakePlayerProfile("LongDongSilver");
        adminSnakePlayerService.addSnakePlayerProfile(profile);
        List<SnakePlayerProfile> players = snakePlayerService.getAllSnakePlayerProfiles();
        SnakePlayerProfile descriptor1 = players.get(0);
        adminSnakePlayerService.removeSnakePlayerProfile(players.get(0).getPlayerId());
        players = snakePlayerService.getAllSnakePlayerProfiles();
        assertEquals(0, players.size());
        }*/
}
