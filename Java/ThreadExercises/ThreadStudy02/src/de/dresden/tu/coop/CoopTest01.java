package de.dresden.tu.coop;

public class CoopTest01 {
    public static void main(String[] args) throws InterruptedException {
        SynContainer storage = new SynContainer();
        Producer p1 = new Producer(storage);
        Consumer c1 = new Consumer(storage);

        p1.start();
        c1.start();

    }
}
