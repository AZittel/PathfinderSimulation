package de.hhn.it.pp.components.tetris.provider.logic;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Used to organize the Tetromino Types
 */
public enum TetrominoType{
    I,O,Z,S,T,L,J;

    /**
     * Randomizes the Tetromino Type
     * @return a random Tetromino
     */
    public static TetrominoType randomize(){
        return values()[ThreadLocalRandom.current().nextInt(0,values().length)];
    }
}
