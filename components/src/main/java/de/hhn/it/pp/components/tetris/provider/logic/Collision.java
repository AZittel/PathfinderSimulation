package de.hhn.it.pp.components.tetris.provider.logic;

public class Collision {

    /**
     * Method to identify if the Tetromino is colliding with another.
     *
     * @param board     the board
     * @param b         current tetromino
     * @param direction current direction the Tetromino has
     * @return boolean true if a Collision happened
     */
    public boolean collideWithTetromino(Board board, Tetromino b, int direction) {
        // direction: -1 = left, 0 = down, 1 = right

        switch (direction) {
            case -1:
                //checks if the Tetromino is inside the Map and not on the left Wall
                if (b.getY() > 0 && b.getX() > 0) {
                    //iteration to check for all sub-Tetromino-Blocks of the Tetromino
                    for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                        for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                            //checks if there is a Tetromino already placed left to the current Tetromino
                            if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                if (board.getMap()[b.getX() + i - 1][b.getY() + j] >= 1) {

                                    return true;
                                }
                            }
                        }
                    }

                }
                break;
            case 0:
                //checks that the Tetromino is inside the Map
                if (b.getY() + b.getSize() > 1 && b.getY() - b.getSize() < 17) {

                    try {
                        //iteration to check for all sub-Tetromino-Blocks of the Tetromino
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                //checks if there is a Tetromino already placed underneath the current Tetromino
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (board.getMap()[b.getX() + i][b.getY() + j + 1] >= 1) {
                                        //when the Tetromino lands ontop of a  already placed Tetromino a new Tetromino will spawn
                                        //the placed TetrominoTypeValue will be added to the Map
                                        board.setSpawnNewTetromino(true);
                                        fillTetromino(board, b);

                                        return true;
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        return false;
                    }

                }

                break;
            case 1:
                //checks if the Tetromino is inside the Map and not on the right Wall
                if (b.getY() > 0 && b.getX() < 10) {
                    //iteration to check for all sub-Tetromino-Blocks of the Tetromino
                    for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                        for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                            //checks if there is a Tetromino already placed to the right of the current Tetromino
                            if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                if (board.getMap()[b.getX() + i + 1][b.getY() + j] >= 1) {

                                    return true;
                                }
                            }
                        }
                    }


                }
                break;
        }

        return false;
    }

    /**
     * Method to check if the Tetromino would collide with something while rotating.
     *
     * @param board the board
     * @param b     current Tetromino
     * @return boolean true if a Collision happened
     */
    public boolean collideInRotation(Board board, Tetromino b) {

        int rot = b.getRotation() + 1;
        // if the rotation is set to 4 the next would be 0
        if (rot == 4) {
            rot = 0;
        }
        //creating a new Tetromino with next rotation
        Tetromino tetromino = new Tetromino();
        tetromino.setRotation(rot);
        tetromino.setBounds(b.getBounds());
        tetromino.setSize(b.getSize());
        tetromino.setX(b.getX() - 1);
        tetromino.setY(b.getY());

        //Check if the Tetromino would collide with the walls
        if (collideWithWall(board, tetromino, 1)) {
            return true;
        }
        //check if the Tetromino would still be above the bottom
        if (b.getY() > 0) {
            //iteration to check for all sub-Tetromino-Blocks of the Tetromino
            for (int i = 0; i < b.getBounds()[rot].length; i++) {
                for (int j = 0; j < b.getBounds()[rot][i].length; j++) {
                    if (b.getBounds()[rot][i][j] == 1) {
                        try {
                            if (board.getMap()[b.getX() + i][b.getY() + j] >= 1) {

                                return true;
                            }
                        } catch (Exception e) {
                            return true;
                        }
                    }
                }

            }
        }

        return false;
    }

    /**
     * Method to identify if the Tetromino is colliding with the walls of the map.
     *
     * @param board     the board
     * @param b         current tetromino
     * @param direction current direction the Tetromino has
     * @return boolean true if a Collision happened
     */
    public boolean collideWithWall(Board board, Tetromino b, int direction) {
        // direction: -1 = left, 0 = down, 1 = right
        switch (direction) {
            case -1:
                //iteration to check for all sub-Tetromino-Blocks of the Tetromino
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        //check if the current Tetromino is on the left Wall
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + i == 0) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 0:
                //iteration to check for all sub-Tetromino-Blocks of the Tetromino
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        //check if the current Tetromino is on the bottom Wall
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getY() + j == 17) {
                                //when the Tetromino hits the Bottom of the Map a new Tetromino will spawn
                                //the placed TetrominoTypeValue will be added to the Map
                                board.setSpawnNewTetromino(true);
                                fillTetromino(board, b);

                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                //iteration to check for all sub-Tetromino-Blocks of the Tetromino
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        //check if the current Tetromino is on the right Wall
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + (i + 2) >= 11) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }

        return false;
    }

    /**
     * Adds the currently placed Tetromino and adds their typevalue to the map
     *
     * @param board the board
     * @param b the Tetromino that gets filled
     */
    private void fillTetromino(Board board, Tetromino b) {
        try {
            for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                    if (b.getBounds()[b.getRotation()][i][j] == 1) {
                        board.getMap()[b.getX() + i][b.getY() + j] = b.getTypeValue();

                    }

                }
            }
        } catch (Exception e) {

        }
        checkLoose(board);
    }

    /**
     * Method to check every row from the bottom to the top if the entire row is filled with Tetrominos
     *
     * @param board         the board
     * @param multiplier    the multiplier value
     */
    public void checkFullRow(Board board, int multiplier) {
        //TODO safe function

        int tetrominosInRow = 0;

        for (int y = board.getMap()[0].length - 1; y > 0; y--) {
            for (int x = 0; x < board.getMap().length; x++) {

                if (board.getMap()[x][y] > 0) {
                    tetrominosInRow++;
                }
            }
            if (tetrominosInRow == 10) {

                board.setScoreToAdd(board.getScoreToAdd() + (10 * multiplier));
                delRow(board, y, multiplier);
                break;
            } else {
                tetrominosInRow = 0;
            }

        }

        board.setScore(board.getScoreToAdd());
        board.setScoreToAdd(0);

        if (board.getScore() > board.getHighscore()) {
            board.setHighscore(board.getScore());

        }
    }

    /**
     * Used to delete a filled row
     * @param board         the board
     * @param row           the row to delete
     * @param multiplier    the point multiplier
     */
    private void delRow(Board board, int row, int multiplier) {

        for (int i = 0; i < board.getMap().length; i++) {
            board.getMap()[i][row] = 0;
        }

        for (int y = row; y > 1; y--) {
            for (int x = 0; x < board.getMap().length; x++) {
                board.getMap()[x][y] = board.getMap()[x][y - 1];
            }

        }
        checkFullRow(board, multiplier + 1);
    }

    /**
     * Method to determine a gameover by checking if a Tetromino reaches to the highest row in the map
     *
     * @param board the board
     */
    private void checkLoose(Board board) {
        for (int x = 0; x < board.getMap().length; x++) {

            if (board.getMap()[x][0] > 0) {
                board.setBoardState(BoardState.gameover);
            }
        }
    }
}