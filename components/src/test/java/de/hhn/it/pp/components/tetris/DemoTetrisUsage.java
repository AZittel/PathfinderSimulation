package de.hhn.it.pp.components.tetris;

import de.hhn.it.pp.components.tetris.provider.TetrisGame;
import de.hhn.it.pp.components.tetris.provider.logic.Board;
import de.hhn.it.pp.components.tetris.provider.logic.Tetromino;

import java.awt.event.KeyEvent;

/**
 * Demo class for the Java Tetris clone
 */

public class DemoTetrisUsage {

    public static void main(String[] args) {

        TetrisGame myGame = new TetrisGame();

        myGame.setDifficulty();
        System.out.println("Game difficulty should be set.");
        myGame.startGame();
        System.out.println("Game started.");
        myGame.move(KeyEvent.getKeyText(KeyEvent.VK_LEFT));
        System.out.println("Tetromino moved: " + KeyEvent.getKeyText(KeyEvent.VK_LEFT));
        myGame.move(KeyEvent.getKeyText(KeyEvent.VK_RIGHT));
        System.out.println("Tetromino moved: " + KeyEvent.getKeyText(KeyEvent.VK_RIGHT));
        Board.addTetromino(new Tetromino());
        Board.setCurrentTetromino(Board.tetrominos.get(0));
        System.out.println("Current Tetromino rotation: " + Board.getCurrentTetromino().getRotation());
        myGame.rotate();
        myGame.rotate();
        System.out.println("Current Tetromino rotation: " + Board.getCurrentTetromino().getRotation());
        myGame.move(KeyEvent.getKeyText(KeyEvent.VK_DOWN));
        System.out.println("Tetromino moved: " + KeyEvent.getKeyText(KeyEvent.VK_DOWN));
        myGame.save();
        System.out.println("The user chose to save.");
        myGame.reset();
        System.out.println("Game should now be reset.");
    }
}
