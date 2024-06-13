package de.dresden.tu.syntest02;

public class Web12306 implements Runnable{
    int available;
    String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets(int seats){
        System.out.println("available seats: " + available);
        if(seats > available){
            return false;
        }
        else{
            available -= seats;
            return true;
        }
    }

    public synchronized boolean bookingTickets(int seats){
        System.out.println("Available seats: " + seats);
        if(seats > available){
            return false;
        }
        else {
            available -= seats;
            return true;
        }
    }

    @Override
    public void run() {
            Passenger p = (Passenger) Thread.currentThread();
            boolean flag = this.bookingTickets(p.seats);
            if(flag){
                System.out.println("出票成功" + Thread.currentThread().getName() + "--> 位置为: " + p.seats);
            }
            else{
                System.out.println("出票失败"+ Thread.currentThread().getName()+"位置不够");
            }

    }
}
