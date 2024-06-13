package de.dresden.tu.coop2;

public class Main {


    public static void main(String[] args) {
        Tv tv = new Tv();
        Player p1 = new Player(tv);
        Watcher w1 = new Watcher(tv);
        p1.start();
        w1.start();
    }
}
