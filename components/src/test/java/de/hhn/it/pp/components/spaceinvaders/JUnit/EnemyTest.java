package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.snake.Direction;
import de.hhn.it.pp.components.snake.Movement;
import de.hhn.it.pp.components.spaceinvaders.provider.Enemies;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static de.hhn.it.pp.components.spaceinvaders.EnemyType.STANDARD;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Énemy Class Test -Bad Case")

public class EnemyTest {
    SpaceInvaders spaceInvaders = new SpaceInvaders();
    ArrayList<Enemies> aliens = new ArrayList<>();
    int shutdown = 0;
    
    @BeforeEach
    void setup(){
        for(int i = 0; i <20; i++) {
            Enemies enemy = new Enemies(100*i, 100*i, STANDARD, 30);
            aliens.add(enemy);
        }

    }

    @Test
    @DisplayName("Size Matters - Test for Aliens")
    //Test für das Erzeugen der Aliens
    void createEnemiesTest(){
        // Erwartet eine Arraylist mit der Größe von 20 (Aliens)
        int a = spaceInvaders.collection();
        assertEquals(aliens.size(), a, "size should be 20");
    }


    @Test
    @DisplayName("Direction Test - Aliens")
    void moveTest()throws IllegalArgumentException{
        Enemies before = aliens.get(0);
        spaceInvaders.moveAlien();
        Enemies after = aliens.get(0);
        boolean test = before != after;
        assertTrue(test, "Movement of Aliens");
    }
    /**
    assertFalse("This will succeed.", false);
    assertFalse("This will fail!", true);
     Lucas aka. Ehrenmann
    */


    @Test
    void shutDownTest()throws IllegalArgumentException{
        int shutDown = spaceInvaders.shutDown();
        int startCounterEnemies = 20;
        int now = aliens.size();
        int counter = startCounterEnemies - now;
        assertEquals(counter,shutDown,"Shutdown Test");
    }
}
