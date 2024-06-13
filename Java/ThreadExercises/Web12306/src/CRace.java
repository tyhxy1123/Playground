import java.util.concurrent.*;

public class CRace implements Callable<Integer> {
    private String winner;
    @Override
    public Integer call() throws Exception {
        int steps = 100;
        for (int i = steps; i > 0 ; i--) {
            if(!gameOver()){
                System.out.println(Thread.currentThread().getName() + "-->" + i);
            }else{
                return steps;
            }
        }
        winner = Thread.currentThread().getName();
        System.out.println("Winner is: " + winner);
        return steps;
    }

    public boolean gameOver(){
        if(winner != null){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        CRace race = new CRace();
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //递交执行
        Future<Integer> result1 = ser.submit(race);
        Future<Integer> result2 = ser.submit(race);
        Integer r1 = null;
        Integer r2 = null;
        try {
            r1 = result1.get();
            r2 = result2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ser.shutdownNow();


    }
}
