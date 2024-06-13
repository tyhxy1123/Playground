package de.dresden.tu.thread;

public class LambdaThread {

    public static void main(String[] args) {
        ILike like = () -> {
            System.out.println("This is lambda!");
        };
        like.lambda();

        new Thread(()->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                System.out.println("This is " + name + "!!!!!");
            }

        }, "Thread1111").start();


    }

}

interface ILike{
    public void lambda();
}
