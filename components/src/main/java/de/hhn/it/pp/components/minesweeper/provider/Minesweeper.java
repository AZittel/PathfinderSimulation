package de.hhn.it.pp.components.minesweeper.provider;

import de.hhn.it.pp.components.minesweeper.MinesweeperService;

public class Minesweeper implements MinesweeperService {
    /**
     * creates a game field.
     */
    @Override
    public void createField(int width, int height) throws IllegalArgumentException {

    }
    /**
     * Sets bombs on random locations on the field.
     */
    @Override
    public void setBombs(int bombCount) throws IllegalArgumentException {

    }
    /**
     *  resets the field and restarts the game with new bombs
     */
    @Override
    public void restart() {

    }

    @Override
    public void startGame() {

    }

    @Override
    public void endGame() {

    }

    @Override
    public void turn(int x, int y) {

    }

    /**
     * Sets the bombs which are used to test our program and to see if the program gets the bombs location.
     */
    public static void setFixBombs() {

    }
    /**
     * Getter for getting bombs.
     */
    public int getBombs(){
        return 0;
    }

    /**
     * calculates the Points.
     */
    private void calculatePoints(){

    }

    /**
     * Sets the current Points.
     */
    private void setPoints(){

    }

    /**
     * @return returns the current Points.
     */
    private int getPoints(){
        return 0;
    }

}
