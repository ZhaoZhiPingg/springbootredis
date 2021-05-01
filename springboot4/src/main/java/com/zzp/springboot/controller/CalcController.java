package com.zzp.springboot.controller;

import com.zzp.springboot.service.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    @Autowired
    private CalcService calcService;

    @RequestMapping("/tt")
    public Object test(@RequestParam("a") int a,
                       @RequestParam("b") int b) {
        return calcService.div(a,b);
    }
}
