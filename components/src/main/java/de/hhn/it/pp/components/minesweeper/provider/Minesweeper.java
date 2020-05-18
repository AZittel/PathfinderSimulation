package de.hhn.it.pp.components.minesweeper.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.BombPosition;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import de.hhn.it.pp.components.minesweeper.MinesweeperService;


public class Minesweeper implements MinesweeperService {
    private int bombCount;
    private FieldInformation[][] fieldInformations;
    public BombPosition[] bombPositions;
    private int points;
    /**
     * creates a game field.
     */
    @Override
    public void createField(int width, int height) throws IllegalArgumentException, IllegalParameterException {
        fieldInformations = new FieldInformation[width][height];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                fieldInformations[i][j] = new FieldInformation(i, j);
            }
        }
    }
    /**
     * Sets bombs on random locations on the field.
     */
    @Override
    public void setBombs(int bombCount) throws IllegalArgumentException {
        bombPositions = new BombPosition[bombCount];
        this.bombCount = bombCount;
        for(int i = 0; i < bombCount; i++){

        }
    }
    /**
     *  resets the field and restarts the game with new bombs
     */
    @Override
    public FieldInformation[][] restart(int width, int height)throws IllegalArgumentException, IllegalParameterException {
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                fieldInformations[i][j].setNumber(0);
                fieldInformations[i][j].setIsHidden(true);
                fieldInformations[i][j].setActiveFlag(false);
            }
        }
        setFixBombs();
        return fieldInformations;
    }

    /**
     *  Starts the Game.
     */
    @Override
    public void startGame(int width, int heigth, int bombCount) throws IllegalParameterException {
        createField(width, heigth);
        setBombs(bombCount);
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
    public void setFixBombs() {
        bombPositions = new BombPosition[4];
        bombPositions[0] = new BombPosition(0, 0);
        bombPositions[1] = new BombPosition(1, 1);
        bombPositions[2] = new BombPosition(2, 2);
        bombPositions[3] = new BombPosition(3, 1);
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
