package de.hhn.it.pp.components.tetris.provider.logic;

import java.util.ArrayList;

import static de.hhn.it.pp.components.tetris.provider.logic.Board.BoardState.*;

public class Board {

    private static int score = 0;

    private static int highscore = 0;

    private static int scoreToAdd = 0;

    private static boolean spawnNewTetromino = false;

    private static boolean speedup = false;

    public static ArrayList<Tetromino> tetrominos = new ArrayList<>();

    private static Tetromino currentTetromino;

    private static Tetromino nextTetromino;

    private static int[][] map = new int[10][18];

    public static BoardState boardState = start;

    /**
     * A Enum in which the Boardstates are described
     */
    public enum BoardState {
        start, activeGame, pause, gameover
    }

    /**
     * clears the board (remove all tetrominos)
     */
    public static void clear() {
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
    public static void addTetromino(Tetromino tetromino) {
        tetrominos.add(tetromino);
    }

    public static void setCurrentTetromino(Tetromino tetromino) {
        currentTetromino = tetromino;
    }

    public static void setNextTetromino(Tetromino tetromino) {
        nextTetromino = tetromino;
    }

    public static boolean isSpeedUp() {
        return speedup;
    }

    public static void setSpeedup(boolean newValue) {
        speedup = newValue;
    }

    public static boolean isSpawnNewTetromino() {
        return spawnNewTetromino;
    }

    public static void setSpawnNewTetromino(boolean newValue) {
        spawnNewTetromino = newValue;
    }

    public static void getTetrominos() {
        for (Tetromino t : tetrominos) {
            System.out.println(t);
        }
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