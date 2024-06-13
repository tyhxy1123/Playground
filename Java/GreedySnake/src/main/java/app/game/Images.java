package app.game;

import javax.swing.*;
import java.net.URL;

public class Images {
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    public static URL headUp = Images.class.getResource("/images/up.png");
    public static URL headDown = Images.class.getResource("/images/down.png");
    public static URL headLeft = Images.class.getResource("/images/left.png");
    public static URL headRight = Images.class.getResource("/images/right.png");
    public static URL foodURL = Images.class.getResource("/images/food.png");
    public static ImageIcon body = new ImageIcon(bodyURL);
    public static ImageIcon up = new ImageIcon(headUp);
    public static ImageIcon down = new ImageIcon(headDown);
    public static ImageIcon left = new ImageIcon(headLeft);
    public static ImageIcon right = new ImageIcon(headRight);
    public static ImageIcon food = new ImageIcon(foodURL);
}
