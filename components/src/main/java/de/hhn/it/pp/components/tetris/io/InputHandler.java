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
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Board.boardState = Board.BoardState.activeGame;

            }
        }

        if (Board.boardState == Board.BoardState.activeGame) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
               //TODO

            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Board.speedup = true;
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                //TODO
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
               //TODO
            }

            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Board.boardState = Board.BoardState.pause;

            }
        } else if (Board.boardState == Board.BoardState.pause) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Board.boardState = Board.BoardState.activeGame;
            }

        } else if (Board.boardState == Board.BoardState.gameover) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                Board.boardState = Board.BoardState.activeGame;
                Board.clear();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
