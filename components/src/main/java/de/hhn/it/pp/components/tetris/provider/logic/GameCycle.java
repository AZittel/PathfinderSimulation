package de.hhn.it.pp.components.tetris.provider.logic;

import de.hhn.it.pp.components.tetris.provider.TetrisGame;

public class GameCycle extends Thread {

    private Collision clCheck;

    public GameCycle(Collision collision){
        this.clCheck = collision;
    }

    /**
     * this executes a normal game cycle. collision checks missing
     */
    @Override
    public void run() {
            try {
                if (TetrisGame.board.getBoardState() == BoardState.activeGame) {

                    //TODO collision checks
                    //check for collision with other blocks and walls

                    }

                    if (TetrisGame.board.isSpawnNewTetromino()) {
                        //TODO collision checks
                        TetrisGame.board.addTetromino(TetrisGame.board.getNextTetromino());
                        TetrisGame.board.setCurrentTetromino(TetrisGame.board.getNextTetromino());
                        TetrisGame.board.setNextTetromino(new Tetromino());
                        TetrisGame.board.setSpawnNewTetromino(false);
                    }
                if (!TetrisGame.board.isSpeedUp()) {
                    sleep(TetrisGame.board.getDifficultyValue());
                } else {
                    sleep(100);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }}
