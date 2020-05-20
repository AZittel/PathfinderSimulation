package de.hhn.it.pp.components.minesweeper.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import de.hhn.it.pp.components.minesweeper.provider.Minesweeper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinesweeperTest {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(MinesweeperTest.class);

    @Test
    @DisplayName("Testing the Minesweeper Class.")
    public void bombInformation() throws IllegalParameterException {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.createField(4, 5);

        assertAll(
                () ->
                        assertEquals(
                                4,
                                minesweeper.getField().length,
                                "Gets the width of the Field."),
                () ->
                        assertEquals(
                                5,
                                minesweeper.getField()[1].length,
                                "Gets the height of the Field."),

                () ->
                        assertEquals(
                                0,
                                minesweeper.getPoints(),
                                "Get the current Points must be 0."),

                () ->
                        assertEquals(
                                null,
                                minesweeper.getBombs(),
                                "Must be 0 because i havent created one."));

        FieldInformation[] bombs = new FieldInformation[4];
        int n = 0;
        minesweeper.setFixBombs();
        minesweeper.setPoints(5);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (minesweeper.getField()[i][j].getBomb() == true) {
                    bombs[n] = minesweeper.getField()[i][j];
                    n++;
                }
            }
        }

        {
            assertAll(
                    "Get Bombs and the Points",
                    () ->
                            assertEquals(
                                    0,
                                    bombs[0].getX(),
                                    "There should be a 0"),
                    () ->
                            assertEquals(
                                    1,
                                    bombs[1].getX(),
                                    "There should be a 1"),
                    () ->
                            assertEquals(
                                    2,
                                    bombs[2].getX(),
                                    "There should be a 2"),
                    () ->
                            assertEquals(
                                    3,
                                    bombs[3].getX(),
                                    "There should be a 3"),
                    () ->
                            assertEquals(
                                    0,
                                    bombs[0].getY(),
                                    "There should be a 0"),
                    () ->
                            assertEquals(
                                    1,
                                    bombs[1].getY(),
                                    "There should be a 1"),
                    () ->
                            assertEquals(
                                    2,
                                    bombs[2].getY(),
                                    "There should be a 2"),
                    () ->
                            assertEquals(
                                    1,
                                    bombs[3].getY(),
                                    "There should be a 1"),
            () ->
                    assertEquals(
                            5,
                            minesweeper.getPoints(),
                            "The Points should be 5"));


        }
    }
}
