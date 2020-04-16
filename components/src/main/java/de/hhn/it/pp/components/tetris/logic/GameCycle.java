package de.hhn.it.pp.components.tetris.logic;

public class GameCycle extends Thread {

    /**
     * this executes a normal game cycle. collision checks missing
     */
    @Override
    public void run() {
            try {
                if (Board.getBoardState() == Board.BoardState.activeGame) {

                    //TODO collision checks
                    //check for collision with other blocks and walls

                    }

                    if (Board.isSpawnNewTetromino()) {
                        //TODO collision checks
                        Board.addTetromino(Board.getNextTetromino());
                        Board.setCurrentTetromino(Board.getNextTetromino());
                        Board.setNextTetromino(new Tetromino());
                        Board.setSpawnNewTetromino(false);
                    }
                if (!Board.isSpeedUp()) {
                    sleep(1000);
                } else {
                    sleep(100);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }}
