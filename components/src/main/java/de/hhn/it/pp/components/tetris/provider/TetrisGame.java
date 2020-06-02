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

    private GameCycle myGame = new GameCycle();

    @Override
    public void startGame() {
        myGame.start();
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        myGame.getBoard().setDifficultyValue(difficulty);
    }

    @Override
    public void move(Direction direction) {
        Move.moveTetromino(myGame.getBoard(),direction);
    }

    @Override
    public void rotate() {
        myGame.getBoard().getCurrentTetromino().rotate();
    }

    @Override
    public void reset() {
        myGame.getBoard().clear();
    }

    @Override
    public void save() {
        SaveGame.save(myGame.getBoard());
    }

    @Override
    public void load() {
        SaveGame.load(myGame.getBoard());
    }

    @Override
    public int getCurrentTetrominoRotation() throws IllegalStateException, NullPointerException {
        return myGame.getBoard().getCurrentTetromino().getRotation();
    }

    @Override
    public int getCurrentTetrominoSpeed() throws IllegalStateException {
        return myGame.getBoard().getDifficultyValue();
    }

    @Override
    public int[] getTetrominoLocation(Tetromino tetromino) throws NullPointerException {
        int xCord = tetromino.getX();
        int yCord = tetromino.getY();
        return new int[] {xCord, yCord};
    }

    @Override
    public int getTetrominoRotation(Tetromino tetromino) throws NullPointerException {
        return tetromino.getRotation();
    }

    public BoardState getBoardState(){
        return myGame.getBoard().getBoardState();
    }

    public void setBoardState(BoardState boardState){
        myGame.getBoard().setBoardState(boardState);
    }
}
