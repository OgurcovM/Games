package snakegame;

import objects.Apple;
import objects.Snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {

    Timer timer = new Timer(1000/sp, this);
    public static final int s = 32, w = 20, h = 20, sp = 5;
    final String GAME_OVER_TITLE = "Игра окончена";
    boolean gameOver = false;
    Apple apple = new Apple((int) (Math.random() * w), (int) (Math.random() * h));
    Snake snake = new Snake(10, 10, 9, 10);

    public SnakeGame(){
        timer.start();
        addKeyListener(new Keyboard());
        setFocusable(true);
    }
    //цвет
    public void paint(Graphics graphics){
        graphics.setColor(color(255, 250, 250));
        graphics.fillRect(0, 0, w * s, h * s);
        graphics.setColor(color(0, 0, 0));

        for(int i = 0; i <= w * s; i += s){
            graphics.drawLine(i, 0, i, h * s);
        }
        for(int k = 0; k <= h * s; k += s){
            graphics.drawLine(0, k, w * s, k);
        }
        for(int j = 0; j < snake.l; j++){
            graphics.setColor(color(34, 139, 34));
            graphics.fillRect(snake.sX[j] * s + 1, snake.sY[j] * s + 1, s - 1, s - 1);
        }
        graphics.setColor(color(255, 0, 0));
        graphics.fillRect(apple.pX * s + 1, apple.pY * s + 1, s - 1, s - 1);
    }
    //цвет
    public Color color(int red, int green, int blue){
        return new Color(red, green, blue);

    }

    public static void main(String[] args){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(w * s + 16, h * s + 3);
        jFrame.setLocationRelativeTo(null);
        //цвет
        jFrame.add(new SnakeGame());
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        if((snake.sX[0] == apple.pX) & snake.sY[0] == apple.pY){
            apple.setRandomPosition();
            snake.l++;
        }
        for(int q = 1; q < snake.l; q++) {
            if ((snake.sX[q] == apple.pX) & snake.sY[q] == apple.pY) {
                apple.setRandomPosition();
                snake.l++;
            }
        }
        repaint();
    }

    private class Keyboard extends KeyAdapter{
        public void keyPressed(KeyEvent keyEvent){
            int key = keyEvent.getKeyCode();
            if((key == KeyEvent.VK_RIGHT) & snake.d != 2) {
                snake.d = 0;
            }
            if((key == KeyEvent.VK_DOWN) & snake.d != 3) {
                snake.d = 1;
            }
            if((key == KeyEvent.VK_LEFT) & snake.d != 0) {
                snake.d = 2;
            }
            if((key == KeyEvent.VK_UP) & snake.d != 1) {
                snake.d = 3;
            }
        }
    }
}
