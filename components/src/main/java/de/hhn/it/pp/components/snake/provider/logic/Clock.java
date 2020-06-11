package de.hhn.it.pp.components.snake.provider.logic;

public class Clock extends Thread {

    //todo logger
    //todo javadoc
    //muss noch in main gestartet werden! start();

    public static boolean running = true;

    @Override
    public void run() {
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
