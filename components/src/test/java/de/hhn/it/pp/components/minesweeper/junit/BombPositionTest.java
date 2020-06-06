package de.hhn.it.pp.components.minesweeper.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.BombPosition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombPositionTest {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(BombPositionTest.class);


    @Test
    @DisplayName("Testing the BombPosition.")
    public void bombInformation() throws IllegalParameterException {
        BombPosition bomb = new BombPosition(2,2);


        assertAll(
                "Get the bombs x and y Position.",
                () ->
                        assertEquals(
                                2,
                                bomb.getX(),
                                "The Bombs x Size"),

                () ->
                        assertEquals(
                                2,
                                bomb.getY(),
                                "The Bombs Y Size"));
    }
}
