package objects;

import snakegame.SnakeGame;

public class Apple {

    SnakeGame main;
    public int pX, pY;

    public Apple(int sX, int sY){
        pX = sX;
        pY = sY;
    }
    public void setRandomPosition(){
        pX = (int) (Math.random() * main.w);
        pY = (int) (Math.random() * main.h);
    }
}
