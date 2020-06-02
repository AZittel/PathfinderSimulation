package de.hhn.it.pp.components.minesweeper.provider;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;
import de.hhn.it.pp.components.minesweeper.BombPosition;
import de.hhn.it.pp.components.minesweeper.FieldInformation;
import de.hhn.it.pp.components.minesweeper.MinesweeperService;


public class Minesweeper implements MinesweeperService {
    private int bombCount;
    private int points;
    int width;
    int heigth;
    private FieldInformation[][] fieldInformations;
    private BombPosition[] bombPositions;
    /**
     * creates a game field.
     */
    @Override
    public void createField(int width, int height) throws IllegalArgumentException, IllegalParameterException {
        fieldInformations = new FieldInformation[width][height];
        this.width = width;
        this. heigth = height;
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
        FieldInformation[][] fieldInformations = new FieldInformation[width][height];
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
        if(fieldInformations[x][y].getBomb() == true){
            for(int i = 0; i < width; i++){
                for(int j = 0; j < heigth; j++){
                    fieldInformations[i][j].setIsHidden(false);
                    return fieldInformations;
                }
            }
        }
        if(fieldInformations[x][y].getNumber() != 0){
            fieldInformations[x][y].setIsHidden(false);
            return fieldInformations;
        }else {
            if(x == 0 && y == heigth){
               turn(x + 1, y);
               turn(x + 1, y - 1);
               turn(x, y - 1);
            }else if(x == width && y == heigth){
                turn(x, y - 1);
                turn(x - 1, y - 1);
                turn(x - 1, y);
            }else if(x == width && y == 0){
                turn(x, y + 1);
                turn(x - 1, y + 1);
                turn(x - 1, y);
            }else if(x == width && y == 0){
                turn(x, y + 1);
                turn(x + 1, y + 1);
                turn(x + 1, y);
            }else{
                turn(x, y + 1);
                turn(x + 1, y + 1);
                turn(x + 1, y);
                turn(x + 1, y - 1);
                turn(x, y - 1);
                turn(x - 1, y - 1);
                turn(x - 1, y);
                turn(x - 1, y + 1);
            }
        }
        return fieldInformations;
    }
    /**
     * Sets the bombs which are used to test our program and to see if the program gets the bombs location.
     */
    @Override
    public void setFixBombs() {
        fieldInformations[0][0].setBomb();
        processNumbers(0, 0);
        fieldInformations[1][1].setBomb();
        processNumbers(1, 1);
        fieldInformations[2][2].setBomb();
        processNumbers(2, 2);
        fieldInformations[3][1].setBomb();
        processNumbers(3, 1);

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


    public void processNumbers(int x, int y){
        if(x == 0 && y == heigth){
            fieldInformations[x + 1][y].increaseNumber();
            fieldInformations[x + 1][y - 1].increaseNumber();
            fieldInformations[x][y - 1].increaseNumber();
            turn(x + 1, y);
            turn(x + 1, y - 1);
            turn(x, y - 1);
        }else if(x == width && y == heigth){
            fieldInformations[x][y - 1].increaseNumber();
            fieldInformations[x - 1][y - 1].increaseNumber();
            fieldInformations[x - 1][y].increaseNumber();
            turn(x, y - 1);
            turn(x - 1, y - 1);
            turn(x - 1, y);
        }else if(x == width && y == 0){
            turn(x, y + 1);
            turn(x - 1, y + 1);
            turn(x - 1, y);
        }else if(x == width && y == 0){
            turn(x, y + 1);
            turn(x + 1, y + 1);
            turn(x + 1, y);
        }else{
            turn(x, y + 1);
            turn(x + 1, y + 1);
            turn(x + 1, y);
            turn(x + 1, y - 1);
            turn(x, y - 1);
            turn(x - 1, y - 1);
            turn(x - 1, y);
            turn(x - 1, y + 1);
        }
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
