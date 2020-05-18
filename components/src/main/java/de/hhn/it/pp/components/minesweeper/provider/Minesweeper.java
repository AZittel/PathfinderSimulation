package de.hhn.it.pp.components.minesweeper.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.BombPosition;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import de.hhn.it.pp.components.minesweeper.MinesweeperService;


public class Minesweeper implements MinesweeperService {
    private int bombCount;
    private FieldInformation[][] fieldInformations;
    private int points;
    private BombPosition [] bombPositions;
    /**
     * creates a game field.
     */
    @Override
    public FieldInformation[][] createField(int width, int height) throws IllegalArgumentException, IllegalParameterException {
        fieldInformations = new FieldInformation[width][height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                fieldInformations[i][j] = new FieldInformation(i, j);
            }
        }
        return fieldInformations;
    }
    /**
     * Sets bombs on random locations on the field.
     */
    @Override
    public void setBombs(int bombCount) throws IllegalArgumentException {
        this.bombCount = bombCount;
        for(int i = 0; i < bombCount; i++){

        }
    }
    /**
     *  resets the field and restarts the game with new bombs
     */
    @Override
    public FieldInformation[][] restart(int width, int height)throws IllegalArgumentException, IllegalParameterException {
        FieldInformation[][] fieldInformations = new FieldInformation[width][height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                fieldInformations[i][j].setNumber(0);
                fieldInformations[i][j].setIsHidden(true);
                fieldInformations[i][j].setActiveFlag(false);
            }
        }
        setBombs(bombCount);
        return fieldInformations;
    }

    /**
     *  Starts the Game.
     */
    @Override
    public void startGame() {

    }

    /**
     * Ends the Game.
     */
    @Override
    public void endGame() {

    }
    /**
     * Checks the clicked field.
     * @param x x-Pos of the clicked field.
     * @param y y-Pos of the clicked field.
     */
    @Override
    public FieldInformation[][] turn(int x, int y) {
        return null;

    }
    /**
     * Sets the bombs which are used to test our program and to see if the program gets the bombs location.
     */
    @Override
    public void setFixBombs(BombPosition[] positions) {


    }
    /**
     * Getter for getting bombs.
     */
    @Override
    public BombPosition[] getBombs() {
        return bombPositions;
    }
        /**
         * calculates the Points.
         */

    public void calculatePoints(){

    }

    /**
     * Sets the current Points.
     */
    public void setPoints(int points){
        this.points = points;

    }

    /**
     * @return returns the current Points.
     */
    @Override
    public int getPoints(){
        return points;
    }

    /**
     * @return the Field.
     */
    @Override
    public FieldInformation[][] getField(){
        return fieldInformations;
    }

}
