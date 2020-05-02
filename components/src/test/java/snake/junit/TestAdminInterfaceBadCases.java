package snake.junit;

import de.hhn.it.pp.components.snake.SnakePlayerDescriptor;
import de.hhn.it.pp.components.snake.SnakePlayerService;
import de.hhn.it.pp.components.snake.provider.AdminSnakePlayerService;
import de.hhn.it.pp.components.snake.provider.OurSnakePlayerService;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test admin interface with bad cases.")
public class TestAdminInterfaceBadCases {
    private static final org.slf4j.Logger logger =
        org.slf4j.LoggerFactory.getLogger(TestAdminInterfaceBadCases.class);

    SnakePlayerService snakePlayerService;
    AdminSnakePlayerService adminSnakePlayerService;

    @BeforeEach
    void setup() {
        OurSnakePlayerService ourSnakePlayerService = new OurSnakePlayerService();
        snakePlayerService = ourSnakePlayerService;
        adminSnakePlayerService = ourSnakePlayerService;
    }

    @Test
    @DisplayName("Test bad creation of maker with null reference as descriptor")
    public void createPlayerWithNullReference() throws IllegalParameterException {
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakePlayerService.addSnakePlayer(null));
    }

    @Test
    @DisplayName("Test bad creation with null reference as nickname in descriptor")
    public void createPlayerWithDescriptorWithNullLocation() {
        SnakePlayerDescriptor descriptor = new SnakePlayerDescriptor(null);
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakePlayerService.addSnakePlayer(descriptor));
    }

    @Test
    @DisplayName("Test bad creation with empty string as nickname in descriptor")
    public void createPlayerWithDescriptorWithEmptyStringLocation() {
        SnakePlayerDescriptor descriptor = new SnakePlayerDescriptor("");
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakePlayerService.addSnakePlayer(descriptor));
    }

    @Test
    @DisplayName("Test bad creation with just white space as location in descriptor")
    public void createPlayerWithDescriptorWithWhitespaceLocation() {
        SnakePlayerDescriptor descriptor = new SnakePlayerDescriptor("  ");
        IllegalParameterException exception = assertThrows(IllegalParameterException.class,
                () -> adminSnakePlayerService.addSnakePlayer(descriptor));
    }

    @Test
    @DisplayName("Test removal of a non existing snakePlayer")
    void testExceptionWhenRemovingNonExistentSnakePlayer() {
        IllegalParameterException illegalParameterException = assertThrows(
                IllegalParameterException.class,
                () -> adminSnakePlayerService.removeSnakePlayer(123456));
    }




























}
