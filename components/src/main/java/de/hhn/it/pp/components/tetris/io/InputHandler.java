package de.hhn.it.pp.components.tetris.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This Class is the Listener for User Inputs and initiates the actions according to the input.
 *
 */
public class InputHandler implements KeyListener {


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    /**
     * this method reads the Input and executes the actions according to the input.
     * @param e the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO if startButton is pressed, Board.boardState = Board.Boardstate.activeGame
        // TODO if spaceButton is pressed, the Tetromino should rotate
        // TODO if downButton is pressed, the Tetromino should speed up
        // TODO if rightButton is pressed the Tetromino should move one space to the right
        // TODO if leftButton is pressed the Tetromino should move one space to the right
        // TODO if EscButton is pressed, Board.boardstate = Board.Boardstate.gameover
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
