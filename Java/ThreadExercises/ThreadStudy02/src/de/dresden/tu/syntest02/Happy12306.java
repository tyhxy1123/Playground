package de.dresden.tu.syntest02;

public class Happy12306 {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306(10, "梦巴黎");
        new Passenger(1, web12306, "老王").start();
        new Passenger(2, web12306, "小明").start();

//        new Thread(new Passenger(web12306, 1),"老王").start();
//        new Thread(new Passenger(web12306, 2),"小明").start();

    }
}
