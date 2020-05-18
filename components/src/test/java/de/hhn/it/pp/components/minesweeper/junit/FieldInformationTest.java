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
                "Checking if the Field is hidden and there is no activ Flag",
                () ->
                        assertEquals(
                                true,
                                testfield.isHidden(),
                                "The Field is hidden"),
                () ->
                        assertEquals(
                                false,
                                testfield.isActiveFlag(),
                                "The Field has no Active Flag."));

    }
}
