package com.mysq.design_pattern.proxy_pattern.static_proxy;

/**
 * 真实的被代理类
 * 实现抽象的代理接口，实现具体的操作
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("RealSubject is doing request");
    }
}
