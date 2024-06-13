package de.tu_dresden.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends JFrame {

    Image sky = GameUtil.getImage("images/sky.jpg");
    Image plane = GameUtil.getImage("images/plane.png");

    int planeX = 250, planeY = 250;

    @Override
    public void paint(Graphics g) { // 自动被调用，g相当于一支画笔

        g.drawImage(sky, 0, 0, null);
        g.drawImage(plane, planeX, planeY, null);
        planeX++;
    }


    //反复重画窗口
    class PaintThread extends Thread {

        @Override
        public void run() {
            while (true) {
                repaint(); //重画

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void launchFrame() {


        this.setTitle("Practice Work");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(300, 300);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start(); //启动重画窗口
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
