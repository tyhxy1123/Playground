package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends JFrame {

    Image sky = GameUtil.getImage("images/sky.jpg");
    Image planeImage = GameUtil.getImage("images/plane.png");

    Plane plane = new Plane(planeImage, 500, 900);
    Shell s1 = new Shell();

    @Override
    public void paint(Graphics g) { // 自动被调用，g相当于一支画笔

        g.drawImage(sky, 0, 0, null);
        plane.drawSelf(g);
        s1.draw(g);


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

    class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.cancelDirection(e);
        }
    }

    public void launchFrame() {


        this.setTitle("Practice Work");
        this.setVisible(true);
        this.setSize(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
        this.setLocation(200, 10);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyMonitor());

        new PaintThread().start(); //启动重画窗口
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}