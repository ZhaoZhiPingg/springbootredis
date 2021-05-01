package com.zzp.springboot.service;


import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.lang.Nullable;

public class ClientSpringContainer {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        A a = context.getBean("a",A.class);
        B b = context.getBean("b",B.class);
    }


}
