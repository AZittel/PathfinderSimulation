package de.hhn.it.pp.components.tetris.provider.logic;

import java.util.ArrayList;

public class Board {

    private int score = 0;

    private int highscore = 0;

    private int scoreToAdd = 0;

    private boolean spawnNewTetromino = false;

    private boolean speedup = false;

    private int difficultyValue = 0;

    public ArrayList<Tetromino> tetrominos = new ArrayList<>();

    private Tetromino currentTetromino;

    private Tetromino nextTetromino;

    private int[][] map = new int[10][18];

    private Collision myCollision = new Collision();

    public BoardState boardState = BoardState.start;

    /**
     * clears the board (remove all tetrominos)
     */
    public void clear() {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                map[x][y] = 0;
            }
        }
        score = 0;
    }

    /**
     * Adds a Tetromino the the Tetromino arraylist
     * @param tetromino the tetromino that gets added
     */
    public void addTetromino(Tetromino tetromino) {
        tetrominos.add(tetromino);
    }

    public void setCurrentTetromino(Tetromino tetromino) {
        currentTetromino = tetromino;
    }

    public void setNextTetromino(Tetromino tetromino) {
        nextTetromino = tetromino;
    }

    public void setDifficultyValue(Difficulty difficulty){
        switch (difficulty){
            case EASY: difficultyValue = 1500;
            case MEDIUM: difficultyValue = 1000;
            case HARD: difficultyValue = 500;
        }
    }

    public int getDifficultyValue(){
        return difficultyValue;
    }

    public boolean isSpeedUp() {
        return speedup;
    }

    public void setSpeedup(boolean newValue) {
        speedup = newValue;
    }

    public Collision getMyCollision(){
        return myCollision;
    }

    public void setCollision(Collision collision){
        this.myCollision = collision;
    }

    public boolean isSpawnNewTetromino() {
        return spawnNewTetromino;
    }

    public void setSpawnNewTetromino(boolean newValue) {
        spawnNewTetromino = newValue;
    }

    public void setScoreToAdd(int newValue){
        scoreToAdd = newValue;
    }

    public void setScore(int newValue){
        score = newValue;
    }

    public void setHighscore (int newValue) {
        highscore = newValue;
    }


    public void getTetrominos() {
        for (Tetromino t : tetrominos) {
            System.out.println(t);
        }
    }

    public BoardState getBoardState() {
        return boardState;
    }

    public int getHighscore() {
        return highscore;
    }

    public int getScore() {
        return score;
    }

    public int getScoreToAdd() {
        return scoreToAdd;
    }


    public int[][] getMap() {
        return map;
    }

    public Tetromino getCurrentTetromino() {
        return currentTetromino;
    }

    public Tetromino getNextTetromino() {
        return nextTetromino;
    }

}