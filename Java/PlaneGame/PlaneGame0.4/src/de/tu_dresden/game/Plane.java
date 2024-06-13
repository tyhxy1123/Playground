package de.tu_dresden.game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {

    boolean left, right, up, down;

    public Plane(Image img, double x, double y) {
        super(img, x, y);
        setSpeed(15);
    }

    public void drawSelf(Graphics g) {
        g.drawImage(getImg(), (int) getX(), (int) getY(), null);

        if (left) {
            setX(getX() - getSpeed());
        } else if (right) {
            setX(getX() + getSpeed());
        }

        if (up) {
            setY(getY() - getSpeed());
        } else if (down) {
            setY(getY() + getSpeed());
        }
    }


    public void addDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            default:
                break;
        }
    }

    public void cancelDirection(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            default:
                break;
        }
    }
}
