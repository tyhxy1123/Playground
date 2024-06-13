package de.dresden.tu;

public class StatesTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for(int i = 0; i < 5; i++){
                try {
                    Thread.sleep(500);
            System.out.println("......");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(t1.getState());

        t1.start();
        Thread.State state = t1.getState();
        System.out.println(state);

        while(true){
            System.out.println("active count = " + Thread.activeCount() );
            System.out.println(t1.getState());
            Thread.sleep(50);
            if(t1.getState() == Thread.State.TERMINATED){
                System.out.println(t1.getState());
                System.out.println("active count = "+ Thread.activeCount());
                break;
            }
        }
        System.out.println("active count = "+Thread.activeCount());

    }
}
