package com.zzp.springboot.service;

public class B {

    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B(){ // B无参构造
        System.out.println("---B created success");
    }

}
