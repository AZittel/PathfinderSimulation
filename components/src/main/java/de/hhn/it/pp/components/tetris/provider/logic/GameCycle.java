package de.hhn.it.pp.components.tetris.provider.logic;

import de.hhn.it.pp.components.tetris.provider.TetrisGame;

public class GameCycle extends Thread {

    private Board board;

    public GameCycle(Board thisBoard){
        this.board = thisBoard;
    }

    /**
     * this executes a normal game cycle. collision checks missing
     */
    @Override
    public void run() {
            try {
                if (board.getBoardState() == BoardState.activeGame) {

                    //TODO collision checks
                    //check for collision with other blocks and walls

                    }

                    if (board.isSpawnNewTetromino()) {
                        //TODO collision checks
                        board.addTetromino(board.getNextTetromino());
                        board.setCurrentTetromino(board.getNextTetromino());
                        board.setNextTetromino(new Tetromino());
                        board.setSpawnNewTetromino(false);
                    }
                if (!board.isSpeedUp()) {
                    sleep(board.getDifficultyValue());
                } else {
                    sleep(100);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }}
