package com.mysq.design_pattern.proxy_pattern.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类
 * 实现MethodInterceptor接口，在创建代理对象时，将当前对象传入代理对象中
 */
public class ProxyFactory implements MethodInterceptor {

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
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object invoke = method.invoke(object, objects);
        after();
        return invoke;
    }

    /**
     * 返回一个代理对象，是object对象的代理对象
     */
    public Object getProxyInstance() {
        //1.创建工具类
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(object.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类对象，即代理对象
        return enhancer.create();
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
