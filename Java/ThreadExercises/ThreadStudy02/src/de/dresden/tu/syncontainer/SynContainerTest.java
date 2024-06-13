package de.dresden.tu.syncontainer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynContainerTest {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//        ArrayList<String> list = new ArrayList();
        Thread tmpThread = null;
        for(int i = 0; i < 10; i++){
            tmpThread = new Thread(()->{

                    list.add(Thread.currentThread().getName());

            });
            tmpThread.start();
            tmpThread.join();
        }
        System.out.println(list);
        System.out.println(list.size());
    }
}
