package com.zzp.redis.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class GoodController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Value("${server.port}")
    private String serverPort;

    public static final String REDIS_LOCK = "zzpLock";

    @Autowired
    private Redisson redisson;

    @GetMapping("/buy_goods")
    public String buy_goods() throws Exception {
        RLock redissonLock = redisson.getLock(REDIS_LOCK);
        redissonLock.lock();
        try {

            // get key === 查看库存的数量够不够
            String result = stringRedisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.valueOf(result);
            if(goodsNumber > 0){
                int realNumber = goodsNumber -1;
                stringRedisTemplate.opsForValue().set("goods:001",String.valueOf(realNumber));
                System.out.println("成功买到商品，库存还剩下：" + realNumber + "件 \t 服务提供端口号：" + serverPort);
                return "成功买到商品，库存还剩下：" + realNumber + "件 \t 服务提供端口号：" + serverPort;
            }else {
                System.out.println("商品已经售完/活动结束/调用超时,欢迎下次光临" + "\t服务提供端口" + serverPort);
            }
            return "商品已经售完/活动结束/调用超时,欢迎下次光临" + "\t服务提供端口" + serverPort;
        }finally {
            redissonLock.unlock();
        }
    }

}
