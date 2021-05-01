package com.zzp.springboot.service;

public class ClientCode {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        b.setA(a);
        a.setB(b);
    }
}
