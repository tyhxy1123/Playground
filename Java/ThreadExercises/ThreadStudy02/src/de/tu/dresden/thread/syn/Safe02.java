package de.tu.dresden.thread.syn;

import java.util.ArrayList;
import java.util.List;

public class Safe02 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        Thread tmpThread = null;
        for(int i = 0; i < 10000; i++){
            tmpThread = new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            });
            tmpThread.start();
            tmpThread.join();
        }

        System.out.println(list.size());
    }
}
