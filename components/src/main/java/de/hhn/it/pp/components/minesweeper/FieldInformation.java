package de.hhn.it.pp.components.minesweeper;

public class FieldInformation {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(FieldInformation.class);
    private final int x;
    private final int y;
    private boolean activFlag;
    private int number;
    private boolean ishidden;

    public FieldInformation(int x, int y) {
        this.x = x;
        this.y = y;
        this.activFlag = false;
        this.ishidden = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isActivFlag() {
        return activFlag;
    }

    public int getNumber() {
        return number;
    }

    public boolean isIshidden() {
        return ishidden;
    }

    public void setActivFlag(boolean activFlag) {
        this.activFlag = activFlag;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setIshidden(boolean ishidden) {
        this.ishidden = ishidden;
    }
}
