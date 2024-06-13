package de.tu_dresden.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame {

    Image sky = GameUtil.getImage("images/sky.jpg");

    Plane plane = new Plane();
    Shell s1 = new Shell();
    Shell[] armory = new Shell[50];

    @Override
    public void paint(Graphics g) { // 自动被调用，g相当于一支画笔

        g.drawImage(sky, 0, 0, null);

        plane.drawSelf(g);

        for (Shell s : armory) {
            s.draw(g);
            if (plane.isLive() && s.getRect().intersects(plane.getRect())) {
                plane.setLive(false);
            }
        }

    }

    // 反复重画窗口
    class PaintThread extends Thread {

        @Override
        public void run() {
            while (true) {
                repaint(); // 重画

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

        new PaintThread().start(); // 启动重画窗口

        // 初始化火药库
        for (int i = 0; i < armory.length; i++) {
            armory[i] = new Shell();
        }
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(Constant.WINDOW_WIDTH, Constant.WINDOW_HEIGHT);
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}