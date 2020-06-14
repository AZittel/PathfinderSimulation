package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Clock extends Thread {

    //muss noch in main gestartet werden! start();

    /** Variable for running the Gameclock. */
    public static boolean running = true;

    /** Clock's Logger. */
    public static final Logger logger = LoggerFactory.getLogger(Clock.class);

    /**
     * Runs the Gameclock
     */
    @Override
    public void run() {
        logger.info("gameclock is running");
        while(running) {
            try {
                sleep(200);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collideWithItem();
                if(Collision.collideWithSnake()) {
                    Snake.allTails.clear();
                    Snake.score = 0;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
