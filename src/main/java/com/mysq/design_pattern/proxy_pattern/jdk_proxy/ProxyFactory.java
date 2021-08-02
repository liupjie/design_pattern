package com.mysq.design_pattern.proxy_pattern.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * 实现InvocationHandler接口，在创建代理对象时，将当前对象传入代理对象中
 */
public class ProxyFactory implements InvocationHandler {

    /**
     * 持有被代理对象的引用
     */
    private Object object;

    /**
     * 通过构造注入进行初始化
     */
    public ProxyFactory(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(object, args);
        after();
        return invoke;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    private void before() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis());
        System.out.println("proxy class can doing something here before access real subject");
    }

    private void after() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis());
        System.out.println("proxy class can doing something here after access real subject");
    }
}
