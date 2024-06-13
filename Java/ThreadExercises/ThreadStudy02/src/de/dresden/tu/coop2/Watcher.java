package de.dresden.tu.coop2;

public class Watcher extends Thread {
    Tv tv;
    public Watcher(Tv tv){
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i = 0; i<20; i++){
            tv.watch();
        }
    }
}
