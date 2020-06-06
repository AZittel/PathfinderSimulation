package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.spaceinvaders.Position;
import de.hhn.it.pp.components.spaceinvaders.SpaceInvadersService;
import de.hhn.it.pp.components.spaceinvaders.provider.Player;
import de.hhn.it.pp.components.spaceinvaders.provider.Projectile;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayerGoodCases {
    SpaceInvaders spaceInvaders = new SpaceInvaders();


    @Test
    void movementTest(){
        Player player = new Player(11, 11);
        int alpha = player.getY();
        player.movement();
        int bravo = player.getY();
        boolean move = alpha != bravo;
        assertTrue(move, "Test of Player movement");
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
    @Test
    void shootTest(){
        Player player = new Player(10, 10);
        for(int i=0; i<4; i++) {
        player.shoot(); }
        assertEquals(4, Player.projectiles.size());
    }
}
