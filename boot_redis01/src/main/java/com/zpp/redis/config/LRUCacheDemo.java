package com.zpp.redis.config;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo<K,V> extends  LinkedHashMap<K,V>{

    //缓存坑位
    private int capacity;

    /**
     *  accessOrder     the ordering mode -
     *  <tt>true</tt> for access-order,
     *  <tt>false</tt> for insertion-order
     *
     * @param capacity
     */
    public LRUCacheDemo(int capacity) {
        super(capacity,0.75F,false);
        this.capacity = capacity;
    }

    /**
     *  判断 队列的数量是否大于缓存设置
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);

        lruCacheDemo.put(1,"a");
        lruCacheDemo.put(2,"b");
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5,"e");
        System.out.println(lruCacheDemo.keySet());
    }
}
