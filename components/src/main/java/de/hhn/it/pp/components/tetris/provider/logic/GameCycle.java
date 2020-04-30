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
                    //check for collision with other blocks and walls
                    if (!Collision.collideWithWall(this.board, board.getCurrentTetromino(), 0)) {
                        board.getCurrentTetromino().setY(board.getCurrentTetromino().getY() + 1);
                        Collision.collideWithWall(this.board, board.getCurrentTetromino(), 0);

                    }


                }

                    if (board.isSpawnNewTetromino()) {
                        Collision.checkFullRow(this.board,1);
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
