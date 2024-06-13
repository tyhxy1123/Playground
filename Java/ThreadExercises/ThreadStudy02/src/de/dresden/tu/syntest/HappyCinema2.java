package de.dresden.tu.syntest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HappyCinema2 {
    public static void main(String[] args) {
        List<Integer> total = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            total.add(i);
        }
        Cinema2 cinema = new Cinema2(total, "java happy Kino");
        List<Integer> tickets1 = new ArrayList<>();
        tickets1.add(1);
        tickets1.add(2);
        List<Integer> tickets2 = new ArrayList<>();
        tickets2.add(2);
        new Thread(new Client2(cinema, tickets1), "路人甲").start();
        new Thread(new Client2(cinema, tickets2), "老王").start();
    }
}

class Cinema2 {
    List<Integer> available = new ArrayList<>();
    String name;

    public Cinema2(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTicket(List<Integer> seats) {
        if (available.size() < 1) {
            System.out.println("Tickets sind ausverkauft");
            return false;
        }

        System.out.println("available seats: " + available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);
        copy.removeAll(seats);
        if (available.size() - copy.size() == seats.size()) {
            available = copy;
            System.out.println("booking erfolgt: " + seats);
            return true;
        } else {
            return false;
        }


    }

    public List<Integer> getAvailable() {
        return available;
    }
}

class Client2 implements Runnable {

    Cinema2 cinema;
    List<Integer> seats;

    public Client2(Cinema2 cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        synchronized (cinema) {
            boolean flag = cinema.bookTicket(seats);

            if (flag) {
                System.out.println("booking success! " + Thread.currentThread().getName() + " booked: " + seats);
            } else {
                System.out.println("booking fail! " + Thread.currentThread().getName() + " available seats: " + cinema.getAvailable());
            }
        }
    }
}
