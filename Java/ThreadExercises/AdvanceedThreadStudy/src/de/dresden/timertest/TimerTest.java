package de.dresden.timertest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;

public class TimerTest {
    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2019,10,15,22,07,01);
        Timer t1 = new Timer();
        t1.schedule(new MyTimerTask(),2000,5000);
    }
}
