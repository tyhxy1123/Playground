package de.dresden.tu.arraysort;

public class NumbersThread implements Runnable {

    private int number;

    public NumbersThread(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 12, 555, 231, 12314, 21421, 9985};
        for (int number : numbers) {
            new Thread(new NumbersThread(number)).start();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(number);
            System.out.println(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
