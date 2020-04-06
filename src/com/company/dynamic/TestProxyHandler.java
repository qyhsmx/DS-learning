package com.company.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class TestProxyHandler implements InvocationHandler {

    private Object target;

    public TestProxyHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行前的逻辑");
        System.out.println("proxy -> "+proxy.getClass().getName());
        System.out.println("method name -> "+method.getName());
        System.out.println("method arguments -> "+ Arrays.toString(args));
        if(method.getName().equals("request")){
            return method.invoke(target, args);
        }
        System.out.println("方法执行后的逻辑");
        return proxy;
    }
}
