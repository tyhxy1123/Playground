package de.dresden.tu.others;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;

public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar cal = new GregorianCalendar(2099,12,31,21,53,54);
        timer.schedule(new MyTask(), cal.getTime(), 200);
    }
}
