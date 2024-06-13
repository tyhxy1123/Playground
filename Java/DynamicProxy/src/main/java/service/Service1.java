package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Service1 implements IService1, IService2 {

    @Override
    public void m1() {
        System.out.println("This is m1");
    }

    @Override
    public void m2() {
        System.out.println("This is m2");
    }

    public void m(){
        System.out.println("This is m");
    }

    public static void main(String[] args) {
        Service1 s1 = new Service1();
        CostTimeInvocationHandler handler = new CostTimeInvocationHandler(s1);
        Object proxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IService1.class, IService2.class}, handler );
        ((IService1)proxy).m1();
        ((IService2)proxy).m2();
    }
}
