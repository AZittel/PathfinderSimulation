package de.hhn.it.pp.components.tetris.provider.logic;

public class GameCycle extends Thread {

    private Board board = new Board();

    /**
     * this executes a normal game cycle
     */
    @Override
    public void run() {
            try {
                // TODO this should be overhauled once the gui is in place (start/stop and stuff)
                if (board.getBoardState() == BoardState.activeGame) {
                    //check for collision with other blocks and walls
                    if (!board.getMyCollision().collideWithWall(this.board, board.getCurrentTetromino(), 0)) {
                        board.getCurrentTetromino().setY(board.getCurrentTetromino().getY() + 1);
                        board.getMyCollision().collideWithWall(this.board, board.getCurrentTetromino(), 0);

                    }
                }
                    if (board.isSpawnNewTetromino()) {
                        board.getMyCollision().checkFullRow(this.board,1);
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
    }

    public Board getBoard(){
        return board;
    }
}
