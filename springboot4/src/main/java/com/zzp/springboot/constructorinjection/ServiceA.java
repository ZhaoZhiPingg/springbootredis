package com.zzp.springboot.constructorinjection;

import com.zzp.springboot.constructorinjection.ServiceB;
import org.springframework.stereotype.Component;

@Component
public class ServiceA {
    private ServiceB serviceB;

//    public ServiceA(ServiceB serviceB){
//        this.serviceB = serviceB;
//    }
}
