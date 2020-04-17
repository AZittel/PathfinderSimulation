package de.hhn.it.pp.components.tetris.io;

import de.hhn.it.pp.components.tetris.logic.Board;

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
        if (Board.boardState == Board.BoardState.start) {
            // ENTER keystroke
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Board.boardState = Board.BoardState.activeGame;

            }
        }

        if (Board.boardState == Board.BoardState.activeGame) {
            // SPACEBAR keystroke
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
               //TODO

            }

            // DOWN keystroke
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Board.setSpeedup(true);
            }

            // RIGHT keystroke
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                //TODO write collision checks
            // LEFT keystroke
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               //TODO write collision checks
            }

            // ESCAPE keystroke
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Board.boardState = Board.BoardState.pause;

            }
        } else if (Board.boardState == Board.BoardState.pause) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Board.boardState = Board.BoardState.activeGame;
            }

            // ENTER keystroke (set active game)
        } else if (Board.boardState == Board.BoardState.gameover) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Board.boardState = Board.BoardState.activeGame;
                Board.clear();
            }

        }

    }

    /**
     * resets the gamespeed to normal value if down key is released
     * @param keyEvent
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (Board.boardState == Board.BoardState.activeGame) {
            if (keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
                Board.setSpeedup(false);
            }
        }
    }
}
