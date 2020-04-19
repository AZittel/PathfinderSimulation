package de.hhn.it.pp.components.tetris.provider;
import de.hhn.it.pp.components.tetris.TetrisService;
import de.hhn.it.pp.components.tetris.provider.logic.Board;
import java.io.IOException;

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
    public void load() throws IOException {
        //not yet implemented
    }
}
