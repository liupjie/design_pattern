package com.mysq.design_pattern.proxy_pattern.cglib_proxy;

/**
 * 真实的被代理类
 * 实现抽象的代理接口，实现具体的操作
 */
public final class RealSubject {

    public void request() {
        System.out.println("RealSubject is doing request");
    }
}
