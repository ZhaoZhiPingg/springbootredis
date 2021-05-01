//package com.zzp.springboot.service;
//
//import org.springframework.beans.factory.ObjectFactory;
//import org.springframework.lang.Nullable;
//
//public class Dest {
//
//    @Nullable
//    protected Object getSingleton(String beanName, boolean allowEarlyReference) {
//        // 从 singletonObjects 获取实例，singletonObjects 中的实例都是准备好的 bean 实例，可以直接使用（一级缓存）
//        Object singletonObject = this.singletonObjects.get(beanName);
//        // isSingletonCurrentlyInCreation() 判断当前单例 bean 是否正在创建中
//        if (singletonObject == null && this.isSingletonCurrentlyInCreation(beanName)) {
//            synchronized(this.singletonObjects) {
//                // 一级缓存没有，就去二级缓存找
//                singletonObject = this.earlySingletonObjects.get(beanName);
//                if (singletonObject == null && allowEarlyReference) {
//                    // 二级缓存没有，就去三级缓存找
//                    ObjectFactory<?> singletonFactory = (ObjectFactory)this.singletonFactories.get(beanName);
//                    if (singletonFactory != null) {
//                        // 三级缓存有的话，就把它移动到二级缓存
//                        singletonObject = singletonFactory.getObject();
//                        this.earlySingletonObjects.put(beanName, singletonObject);
//                        this.singletonFactories.remove(beanName);
//                    }
//                }
//            }
//        }
//
//        return singletonObject;
//    }
//}
