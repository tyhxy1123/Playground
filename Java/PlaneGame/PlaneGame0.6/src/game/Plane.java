package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    boolean left, right, up, down, live;
    Image planeImage = GameUtil.getImage("images/plane.png");

    public Plane() {
        setImg(planeImage);
        setX(500);
        setY(900);
        setSpeed(6);
        setWidth(99);
        setHeight(124);
        setLive(true);
    }

    public void drawSelf(Graphics g) {


        if (isLive()) {
            g.drawImage(getImg(), (int) getX(), (int) getY(), null);

            if (left) {
                setX(getX() - getSpeed());
            }

            if (right) {
                setX(getX() + getSpeed());
            }

            if (up) {
                setY(getY() - getSpeed());
            }

            if (down) {
                setY(getY() + getSpeed());
            }
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
