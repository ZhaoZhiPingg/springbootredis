package com.zpp.redis.config;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo1 {

    // 思路：map 负责查找，构建一个虚拟的双向链表，它里面安装的就是一个个Node 节点，作为载体。

    // 第1步：构造一个Node节点，作为数据的载体
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node(){
            this.prev = this.next = null;
        }
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

    }

    // 第2步：构造一个虚拟的双向链表，里面安防的就是我们的Node
    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;

        // 第2.1步：构造方法
        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // 第2.2步：添加头
        public void addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 第2.3步：删除节点
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        // 第2.4步：获取最后一个节点
        public Node getLast(){
            return tail.prev;
        }

    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUCacheDemo1(int cacheSize){
        this.cacheSize = cacheSize;// 坑位
        map = new HashMap<>();// 查找
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);

        return node.value;
    }

    // savaOrUpdate method
    public void put(int key,int value){
        if(map.containsKey(key)){ // update
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if(map.size() == cacheSize){ // 坑位满了
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            // 最后是新增
            Node<Integer, Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCacheDemo1 lruCacheDemo = new LRUCacheDemo1(3);

        lruCacheDemo.put(1,1);
        lruCacheDemo.put(2,2);
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4,4);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3,3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5,5);
        System.out.println(lruCacheDemo.map.keySet());
    }
}
