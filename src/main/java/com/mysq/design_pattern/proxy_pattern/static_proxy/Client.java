package com.mysq.design_pattern.proxy_pattern.static_proxy;

public class Client {
    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();
    }
}
