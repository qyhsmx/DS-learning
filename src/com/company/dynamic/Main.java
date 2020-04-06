package com.company.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author qyhsmx@outlook.com
 * @date
 */
public class Main {
    public static void main(String[] args) {
        TestInterface instance = (TestInterface)Proxy.newProxyInstance(
                Main.class.getClassLoader(),
                new Class[]{TestInterface.class},
                new TestProxyHandler(new TestInterfaceImpl()));
        instance.request();
    }
}
