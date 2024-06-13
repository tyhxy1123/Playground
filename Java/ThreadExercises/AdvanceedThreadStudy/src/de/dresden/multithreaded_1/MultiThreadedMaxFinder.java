package de.dresden.multithreaded_1;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadedMaxFinder {
    public static int max(int[] data) throws ExecutionException, InterruptedException {
        if(data.length == 1){
            return data[0];
        }
        else if(data.length == 0){
            throw new IllegalArgumentException();
        }
        FindMax f1 = new FindMax(data, 0, data.length/2);
        FindMax f2 = new FindMax(data, data.length/2, data.length);
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(f1);
        Future<Integer> future2 = service.submit(f2);
        return Math.max(future1.get(), future2.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] data = {1,6,4,3,99,2,242,54,345,676,43,22};
        System.out.println(max(data));
    }
}
