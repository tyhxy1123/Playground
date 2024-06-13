package de.dresden.tu.syntest;

public class HappyCinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(10, "梦巴黎");
        new Thread(new Client(cinema, 1),"老王").start();
        new Thread(new Client(cinema, 2),"小明").start();
    }
}

class Client implements Runnable{

    Cinema cinema;
    int seats;

    public Client(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTicket(seats);

            if (flag) {
                System.out.println("booking success! " + Thread.currentThread().getName() + " available seats: " + cinema.available);
            } else {
                System.out.println("booking fail! " + Thread.currentThread().getName() + " available seats: " + cinema.available);
            }
        }
    }
}

class Cinema{
    int available;
    String name;

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTicket(int howMuch){
        System.out.println("available seats: " + available);
        if(howMuch>available) {return false;}
        else {available -= howMuch;return true;}
    }
}
