package de.hhn.it.pp.components.snake.provider.logic;

//todo javadoc
//todo logger
public class Collision {
    //Snake is able to collide with a wall and dies --> later, nice to have


    public static boolean collideWithSnake() {
        for (int i = 0; i <= Snake.allTails.size(); i++) {
            if (Snake.snakeHead.getHeadXPosition() == Snake.allTails.get(i).getTailXPosition() && Snake.snakeHead.getHeadYPosition() == Snake.allTails.get(i).getTailYPosition() && !Snake.allTails.get(i).isWait()) {
                return true;
            }
        }
        return false;
    }



        public static void collideWithItem () {
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

