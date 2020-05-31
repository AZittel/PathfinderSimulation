package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.OurSnakeLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Tests the level class with good cases")
public class TestLevelGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestLevelGoodCases.class);
    private OurSnakeLevel testLevel;

    @BeforeEach
    void setup() {
        OurSnakeLevel testLevel = new OurSnakeLevel(2, 20);
    }

    @Test
    @DisplayName("get level's id")
    void testGetLevelId(){
        assertEquals(2, testLevel.getLevelId(), "id should be 2");
    }

    @Test
    @DisplayName("get needed highscore")
    void testGetNeededHighscore(){
        assertEquals(20, testLevel.getNeededHighscore(), "needed highscore should be 20");
    }
}
