package de.hhn.it.pp.components.minesweeper;

import de.hhn.it.pp.components.minesweeper.exceptions.InvalidGameStateException;
import de.hhn.it.pp.components.minesweeper.provider.Minesweeper;

public class DemoMinesweeperUsage {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(DemoMinesweeperUsage.class);

    public static void main(String[] args) throws InterruptedException, InvalidGameStateException {
        //Create the Interface from minesweeper.
        logger.info(">>> create minesweeperService");
        MinesweeperService minesweeperService = new Minesweeper();
        logger.info("" + minesweeperService);

        Thread.sleep(3000);


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

        Thread.sleep(3000);

        // Starts the game.
        logger.info(">>> Start game");
        minesweeperService.startGame();
        logger.info("" + minesweeperService);

        Thread.sleep(3000);

        // Ends the game.
        logger.info(">>> end game");
        minesweeperService.endGame();
        logger.info("" + minesweeperService);

        Thread.sleep(3000);

        // turn.
        logger.info(">>> turn");
        int x = 3;
        int y = 4;
        minesweeperService.turn(x,y);
        logger.info("" + minesweeperService);





    }
}
