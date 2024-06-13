public class Race implements Runnable{
    private String winner;
    @Override
    public void run() {
        int steps = 100;
        for (int i = steps; i > 0 ; i--) {
            if(!gameOver()){
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }else{
                return;
            }
        }
        winner = Thread.currentThread().getName();
        System.out.println("Winner is: " + winner);
    }

    public boolean gameOver(){
        if(winner != null){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "Rabbit").start();
        new Thread(race, "Tortoise").start();
    }
}
