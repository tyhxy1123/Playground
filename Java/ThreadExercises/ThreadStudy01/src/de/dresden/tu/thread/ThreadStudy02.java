package de.dresden.tu.thread;

public class ThreadStudy02{
    public static void main(String[] args) {
        TryToStop t1 = new TryToStop();
        new Thread(t1, "兔兔").start();
        new Thread(t1, "虎虎").start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t1.stop();
        System.out.println("Stop 啦！");
    }


}


class TryToStop implements ITryToStop,Runnable{

    @Override
    public void run() {

            while (flag!=true) {
                try {
                    System.out.println("I am sleeping...");
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    System.out.println("Sleep error!");
                }
            }

    }

    public TryToStop() {
    }

    private boolean flag = false;


    @Override
    public void stop() {
        this.flag = true;
    }
}
interface ITryToStop {

    public void stop();
}


