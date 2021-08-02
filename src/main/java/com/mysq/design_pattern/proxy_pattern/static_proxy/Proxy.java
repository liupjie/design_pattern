package com.mysq.design_pattern.proxy_pattern.static_proxy;

/**
 * 代理类
 */
public class Proxy implements Subject {

    /**
     * 持有被代理对象的引用
     */
    private Subject subject;

    /**
     * 通过构造注入进行初始化
     */
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    /**
     * 在调用被代理对象的方法前后实现访问控制
     */
    @Override
    public void request() {
        //前置增强
        before();
        //调用代理对象的方法
        subject.request();
        //后置增强
        after();
    }

    private void before() {
        System.out.println("proxy class can doing something here before access real subject");
    }

    private void after() {
        System.out.println("proxy class can doing something here after access real subject");
    }
}
