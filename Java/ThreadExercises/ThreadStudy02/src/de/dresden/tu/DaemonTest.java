package de.dresden.tu;

public class DaemonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new NormTread());
        Thread t2 = new Thread(new DaemonThread());
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}

class NormTread implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 5; i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Happy wife, happy life");
        }
    }
}

class DaemonThread implements Runnable{
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep((500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("You can live a good life");
        }
    }
}
