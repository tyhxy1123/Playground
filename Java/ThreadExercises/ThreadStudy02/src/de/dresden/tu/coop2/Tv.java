package de.dresden.tu.coop2;

public class Tv {
    String voice;
    boolean flag = true;

    public synchronized void play(String voice){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println("spielt: " + voice);
        this.notify();
        this.flag = !this.flag;
    }

    public synchronized void watch(){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("seht: "+voice);
        this.notify();
        this.flag = !flag;
    }
}
