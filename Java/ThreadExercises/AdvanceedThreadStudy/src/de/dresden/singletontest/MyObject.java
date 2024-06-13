package de.dresden.singletontest;

public class MyObject {
    private MyObject() {
    }

    private volatile static Object myObject;

    public static Object getInstance() {
        try {
            if (myObject != null) {
            } else {
                Thread.sleep(3000);
                synchronized (Object.class) {
                    if(myObject == null){
                        myObject = new Object();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myObject;
    }
}
