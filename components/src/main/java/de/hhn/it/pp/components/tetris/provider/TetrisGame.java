package de.hhn.it.pp.components.tetris.provider;
import de.hhn.it.pp.components.tetris.TetrisService;
import de.hhn.it.pp.components.tetris.provider.io.Direction;
import de.hhn.it.pp.components.tetris.provider.io.SaveGame;
import de.hhn.it.pp.components.tetris.provider.logic.*;

/**
 * Tetris clone written in Java
 *
 * @author Mario Schweidler, Violetta Manow
 */
public class TetrisGame implements TetrisService {

    private Board board = new Board();

    @Override
    public void startGame() {
        new GameCycle(board).start();
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        board.setDifficultyValue(difficulty);
    }

    @Override
    public void move(Direction direction) {
        switch (direction) {
            case LEFT:;
            case RIGHT:;
            case DOWN:;
        }
    }

    @Override
    public void rotate() {
        board.getCurrentTetromino().rotate();
    }

    @Override
    public void reset() {
        board.clear();
    }

    @Override
    public void save() {
    }

    @Override
    public void load() {
        //not yet implemented
    }

    @Override
    public int getCurrentTetrominoRotation() throws IllegalStateException, NullPointerException {
        return board.getCurrentTetromino().getRotation();
    }

    @Override
    public int getCurrentTetrominoSpeed() throws IllegalStateException {
        return board.getDifficultyValue();
    }

    @Override
    public int getTetrominoLocation(Tetromino tetromino) throws NullPointerException {
        return tetromino.getX() + tetromino.getY();
    }

    @Override
    public int getTetrominoRotation(Tetromino tetromino) throws NullPointerException {
        return tetromino.getRotation();
    }
}
