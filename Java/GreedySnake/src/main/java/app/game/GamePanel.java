package app.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

public class GamePanel extends JPanel {
    public GamePanel() {
        directionImage.put(Direction.up, Images.up);
        directionImage.put(Direction.down, Images.down);
        directionImage.put(Direction.left, Images.left);
        directionImage.put(Direction.right, Images.right);
        init();
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyNum = e.getKeyCode();
                System.out.println(keyNum);
            }
        });
    }

    public void init(){
        coordinates.add(new Coordinate(240, 240));
        coordinates.add(new Coordinate(216, 240));
        coordinates.add(new Coordinate(192, 240));
    }

    private class Coordinate{
        private int x;
        private int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
    private LinkedList<Coordinate> coordinates = new LinkedList();
    private HashMap<Direction, ImageIcon> directionImage = new HashMap();
    private Direction currentDirection = Direction.right;
    private enum Direction{
        right,
        left,
        up,
        down
    }

    private void paintHead(Direction direction, Graphics g, int x, int y){
        directionImage.get(direction).paintIcon(this,g, x, y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(225, 234, 159, 255));

        g.setColor(new Color(21, 181, 210));
        g.fillRect(10,10, 730,730);

        var it = coordinates.iterator();
        var coor = it.next();
        paintHead(currentDirection, g, coor.x, coor.y);
        while(it.hasNext()){
            coor = it.next();
            Images.body.paintIcon(this,g,coor.x,coor.y);
        }
    }
}
