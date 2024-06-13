package de.dresden.tu.coop;

public class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run(){

//        for (int i = 0; i < 1000; i++) {
//
//            System.out.println(container.pop().getId());
//        }
        while(true){
            System.out.println(container.pop().getId());
        }
    }
}
