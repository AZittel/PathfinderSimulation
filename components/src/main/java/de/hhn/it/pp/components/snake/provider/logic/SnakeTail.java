package de.hhn.it.pp.components.snake.provider.logic;

public class SnakeTail {

    public int tailXPosition;
    public int tailYPosition;
    private boolean wait = true;

    public SnakeTail (int x, int y) {
        this.tailXPosition = x;
        this.tailYPosition = y;
    }

    //todo kommentieren
    //todo javadoc
    //todo logger

    public int getTailXPosition() {
        return tailXPosition;
    }

    public void setTailXPosition(int tailXPosition) {
        this.tailXPosition = tailXPosition;
    }

    public int getTailYPosition() {
        return tailYPosition;
    }

    public void setTailYPosition(int tailYPosition) {
        this.tailYPosition = tailYPosition;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }


}
