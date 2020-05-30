package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerProfile;
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
public class TestSnakePlayerServiceGoodCases {
    private static final Logger logger =
            LoggerFactory.getLogger(TestSnakePlayerServiceGoodCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;

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
    @DisplayName("add and remove profiles to a snakeProfile.")
    void AddAndRemoveAProfileToASnakePlayerProfile() throws IllegalParameterException {
        List<SnakePlayerProfile> profiles = snakePlayerService.getAllSnakePlayerProfiles();
        SnakePlayerProfile profile = new SnakePlayerProfile("FreshToasted");
        adminSnakePlayerService.addSnakePlayerProfile(profile);


    }


}
