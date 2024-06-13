package app.game;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var height = 770;
        var width = 750;
        var dimension = Toolkit.getDefaultToolkit().getScreenSize();
        var y = (dimension.height - height)/2;
        var x = (dimension.width - width)/2;
        JFrame jf = new JFrame("小小贪吃蛇");
        jf.setBounds(x,y,width,height);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GamePanel panel = new GamePanel();
        jf.add(panel);
        jf.setVisible(true);
    }
}
