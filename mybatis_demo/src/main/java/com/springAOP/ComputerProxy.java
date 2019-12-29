package com.springAOP;

import com.springAOP.service.Computer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Brian in 16:35 2018/3/21
 */
public class ComputerProxy {
    //    被代理的对象
    private Computer target;

    public ComputerProxy(Computer computer) {
        this.target = computer;
    }

    //    获取代理对象
    public Computer getComputerProxy() {
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                方法调用前的操作
                System.out.println("proxy class type: " + proxy.getClass());
                System.out.println("method name: " + method.getName() + " params: " + Arrays.asList(args));

                Object result = null;
                try {
                    // 前置通知
                    result = method.invoke(target, args);
                } catch (Exception e) {
                    e.printStackTrace();
                    // 异常通知，可以访问到方法出现时的异常
                }

                // 后置通知， 因为方法可能出现异常，所以访问不到方法的返回值
                System.out.println("== 方法执行后");

                return result;
            }
        };
        Computer com = (Computer) Proxy.newProxyInstance(loader, interfaces, h);
        return com;
    }
}







