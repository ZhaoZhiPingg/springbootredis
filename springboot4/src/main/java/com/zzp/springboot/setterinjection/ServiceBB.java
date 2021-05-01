package com.zzp.springboot.setterinjection;

import org.springframework.stereotype.Component;

@Component
public class ServiceBB {
    private ServiceAA serviceAA;

    public void setServiceAA(ServiceAA serviceAA){
        this.serviceAA = serviceAA;
        System.out.println("BB 里面设置了 AA");
    }
}
