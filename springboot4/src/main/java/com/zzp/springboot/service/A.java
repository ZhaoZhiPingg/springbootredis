package com.zzp.springboot.service;

import org.springframework.beans.factory.ObjectFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class A {

    private B b;

    public B getB(){
        return b;
    }

    public void setB(B b){
        this.b = b;
    }

    public A(){ // A 无参构造
        System.out.println("---A created success");
    }

    /**
     * 单例对象缓存：bean 名称 -- bean 实例，即：所谓的单例池
     * 表示已经经历了完整生命周期的 Bean 对象
     * <b>第一级缓存<b/>
     */
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap(256);

    /**
     * 早期的单例对象的高速缓存： bean 名称 -- 实例
     * 表示 Bean 的生命周期还没走完（bean 的属性还未填充）就把这个 Bean 存入缓存中
     * 也就是实例化但为初始化的 bean 被放入该缓存里
     * <b>第二级缓存<b/>
     */
    private final Map<String, Object> earlySingletonObjects = new HashMap(16);

    /**
     * 单例工厂的高速缓存： bean 名称 -- ObjectFactory
     * 表示存放生成 bean 的工厂
     * <b>第三级缓存<b/>
     */
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap(16);
}

