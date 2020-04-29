package de.hhn.it.pp.components.tetris.provider.logic;

public class Collision {

    Board board;

    public Collision(Board thisBoard) {
        this.board = thisBoard;
    }

    public boolean collideWithTetromino(Tetromino b, int direction) {
        // direction: -1 = links, 0 = runter, 1 = rechts

        switch (direction) {
            case -1:
                if (b.getY() > 0) {
                    if (b.getX() > 0) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (board.getMap()[b.getX() + i - 1][b.getY() + j] >= 1) {

                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
            case 0:
                if (b.getY() + b.getSize() > 1) {
                    if (b.getY() - b.getSize() < 17) {
                        try {
                            for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                                for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                    if (b.getBounds()[b.getRotation()][i][j] == 1) {

                                        if (board.getMap()[b.getX() + i][b.getY() + j + 1] >= 1) {

                                            board.setSpawnNewTetromino(true);
                                            fillBlock(b);

                                            return true;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            return false;
                        }
                    }
                }

                break;
            case 1:
                if (b.getY() > 0) {
                    if (b.getX() < 10) {
                        for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                            for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                                if (b.getBounds()[b.getRotation()][i][j] == 1) {
                                    if (board.getMap()[b.getX() + i + 1][b.getY() + j] >= 1) {

                                        return true;
                                    }
                                }
                            }
                        }

                    }
                }
                break;
        }

        return false;
    }

    public boolean collideInRotation(Tetromino b) {
        int rot = b.getRotation() + 1;
        if (rot == 4) {
            rot = 0;
        }

        Tetromino tetromino = new Tetromino();
        tetromino.setRotation(rot);
        tetromino.setBounds(b.getBounds());
        tetromino.setSize(b.getSize());
        tetromino.setX(b.getX()-1);
        tetromino.setY(b.getY());

        if(collideWithWall(tetromino, 1)) {
            return true;
        }
        tetromino.setX(b.getX()+2);
        if(collideWithWall(tetromino, -1)) {
            return true;
        }

        if (b.getY() > 0) {
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

    public boolean collideWithWall(Tetromino b, int direction) {
        // direction: -1 = links, 0 = runter, 1 = rechts
        switch (direction) {
            case -1:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getX() + i == 0) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 0:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
                        if (b.getBounds()[b.getRotation()][i][j] == 1) {
                            if (b.getY() + j == 17) {
                                board.setSpawnNewTetromino(true);
                                fillBlock(b);

                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < b.getBounds()[b.getRotation()].length; i++) {
                    for (int j = 0; j < b.getBounds()[b.getRotation()][i].length; j++) {
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

    private void fillBlock(Tetromino b) {
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
        checkLoose();
    }

    public void checkFullRow(int multiplier) {
        //TODO safe function

        int tetrominosInRow = 0;

        for (int y = board.getMap()[0].length - 1; y > 0; y--) {
            for (int x = 0; x < board.getMap().length; x++) {

                if (board.getMap()[x][y] > 0) {
                    tetrominosInRow++;
                }
            }
            if (tetrominosInRow == 10) {

                board.setScoreToAdd(board.getScoreToAdd()+ (10*multiplier));
                delRow(y, multiplier);
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

    private void delRow(int row, int multiplier) {

        for (int i = 0; i < board.getMap().length; i++) {
            board.getMap()[i][row] = 0;
        }

        for (int y = row; y > 1; y--) {
            for (int x = 0; x < board.getMap().length; x++) {
                board.getMap()[x][y] = board.getMap()[x][y - 1];
            }

        }
        checkFullRow(multiplier + 1);
    }

    private void checkLoose() {
        for (int x = 0; x < board.getMap().length; x++) {

            if (board.getMap()[x][0] > 0) {
                board.boardState = BoardState.gameover;
            }

        }
    }

    }


