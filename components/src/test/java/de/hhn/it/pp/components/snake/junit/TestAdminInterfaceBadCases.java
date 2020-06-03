package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.PlayerProfile;
import de.hhn.it.pp.components.snake.SnakeService;
import de.hhn.it.pp.components.snake.provider.AdminSnakeService;
import de.hhn.it.pp.components.snake.provider.OurSnakeService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test admin interface with bad cases.")
public class TestAdminInterfaceBadCases {
    private static final Logger logger =
        LoggerFactory.getLogger(TestAdminInterfaceBadCases.class);

    SnakeService snakeService;
    AdminSnakeService adminSnakeService;

    @BeforeEach
    void setup() {
        OurSnakeService ourSnakePlayerService = new OurSnakeService();
        snakeService = ourSnakePlayerService;
        adminSnakeService = ourSnakePlayerService;
    }

    @Test
    @DisplayName("Test bad creation of maker with null reference as descriptor")
    public void testCreatePlayerWithNullReference() throws IllegalParameterException {
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakeService.addSnakePlayerProfile(null));
    }

    @Test
    @DisplayName("Test bad creation with null reference as nickname in descriptor")
    public void testCreatePlayerWithDescriptorWithNullLocation() {
        PlayerProfile descriptor = new PlayerProfile(null);
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakeService.addSnakePlayerProfile(descriptor));
    }

    @Test
    @DisplayName("Test bad creation with empty string as nickname in descriptor")
    public void testCreatePlayerWithDescriptorWithEmptyStringLocation() {
        PlayerProfile descriptor = new PlayerProfile("");
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakeService.addSnakePlayerProfile(descriptor));
    }

    @Test
    @DisplayName("Test bad creation with just white space as location in descriptor")
    public void testCreatePlayerWithDescriptorWithWhitespaceLocation() {
        PlayerProfile descriptor = new PlayerProfile("  ");
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakeService.addSnakePlayerProfile(descriptor));
    }

    @Test
    @DisplayName("Test removal of a non existing snakePlayer")
    void testExceptionWhenRemovingNonExistentSnakePlayer() {
        IllegalParameterException illegalParameterException = assertThrows(
                IllegalParameterException.class,
                () -> adminSnakeService.removeSnakePlayerProfile(123456));
    }
}
