package tetris.logic;

import javafx.scene.paint.Color;

import java.util.Random;

public class Tetromino {

    private TetrominoType type;
    private int x = 0;
    private int y = 0;
    private int size = 0;
    private int rotation = 0;
    int[][][]bounds;
    Color color;
    boolean moveable = true;

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

    public int[][][] buildBlock(){
        int temp[][][] = new int[0][0][0];
        return temp;
    }

    public enum TetrominoType{
        I,O,Z,S,T,L,J;

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

