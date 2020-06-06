package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for the playable snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class Snake {

    /** Snake's Logger */
    private static final Logger logger = LoggerFactory.getLogger(Snake.class);

    /** Size of the snake */
    private int size;

    /** Counter for Snake's size */
    private int sizeCounter = 2;

    /**
     * Snake's Constructor
     */
    public Snake() {
        logger.info("Constructor: created Snake");
        size = sizeCounter;
    }

    /**
     * Getter for Snake's size
     *
     * @return Snake's size
     */
    public int getSize() {
        logger.info("get size");
        return size;
    }

    /**
     * Setter for size that increases the size
     */
    public void setSize() {
        logger.info("increased size");
        size = sizeCounter++;
    }
}
