package de.hhn.it.pp.components.minesweeper.junit;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldInformationTest {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(FieldInformationTest.class);


    @Test
    @DisplayName("Testing the FieldInformation.")
    public void fieldInformation() throws IllegalParameterException {
        FieldInformation testfield = new FieldInformation(2, 2);


        assertAll(
                "Is there a Field at x = 2 and y = 2.",
                () ->
                        assertEquals(
                                2,
                                testfield.getX(),
                                "The Field x Size"),

                () ->
                        assertEquals(
                                2,
                                testfield.getY(),
                                "The Field Y Size"));
        assertAll(
                "Checking if the Field is hidden and there is no active Flag and no Number",
                () ->
                        assertEquals(
                                true,
                                testfield.isHidden(),
                                "The Field is hidden"),
                () ->
                        assertEquals(
                                false,
                                testfield.isActiveFlag(),
                                "The Field has no Active Flag."),
                () ->
                        assertEquals(
                                0,
                                testfield.getNumber(),
                                "The Field has no Number."));


        //Changing some Parameters for more tests.
        testfield.setActiveFlag(true);
        testfield.setIsHidden(false);
        testfield.setNumber(5);
        assertAll(
                "Checking if the Field is now not hidden and there is an active Flag and a Number",
                () ->
                        assertEquals(
                                false,
                                testfield.isHidden(),
                                "The Field isn´t hidden"),
                () ->
                        assertEquals(
                                true,
                                testfield.isActiveFlag(),
                                "The Field has an Active Flag."),
                () ->
                        assertEquals(
                                5,
                                testfield.getNumber(),
                                "The Field has the Number 5."));

    }
}
