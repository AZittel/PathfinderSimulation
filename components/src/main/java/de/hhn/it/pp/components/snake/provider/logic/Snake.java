package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for the playable snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class Snake {
    private static final Logger logger = LoggerFactory.getLogger(Snake.class);
    private int size;
    private int sizeCounter = 2;

    public Snake() {
        size = sizeCounter;
    }

    public int getSize() {
        return size;
    }

    public void setSize() {
        size = sizeCounter++;
    }
}
