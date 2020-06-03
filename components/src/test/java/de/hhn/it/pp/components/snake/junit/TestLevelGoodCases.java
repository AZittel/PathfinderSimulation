package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Tests the level class with good cases")
public class TestLevelGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestLevelGoodCases.class);
    private Level testLevel;

    @BeforeEach
    void setup() {
        Level testLevel = new Level(2, 20);
    }

    @Test
    @DisplayName("get level's id")
    void testGetLevelId(){
        Level testLevel = new Level(2, 20);
        assertEquals(2, testLevel.getLevelId(), "id should be 2");
    }

    @Test
    @DisplayName("get needed highscore")
    void testGetNeededHighscore(){
        Level testLevel = new Level(2, 20);
        assertEquals(20, testLevel.getNeededHighscore(), "needed highscore should be 20");
    }
}
