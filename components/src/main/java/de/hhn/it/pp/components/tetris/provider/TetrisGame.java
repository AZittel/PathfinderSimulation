package de.hhn.it.pp.components.tetris.provider;
import de.hhn.it.pp.components.tetris.TetrisService;
import de.hhn.it.pp.components.tetris.provider.logic.Tetromino;
import static de.hhn.it.pp.components.tetris.provider.logic.Board.getCurrentTetromino;

public class TetrisGame implements TetrisService {

    @Override
    public void startGame() {
        //new Gamecycle
    }

    @Override
    public void setDifficulty() {
        //not yet implemented
    }

    @Override
    public void move(String direction) {
        //this will work properly with javafx via a keylistener (InputHandler)
    }

    @Override
    public void rotate() {
        getCurrentTetromino().rotate();
    }

    @Override
    public void reset() {
        //Board.clear() and some more code magic
    }

    @Override
    public void save() {
        //not yet implemented
    }

    @Override
    public void load() {
        //not yet implemented
    }

    @Override
    public int getCurrentTetrominoRotation() throws IllegalStateException, NullPointerException {
        return 0;
    }

    @Override
    public int getCurrentTetrominoSpeed() throws IllegalStateException {
        return 0;
    }

    @Override
    public void getTetrominoLocation(Tetromino tetromino) throws NullPointerException {

    }

    @Override
    public int getTetrominoRotation() throws NullPointerException {
        return 0;
    }
}
