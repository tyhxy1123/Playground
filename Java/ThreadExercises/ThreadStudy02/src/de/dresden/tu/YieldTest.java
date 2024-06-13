package de.dresden.tu;

public class YieldTest{

    public static void main(String[] args) {
        new Thread(()-> {
            for(int i=0; i < 100; i++){
                System.out.println("Thread..."+i);
            }
        }).start();

        for(int i = 0; i < 100; i++){
            if( i % 20 ==0){
                Thread.yield();
            }
            System.out.println("Main..."+i);
        }
    }
}
