package objects;

import snakegame.SnakeGame;

public class Snake {

    SnakeGame main;
    public int d = 0, l = 1;
    public int sX[] = new int[main.w * main.h], sY[] = new int[main.w * main.h];

    public Snake(int x0, int y0, int x1, int y1) {
        sX[0] = x0;
        sY[0] = y0;
        sX[1] = x1;
        sY[1] = y1;
    }

    public void move() {

        for (int i = l; i > 0; i--) {
            sX[i] = sX[i - 1];
            sY[i] = sY[i - 1];
        }

        if(d == 0) sX[0]++;
        if(d == 1) sY[0]++;
        if(d == 2) sX[0]--;
        if(d == 3) sY[0]--;

        for(int k = l; k > 0; k--){
            if((sX[0] == sX[k]) & (sY[0] == sY[k])){
                l = k;
            }
        }
        if(sX[0] > main.w){
            sX[0] = 0;
        }
        if(sX[0] < 0){
            sX[0] = main.w - 1;
        }
        if(sY[0] > main.h - 1){
            sY[0] = 0;
        }
        if(sY[0] < 0){
            sY[0] = main.h - 1;
        }
        if(l < 2){
            l = 2;
        }

    }
}
