package de.tu.dresden.thread.syn;

import java.util.ArrayList;
import java.util.List;

public class Unsafe02 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
