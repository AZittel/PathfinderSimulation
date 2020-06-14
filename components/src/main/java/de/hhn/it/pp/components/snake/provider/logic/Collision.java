package de.hhn.it.pp.components.snake.provider.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Collision {
    //Snake is able to collide with a wall and dies --> later, nice to have
    /** Collision's Logger. */
    private static final Logger logger = LoggerFactory.getLogger(Collision.class);

    /**
     * Snake collides with itself.
     *
     * @return true if snake collides with itself
     * @return false if snake doesn't collide with itself
     */
    public static boolean collideWithSnake() {
        logger.info("Snake collides with itself");
        for (int i = 0; i < Snake.allTails.size(); i++) {
            if (Snake.snakeHead.getHeadXPosition() == Snake.allTails.get(i).getTailXPosition() && Snake.snakeHead.getHeadYPosition() == Snake.allTails.get(i).getTailYPosition() && !Snake.allTails.get(i).isWait()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Snake collides with item.
     */
    public static void collideWithItem () {
        logger.info("Snake 'collided' with item");
        if (Snake.snakeHead.getHeadXPosition() == Snake.collectibleItem.getXPosition() && Snake.snakeHead.getHeadYPosition() == Snake.collectibleItem.getYPosition()) {
            Snake.collectibleItem.reset();
            Snake.addTail();
            Snake.score += Snake.collectibleItem.getValue();
            if(Snake.score > Snake.highscore) {
                    Snake.highscore = Snake.score;
            }
        }
    }
}

