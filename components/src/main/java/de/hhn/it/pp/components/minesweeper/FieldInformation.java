package de.hhn.it.pp.components.minesweeper;

import de.hhn.it.pp.components.exceptions.IllegalParameterException;


public class FieldInformation {
    private static final org.slf4j.Logger logger =
            org.slf4j.LoggerFactory.getLogger(FieldInformation.class);
    private final int x;
    private final int y;
    private boolean activeFlag;
    private int number;
    private boolean Hidden;

    public FieldInformation(int x, int y) throws IllegalParameterException {
        this.x = x;
        this.y = y;
        this.activeFlag = false;
        this.Hidden = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isActiveFlag() {
        return activeFlag;
    }

    public int getNumber() {
        return number;
    }

    public boolean isHidden() {
        return Hidden;
    }

    public void setActiveFlag(boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setIsHidden(boolean ishidden) {
        this.Hidden = ishidden;
    }
}
