package de.hhn.it.pp.components.snake.junit;

import de.hhn.it.pp.components.snake.provider.logic.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Tests the level class with good cases")
public class TestMapGoodCases {
    private static final Logger logger = LoggerFactory.getLogger(TestMapGoodCases.class);
    private Map testMap;

    @BeforeEach
    void setup() {
        Map testMap = new Map(2, 20);
    }

    @Test
    @DisplayName("get level's id")
    void testGetLevelId(){
        Map testMap = new Map(2, 20);
        assertEquals(2, testMap.getLevelId(), "id should be 2");
    }

    @Test
    @DisplayName("get needed highscore")
    void testGetNeededHighscore(){
        Map testMap = new Map(2, 20);
        assertEquals(20, testMap.getNeededHighscore(), "needed highscore should be 20");
    }
}
