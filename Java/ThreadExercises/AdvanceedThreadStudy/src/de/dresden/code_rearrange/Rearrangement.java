package de.dresden.code_rearrange;

public class Rearrangement {
    public static int a = 0;
    public static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 1000; i++){
            a = 0;
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });
            Thread t2 = new Thread(()->{
                if(flag){
                    a *= 1;
                }
                if(a == 0){
                    System.out.println("Happen before");
                }
            });
            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }

    }
}
