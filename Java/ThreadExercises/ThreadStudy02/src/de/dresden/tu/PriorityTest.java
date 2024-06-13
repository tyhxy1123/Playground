package de.dresden.tu;

public class PriorityTest implements Runnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        PriorityTest p1 = new PriorityTest();
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(p1);
        Thread t4 = new Thread(p1);
        Thread t5 = new Thread(p1);
        Thread t6 = new Thread(p1);
        Thread t7 = new Thread(p1);

        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(9);
        t3.setPriority(8);
        t4.setPriority(7);
        t5.setPriority(6);
        t6.setPriority(5);
        t7.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}
