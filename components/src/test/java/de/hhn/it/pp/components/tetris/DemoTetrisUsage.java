package de.hhn.it.pp.components.tetris;


import de.hhn.it.pp.components.tetris.logic.Tetromino;

/**
 * Demo class for the Java Tetris clone
 */
public class DemoTetrisUsage {

    public static void main(String[] args) {
        Tetromino t = new Tetromino();
        System.out.println("Tetromino type: " + t.getType());
        System.out.println("Tetromino color: " + t.getColor());
        System.out.println("Tetromino rotation: " + t.getRotation());
        t.rotate();
        t.rotate();
        System.out.println("Tetromino (new) rotation: " + t.getRotation());
        Tetromino t2 = new Tetromino();
        System.out.println("Tetromino type: " + t2.getType());
        System.out.println("Tetromino color: " + t2.getColor());
        System.out.println("Tetromino rotation: " + t2.getRotation());
        t2.rotate();
        System.out.println("Tetromino (new) rotation: " + t2.getRotation());
    }
}