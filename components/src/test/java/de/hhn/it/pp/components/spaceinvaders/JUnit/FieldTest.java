package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.spaceinvaders.provider.Field;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class FieldTest {
    SpaceInvaders spaceInvaders = new SpaceInvaders();
    Field spaceInvadersField;

    //erzeuge ein neues Feld mit 50/50
    public FieldTest() throws IllegalParameterException {
        spaceInvaders.createField(50,50);
    }

    @Test
    @DisplayName("Test of field creation")
    void createFieldTest(){
        //vergleicht ob das erzeugte Feld nicht NULL ist
        assertNotNull(spaceInvadersField,"not NULL expected");
    }
}
