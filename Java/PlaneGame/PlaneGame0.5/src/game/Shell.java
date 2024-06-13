package game;

import java.awt.*;

public class Shell extends GameObject {

    private double degree; //弧度，非角度

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public Shell() {
        setX(500);
        setY(200);
        setWidth(10);
        setHeight(10);
        setSpeed(5);

        setDegree(Math.random() * Math.PI * 2);

    }

    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);

        g.fillOval((int) getX(), (int) getY(), getWidth(), getHeight());
        setX(getX() + getSpeed() * Math.cos(getDegree()));
        setY(getY() + getSpeed() * Math.sin(getDegree()));

        if (getX() < 0 || getX() > Constant.WINDOW_WIDTH - getWidth()) {
            setDegree(Math.PI - getDegree());
        }
        if (getY() < 30 || getY() > Constant.WINDOW_HEIGHT - getHeight()) {
            setDegree(-getDegree());
        }


        g.setColor(c);
    }


}
