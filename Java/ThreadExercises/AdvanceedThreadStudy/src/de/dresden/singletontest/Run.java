package de.dresden.singletontest;

public class Run {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new MyThread().start();
        }
    }
}

