package com.zzp.springboot.setterinjection;

import org.springframework.stereotype.Component;

@Component
public class ServiceAA {
    private ServiceBB serviceBB;

    public void setServiceBB(ServiceBB serviceBB){
        this.serviceBB = serviceBB;
        System.out.println("AA 里面设置了 BB");
    }
}
