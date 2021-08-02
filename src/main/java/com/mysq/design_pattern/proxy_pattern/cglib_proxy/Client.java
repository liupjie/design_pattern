package com.mysq.design_pattern.proxy_pattern.cglib_proxy;


public class Client {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        RealSubject proxy = (RealSubject) new ProxyFactory(subject).getProxyInstance();
        proxy.request();
    }
}
