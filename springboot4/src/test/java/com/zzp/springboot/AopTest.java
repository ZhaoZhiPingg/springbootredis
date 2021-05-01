package com.zzp.springboot;

import com.zzp.springboot.service.CalcService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
//@RunWith(SpringRunner.class)
public class AopTest {

    @Resource
    private CalcService calcService;

    @Test
    public void testAop4() {
        System.out.println("spring版本: " + SpringVersion.getVersion() + "\t" + "springboot版本: " + SpringBootVersion.getVersion());
        System.out.println("===========================================");
        calcService.div(10, 0);
    }

}
