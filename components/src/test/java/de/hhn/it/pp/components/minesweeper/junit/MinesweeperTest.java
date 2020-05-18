package de.hhn.it.pp.components.minesweeper.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.provider.Minesweeper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinesweeperTest {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(MinesweeperTest.class);

    @Test
    @DisplayName("Testing the Minesweeper Class.")
    public void bombInformation() throws IllegalParameterException {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.createField(6, 5);
        assertAll(
                () ->
                        assertEquals(
                                6,
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


        minesweeper.setFixBombs();
        minesweeper.setPoints(5);
        assertAll(
                "Get Bombs and the Points",
                () ->
                        assertEquals(
                                0,
                                minesweeper.getBombs()[0].getX(),
                                "The Bombs X Position"),
                () ->
                        assertEquals(
                                1,
                                minesweeper.getBombs()[1].getX(),
                                "The Bombs X Position"),
                () ->
                        assertEquals(
                                2,
                                minesweeper.getBombs()[2].getX(),
                                "The Bombs X Position"),
                () ->
                        assertEquals(
                                3,
                                minesweeper.getBombs()[3].getX(),
                                "The Bombs X Position"),
                () ->
                        assertEquals(
                                0,
                                minesweeper.getBombs()[0].getY(),
                                "The Bombs Y Position"),
                () ->
                        assertEquals(
                                1,
                                minesweeper.getBombs()[1].getY(),
                                "The Bombs Y Position"),
                () ->
                        assertEquals(
                                2,
                                minesweeper.getBombs()[2].getY(),
                                "The Bombs Y Position"),
                () ->
                        assertEquals(
                                1,
                                minesweeper.getBombs()[3].getY(),
                                "The Bombs Y Position"),
                () ->
                        assertEquals(
                                5,
                                minesweeper.getPoints(),
                                "The Points should be 5"));


    }
}
