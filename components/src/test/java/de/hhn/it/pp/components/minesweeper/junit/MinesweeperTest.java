package de.hhn.it.pp.components.minesweeper.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import de.hhn.it.pp.components.minesweeper.provider.Minesweeper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        int[] numbers = new int[20];
        int counter = 0;

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 4; j++){
                numbers[counter] = minesweeper.getField()[j][i].getNumber();
                counter++;
            }
        }
        assertAll(
                "Here we test our method processNumbers",
                () ->
                        assertEquals(
                                1,
                                numbers[0],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                2,
                                numbers[1],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                2,
                                numbers[2],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                1,
                                numbers[3],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                2,
                                numbers[4],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                2,
                                numbers[5],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                3,
                                numbers[6],
                                "There should be a 3"),
                () ->
                        assertEquals(
                                1,
                                numbers[7],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                1,
                                numbers[8],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                2,
                                numbers[9],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                2,
                                numbers[10],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                2,
                                numbers[11],
                                "There should be a 2"),
                () ->
                        assertEquals(
                                0,
                                numbers[12],
                                "There should be a 0"),
                () ->
                        assertEquals(
                                1,
                                numbers[13],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                1,
                                numbers[14],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                1,
                                numbers[15],
                                "There should be a 1"),
                () ->
                        assertEquals(
                                0,
                                numbers[16],
                                "There should be a 0"),
                () ->
                        assertEquals(
                                0,
                                numbers[17],
                                "There should be a 0"),
                () ->
                        assertEquals(
                                0,
                                numbers[18],
                                "There should be a 0"),
                () ->
                        assertEquals(
                                0,
                                numbers[19],
                                "There should be a 0"));

        minesweeper.turn(0,4);

        assertAll(
                "Test our turn method.",
                () ->
                        assertFalse(minesweeper.getField()[0][4].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[1][4].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[2][4].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[3][4].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[0][3].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[1][3].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[2][3].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[3][3].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[0][2].isHidden(), "Should be false"),
                () ->
                        assertFalse(minesweeper.getField()[1][2].isHidden(), "Should be false"),
                () ->
                        assertTrue(minesweeper.getField()[2][2].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[3][2].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[0][1].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[1][1].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[2][1].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[3][1].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[0][0].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[1][0].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[2][0].isHidden(), "Should be true"),
                () ->
                        assertTrue(minesweeper.getField()[3][0].isHidden(), "Should be true"));
    }

}
