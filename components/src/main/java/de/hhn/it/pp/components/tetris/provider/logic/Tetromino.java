package de.hhn.it.pp.components.tetris.provider.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
    boolean moveable = true;

    /**
     * Constructor for Tetrominos. Assigns a random Tetromino Type upon creation.
     * sets the Color accordingly.
     */
    public Tetromino(){
        type = TetrominoType.randomize();

        try{
            buildTetromino(type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Used to actually build the Tetrominos on the Field
     * @return The Tetromino
     */
    public int[][][] buildTetromino(TetrominoType type) throws FileNotFoundException {
        // the easiest solution was using text files and excel. works for now
        int[][][] bounds;

        switch (type) {
            case I:
                bounds = new int[4][4][4];
                break;
            case O:
                bounds = new int[4][2][2];
                break;
            default:
                bounds = new int[4][3][3];
        }

        File file = new File("resources/" + type + ".txt");
        Scanner sc = new Scanner(file);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; i < bounds[0].length; i++) {

                if (sc.hasNext()) {
                    String[] srow = sc.next().split("");
                    int[] row = new int[bounds[0].length];

                    for (int k = 0; k < row.length; k++) {
                        row[k] = Integer.parseInt(srow[k]);
                        bounds[i][k][j] = row[k];

                    }
                }
            }

        }
        return bounds;
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

    public void setRotation(int newRotation){
        this.rotation = newRotation;
    }
     public void setType(TetrominoType newType){
        this.type = newType;
     }

     public void setX(int newX){
        this.x = newX;
     }

     public void setY(int newY){
        this.y = newY;
     }

     public void setSize (int newSize){
        this.size = newSize;
     }

     public void setBounds(int [][][] newBounds){
        this.bounds = newBounds;
     }

     public void setMoveable(boolean newMoveable){
        this.moveable = newMoveable;
     }

     public int getTypeValue() {
        switch (type) {
            case I:
                return 1;

            case O:
                return 2;

            case Z:
                return 3;

            case S:
                return 4;

            case T:
                return 5;

            case L:
                return 6;

            case J:
                return 7;
        }

        return 0;

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

    public int getSize() {
        return size;
    }
}


