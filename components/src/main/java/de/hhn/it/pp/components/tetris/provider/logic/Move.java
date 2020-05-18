package de.hhn.it.pp.components.tetris.provider.logic;
import de.hhn.it.pp.components.tetris.provider.io.Direction;

public class Move {

    public static void moveTetromino(Board board, Direction direction){
        switch (direction){
            case LEFT:
                try {
                    if (!board.getMyCollision().collideWithWall(board, board.getCurrentTetromino(), -1)
                            && !board.getMyCollision().collideWithTetromino(board, board.getCurrentTetromino(), - 1)) {
                        board.getCurrentTetromino().setX(board.getCurrentTetromino().getX() - 1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case RIGHT:
                try {
                    if (!board.getMyCollision().collideWithWall(board, board.getCurrentTetromino(), 1)
                            && !board.getMyCollision().collideWithTetromino(board, board.getCurrentTetromino(), 1)) {
                        board.getCurrentTetromino().setX(board.getCurrentTetromino().getX() + 1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case DOWN:
                board.setSpeedup(true);
        }
    }
}
