package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.spaceinvaders.Position;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest{
    SpaceInvaders spaceInvaders = new SpaceInvaders();


    @Test
    void movementTest(){
        Position alpha = spaceInvaders.getPositionPlayer();
        spaceInvaders.movement(10,10);
        Position bravo = spaceInvaders.getPositionPlayer();
        boolean move = alpha != bravo;
        assertTrue(move, "Test of Plaver movement");
    }
    @Test
    void gameOverTest(){
        boolean gameStatus = false;
        int numOfLives = spaceInvaders.numOfLives();
        int arrayAliens = spaceInvaders.collection();
        if(numOfLives == 0 || arrayAliens == 0){
            gameStatus= true;
        }
        assertTrue(gameStatus, "Test for Status of the game");

    }
    //TODO darko mach mal mein boi :D
    @Test
    void shootTest(){

    }
}
