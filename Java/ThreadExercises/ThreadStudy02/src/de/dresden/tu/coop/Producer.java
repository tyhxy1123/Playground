package de.dresden.tu.coop;

public class Producer extends Thread {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            container.push(new Product());
//        }
        while(true){
            container.push(new Product());
        }
    }
}
