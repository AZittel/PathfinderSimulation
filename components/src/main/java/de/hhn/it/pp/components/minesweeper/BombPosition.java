package de.hhn.it.pp.components.minesweeper;

public class BombPosition {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(BombPosition.class);

    private final int x;
    private final int y;

    public BombPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
