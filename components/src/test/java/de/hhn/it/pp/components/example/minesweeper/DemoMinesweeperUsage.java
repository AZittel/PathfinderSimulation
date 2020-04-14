package de.hhn.it.pp.components.example.minesweeper;

import de.hhn.it.pp.components.minesweeper.provider.Minesweeper;
import de.hhn.it.pp.components.minesweeper.provider.MinesweeperService;

public class DemoMinesweeperUsage {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(DemoMinesweeperUsage.class);

    public static void main(String[] args) throws InterruptedException {
        //Create the Interface from minesweeper.
        logger.info(">>> create minesweeperService");
        MinesweeperService minesweeperService = new Minesweeper();
        logger.info("" + minesweeperService);

        Thread.sleep(3000);

        // Create start menu.
        logger.info(">>> create startMenu");
        minesweeperService.createStartMenu();
        logger.info("" + minesweeperService);

        Thread.sleep(1000);

        // Create game field.
        logger.info(">>> create Field");
        int width = 5;
        int height = 3;
        minesweeperService.createField(width, height);
        logger.info("" + minesweeperService);

        Thread.sleep(3000);

        // Sets the bombs on the fields randomly.
        logger.info(">>> set bombs");
        int bombCount = 10;
        minesweeperService.setBombs(bombCount);
        logger.info("" + minesweeperService);

        Thread.sleep(3000);

        // Restarts the game.
        logger.info(">>> restart game");
        minesweeperService.restart();
        logger.info("" + minesweeperService);


    }
}
