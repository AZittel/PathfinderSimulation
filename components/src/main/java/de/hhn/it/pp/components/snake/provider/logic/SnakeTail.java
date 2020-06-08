package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for snake's tail
 *
 * @author Karen Hofele, Sören Greiner
 */
public class SnakeTail {

    /** Snaketail's Logger */
    private static final Logger logger = LoggerFactory.getLogger(SnakeTail.class);

    /** Tail's x-coordinate */
    public int tailXPosition;

    /** Tail's y-coordinate */
    public int tailYPosition;

    /** Boolean for new tail, needs to wait one step before it moves */
    private boolean wait = true;

    /**
     * Constructor
     *
     * @param x initial x-coordinate
     * @param y initial y-coordinate
     */
    public SnakeTail (int x, int y) {
        logger.info("Constructor of Snaketail with x-coordinate {} and y-coordinate {}", x, y);
        this.tailXPosition = x;
        this.tailYPosition = y;
    }

    //todo javadoc
    //todo logger

    /**
     * Getter for tail's x-coordinate
     *
     * @return tail's x-coordinate
     */
    public int getTailXPosition() {
        logger.info("get snaketail's x-coordinate");
        return tailXPosition;
    }

    /**
     * Setter for tail's x-coordinate
     *
     * @param tailXPosition tail's x-coordinate
     */
    public void setTailXPosition(int tailXPosition) {
        logger.info("set tail's x-coordinate to {}", tailXPosition);
        this.tailXPosition = tailXPosition;
    }

    /**
     * Getter for tail's y-coordinate
     *
     * @return tail's y-coordinate
     */
    public int getTailYPosition() {
        logger.info("get tail's y-coordinate");
        return tailYPosition;
    }

    /**
     * Setter for tail's y-coordinate
     *
     * @param tailYPosition tail's y-coordinate
     */
    public void setTailYPosition(int tailYPosition) {
        logger.info("set tail's y-coordinate to {}", tailYPosition);
        this.tailYPosition = tailYPosition;
    }

    /**
     * Getter for wait
     *
     * @return wait
     */
    public boolean isWait() {
        logger.info("get wait's value");
        return wait;
    }

    /**
     * Setter for wait
     *
     * @param wait wait's value
     */
    public void setWait(boolean wait) {
        logger.info("set wait to {}", wait);
        this.wait = wait;
    }


}
