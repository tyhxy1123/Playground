package de.dresden.tu.others;

import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("放空大脑一会儿");
        }
        System.out.println("----------end----------");
    }
}
