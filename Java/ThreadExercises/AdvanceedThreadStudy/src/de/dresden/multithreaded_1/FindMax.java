package de.dresden.multithreaded_1;

import java.util.concurrent.Callable;

public class FindMax implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public FindMax(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int max = Integer.MIN_VALUE;
        for(int i = start; i < end; i++){
            int tmp = data[i];
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }
}
