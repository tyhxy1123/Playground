package service;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.Arrays;

public class Service2{
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{IService1.class, IService2.class});
        enhancer.setSuperclass(Service1.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            var start = System.nanoTime();
//            System.out.println("method: " + method.getName());
            var result = methodProxy.invokeSuper(o, objects);
            System.out.println("time: " + (System.nanoTime() - start));
            return result;
        });

        var proxy = enhancer.create();
        ((Service1) proxy).m1();
        ((Service1) proxy).m2();
        ((Service1) proxy).m();
        System.out.println(proxy.getClass());
        System.out.println(proxy.getClass().getSuperclass());
        Arrays.stream(proxy.getClass().getInterfaces()).forEach(it -> {
            System.out.println(it);
        });
    }
}
