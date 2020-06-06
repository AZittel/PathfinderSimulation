package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.spaceinvaders.HighScoreEntry;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestHighScoreEntryGoodCases {

    @Test
    void getHighscoreList(){
        HighScoreEntry highScoreEntry = new HighScoreEntry("Player 1", 350);
        HighScoreEntry.highScoreEntries.add(highScoreEntry);
        assertNotNull(highScoreEntry,"is a Highscorelist created");
    }
}
