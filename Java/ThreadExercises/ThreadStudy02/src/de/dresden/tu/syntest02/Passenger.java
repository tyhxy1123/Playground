package de.dresden.tu.syntest02;

public class Passenger extends Thread{
    Web12306 web12306;
    int seats;



    public Passenger(int seats, Runnable target, String name) {
        super(target, name);
        this.seats = seats;
    }

//    @Override
//    public void run() {
//        synchronized (web12306){
//            boolean flag = web12306.bookingTickets(seats);
//            if(flag){
//                System.out.println("出票成功" + Thread.currentThread().getName() + "--> 位置为: " + seats);
//            }
//            else{
//                System.out.println("出票失败"+ Thread.currentThread().getName()+"位置不够");
//            }
//        }
//    }
}
