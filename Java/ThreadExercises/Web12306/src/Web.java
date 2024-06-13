public class Web implements Runnable{
    private int ticketsAmount = 99;
    @Override
    public void run() {
        while(ticketsAmount > 0){
            System.out.println(Thread.currentThread().getName() + "-->" + ticketsAmount--);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
        }
    }
}
