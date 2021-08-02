package com.mysq.design_pattern.proxy_pattern.jdk_proxy;

public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxy = (Subject) new ProxyFactory(subject).getProxyInstance();
        proxy.request();
    }
}
