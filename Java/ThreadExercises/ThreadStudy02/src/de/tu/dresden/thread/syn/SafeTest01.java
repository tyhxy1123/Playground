package de.tu.dresden.thread.syn;

public class SafeTest01 {

        public static void main(String[] args) {
            TicketsBox box = new TicketsBox();
            new Thread(box, "张三").start();
            new Thread(box, "李四").start();
            new Thread(box, "王五").start();

        }

    }
    class TicketsBox implements Runnable {
        private int tickets = 100;
        private boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                findTicket();
            }
        }

        private synchronized void findTicket() {
            if (tickets < 1) {
                flag = false;
                return;
            }
            System.out.println(Thread.currentThread().getName() + " gets the ticket num: " + tickets--);

        }

    }

