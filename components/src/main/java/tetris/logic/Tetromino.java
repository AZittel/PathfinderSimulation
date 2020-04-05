package tetris.logic;

import javafx.scene.paint.Color;

import java.util.Random;

/**
 * This Class used to Create the individual Tetrominos
 */
public class Tetromino {

    private TetrominoType type;
    private int x = 0;
    private int y = 0;
    private int size = 0;
    private int rotation = 0;
    int[][][]bounds;
    Color color;
    boolean moveable = true;

    /**
     * Constructor for Tetrominos. Assigns a random Tetromino Type upon creation.
     * sets the Color accordingly.
     */
    public Tetromino(){
        type = TetrominoType.randomize();
        switch (type){
            case I:
                color = Color.AQUA;
                break;
            case O:
                color = Color.CRIMSON;
                break;
            case Z:
                color = Color.FORESTGREEN;
                break;
            case S:
                color = Color.YELLOW;
                break;
            case T:
                color = Color.SADDLEBROWN;
                break;
            case L:
                color = Color.PINK;
                break;
            case J:
                color = Color.BLUEVIOLET;
                break;
        }
    }

    /**
     * Used to actually build the Tetrominos on the Field
     * @return The Tetromino
     */
    public int[][][] buildTetromino(){
        // TODO: actually make it work
        int[][][] temp = new int[0][0][0];
        return temp;
    }

    /**
     * Used to rotate the Tetromino in one direction.
     */
    public void rotate(){
        rotation++;

        if (rotation >= 4){
            rotation = 0;
        }
    }

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
            Random rnd = new Random(values().length);
            return values()[rnd.nextInt()];
        }
    }

    public TetrominoType getType() {
        return type;
    }

    public int[][][] getBounds() {
        return bounds;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getRotation() {
        return rotation;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}

