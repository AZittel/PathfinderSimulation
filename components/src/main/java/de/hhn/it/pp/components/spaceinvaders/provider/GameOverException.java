package de.hhn.it.pp.components.spaceinvaders.provider;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
public class GameOverException {

    SpaceInvaders spaceInvaders = new SpaceInvaders();

    //Shows the highscore
    void getHighscoreList() {

        ArrayList highscoreList =spaceInvaders.getHighscoreList();
        assertNotNull(highscoreList,"not NULL expected");
    }
}
