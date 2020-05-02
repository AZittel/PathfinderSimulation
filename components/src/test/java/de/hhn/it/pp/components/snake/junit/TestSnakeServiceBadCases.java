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

//todo!!!
@DisplayName("Test the SnakePlayerService with bad cases.")
public class TestSnakeServiceBadCases {
    private static final Logger logger =
            LoggerFactory.getLogger(de.hhn.it.pp.components.example.coffeemakerservice.junit.TestCoffeMakerServiceBadCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;

    @BeforeEach
    void setup(List<SnakePlayerProfile> descriptors) throws IllegalParameterException {
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
    }

    @Test
    @DisplayName("ask for a non existing Player")
    void testExceptionWhenRequestingNonExistentPlayer() {
        IllegalParameterException illegalParameterException = assertThrows(
                IllegalParameterException.class,
                () -> snakePlayerService.getSnakePlayerProfile(23));
    }

    @Test
    @DisplayName("add callback for a non existing Player")
    void testExceptionWhenAddingCallbackToNonExistentCoffeeMaker() {
        IllegalParameterException illegalParameterException = assertThrows(
                IllegalParameterException.class,
                () -> snakePlayerService.addCallback(23, new DummyCallback()));
    }

    @Test
    @DisplayName("remove callback for a non existing Player")
    void testExceptionWhenRemovingCallbackToNonExistentPlayer() {
        IllegalParameterException illegalParameterException = assertThrows(
                IllegalParameterException.class,
                () -> snakePlayerService.removeCallback(23, new DummyCallback()));
    }

    @Test
    @DisplayName("move de.hhn.it.pp.components.snake with a null direction")
    void testBrewingWithNullReceipt() throws IllegalParameterException {
        IllegalParameterException illegalParameterException = assertThrows(IllegalParameterException.class,
                () -> snakePlayerService.moveSnake(0, null));
    }
}