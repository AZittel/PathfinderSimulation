package de.hhn.it.pp.components.snake.provider.logic;

public class SnakeHead {

    Direction direction = Direction.UP;
    private int headXPosition;
    private int headYPosition;

    public SnakeHead (int x, int y) {
        this.headXPosition = x;
        this.headYPosition = y;
    }

    //todo kommentieren
    //todo javadoc
    //todo logger

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getHeadXPosition() {
        return headXPosition;
    }

    public void setHeadXPosition(int headXPosition) {
        this.headXPosition = headXPosition;
    }

    public int getHeadYPosition() {
        return headYPosition;
    }

    public void setHeadYPosition(int headYPosition) {
        this.headYPosition = headYPosition;
    }




}
