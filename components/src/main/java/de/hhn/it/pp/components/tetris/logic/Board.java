package de.hhn.it.pp.components.tetris.logic;

import java.util.ArrayList;

public class Board {

    private static int score = 0;

    private static int highscore = 0;

    private static int scoreToAdd = 0;

    private static boolean spawnNewTetromino = false;

    private static boolean speedup = false;

    private static ArrayList<Tetromino> tetrominos = new ArrayList<Tetromino>();

    private static Tetromino currentTetromino;

    private static Tetromino nextTetromino;

    private static int[][] map = new int[10][18];

    private static BoardState boardState = BoardState.start;

    /**
     * This method is supposed to clear all Tetrominos from the Board
     */

    public void addTetromino(Tetromino tetromino) {
        tetrominos.add(tetromino);
    }

    public void setCurrentTetromino(Tetromino tetromino){
        tetromino = tetromino;
    }

    public void isSpeedUp (Boolean speedUp){
    if(speedup= false){

    }
    else{

    }
    }

    public void setSpeedup (Boolean speedUp){
    if(speedup = false){

    }
    else{

    }
    }

    public void isSpawnNewTetromino (Boolean spawnNewTetromino){
        if(spawnNewTetromino = false){

        }
        else{

        }
    }

    private static void clear() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = 0;
            }
        }
        score = 0;
    }

    /**
     * A Enum in which the Boardstates are described
     */
    public enum BoardState{
        start, activeGame, pause, gameover
    }

    public static ArrayList<Tetromino> getTetrominos() {
        return tetrominos;
    }

    public static BoardState getBoardState() {
        return boardState;
    }

    public static int getHighscore() {
        return highscore;
    }

    public static int getScore() {
        return score;
    }

    public static int getScoreToAdd() {
        return scoreToAdd;
    }

    public static int[][] getMap() {
        return map;
    }

    public static Tetromino getCurrentTetromino() {
        return currentTetromino;
    }

    public static Tetromino getNextTetromino() {
        return nextTetromino;
    }
}