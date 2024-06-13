package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CostTimeInvocationHandler implements InvocationHandler {
    private Object target;

    public CostTimeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        double startTime = System.nanoTime();
        Object result = method.invoke(target, args);
        System.out.println("Total cost time: " + (System.nanoTime() - startTime));
        return result;
    }
}
