package de.hhn.it.pp.components.spaceinvaders.JUnit;
import de.hhn.it.pp.components.spaceinvaders.provider.Enemy;
import de.hhn.it.pp.components.spaceinvaders.provider.Player;
import de.hhn.it.pp.components.spaceinvaders.provider.SpaceInvaders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static de.hhn.it.pp.components.spaceinvaders.EnemyType.STANDARD;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Enemy Class Test -Bad Case")

public class TestEnemyGoodCases {
    SpaceInvaders spaceInvaders = new SpaceInvaders();
    ArrayList<Enemy> aliens = new ArrayList<>();
    int shutdown = 0;
    
    @BeforeEach
    void setup(){

        for(int i = 0; i <20; i++) {
            Enemy enemy = new Enemy(100*i, 100*i, STANDARD, 30);
            aliens.add(enemy);
        }

    }

    @Test
    @DisplayName("Size Matters - Test for Aliens")
    //Test für das Erzeugen der Aliens
    void createEnemiesTest(){
        // Erwartet eine Arraylist mit der Größe von 20 (Aliens)
        int a = spaceInvaders.collection();
        assertEquals(20, aliens.size(), "size should be 20");
    }


    @Test
    @DisplayName("Direction Test - Aliens")
    void moveTest()throws IllegalArgumentException{
        int before = aliens.get(1).getX();
        Enemy enemy = aliens.get(1);
        enemy.moveAlien();
        int after = aliens.get(1).getX();
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
