package de.tu_dresden.game;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
    double x, y;
    static Image[] images = new Image[16];

    static {
        for (int i = 0; i < images.length; i++) {
            images[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
            images[i].getWidth(null);
        }
    }

    int count;

    public void draw(Graphics g) {
        if (count <= 15) {
            g.drawImage(images[count], (int) x, (int) y, null);
            count++;
        }
    }
}
