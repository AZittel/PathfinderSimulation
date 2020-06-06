package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameOverExeptionTest{
    SpaceInvaders spaceInvaders = new SpaceInvaders();

    @Test
    void getHighscoreList(){
        ArrayList highscore = spaceInvaders.getHighscoreList();
        assertNotNull(highscore,"is a Highscorelist created");
    }
}
