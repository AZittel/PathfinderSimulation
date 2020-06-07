package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Class for the playable snake.
 *
 * @author Karen Hofele, Sören Greiner
 */
public class Snake {

    /** Snake's Logger */
    private static final Logger logger = LoggerFactory.getLogger(Snake.class);

    //todo kommentieren
    //todo javadoc
    //todo logger
    public static boolean waitToMove = false;

    private static SnakeHead snakeHead = new SnakeHead(15, 15);

    public static ArrayList<SnakeTail> allTails = new ArrayList<>();

    public static void addTail () {
        if(allTails.size() <1) {
            allTails.add(new SnakeTail(snakeHead.getHeadXPosition(), snakeHead.getHeadYPosition()));
        } else {
            allTails.add(new SnakeTail(allTails.get(allTails.size() -1).getTailXPosition(), allTails.get(allTails.size() -1).getTailYPosition()));
        }
    }

    public static void move () {
        if(allTails.size() >= 2) {
            for (int i = allTails.size() -1; i >= 1; i--) {
                if(allTails.get(i).isWait()) {
                    allTails.get(i).setWait(false);
                } else {
                    allTails.get(i).setTailXPosition(allTails.get(i-1).getTailXPosition());
                    allTails.get(i).setTailYPosition(allTails.get(i -1).getTailYPosition());
                }
            }
        }

        if(allTails.size() >= 1) {
            if (allTails.get(0).isWait()) {
                allTails.get(0).setWait(false);
            } else {
                allTails.get(0).setTailXPosition(snakeHead.getHeadXPosition());
                allTails.get(0).setTailYPosition(snakeHead.getHeadYPosition());
            }


            }
        switch (snakeHead.getDirection()) {
            case UP:
                snakeHead.setHeadYPosition(snakeHead.getHeadYPosition() -1);
                break;
            case DOWN:
                snakeHead.setHeadYPosition(snakeHead.getHeadYPosition() +1);
                break;
            case LEFT:
                snakeHead.setHeadXPosition(snakeHead.getHeadXPosition() -1);
            case RIGHT:
                snakeHead.setHeadXPosition(snakeHead.getHeadXPosition() +1);
    }

    }

}
