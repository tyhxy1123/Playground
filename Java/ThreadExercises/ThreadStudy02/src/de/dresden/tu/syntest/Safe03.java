package de.dresden.tu.syntest;

public class Safe03 implements Runnable {
    private TicketsBox tb;
    private boolean flag = true;

    public Safe03(TicketsBox tb) {
        this.tb = tb;
    }

    public static void main(String[] args) {
        TicketsBox tb = new TicketsBox();
        Safe03 s = new Safe03(tb);
        new Thread(s,"张三").start();
        new Thread(s,"李四").start();
        new Thread(s,"王五").start();
    }


    //线程安全问题
    //double checking
    //主要考虑临界值的问题
    public void test() {

        //考虑的是没票的情况
        if (tb.getTickets() < 1) {
            flag = false;
            return;
        }

        synchronized (this) {

            //考虑的是最后一张票的情况
            if(tb.getTickets() < 1) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "-->" + tb.getTicket());

        }



    }

    @Override
    public void run() {
        while(flag){
            test();
        }
        System.out.println("the rest tickets is: " + tb.getTickets());
    }

}

class TicketsBox{

//    private boolean flag = true;
    private int tickets = 1000;

    public int getTicket(){
        return tickets--;
    }

//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//
//    public boolean getFlag(){
//        return flag;
//    }

    public int getTickets() {
        return tickets;
    }
}
